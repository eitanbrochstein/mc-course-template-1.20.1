package net.eitan.mccourse.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.eitan.mccourse.block.custom.GemEmpoweringStationBlock;
import net.eitan.mccourse.item.ModItems;
import net.eitan.mccourse.recipe.GemEmpoweringRecipe;
import net.eitan.mccourse.screen.GemEmpoweringScreenHandler;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class GemEmpoweringStationBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int FLUID_ITEM_SLOT = 1;
    private static final int OUTPUT_SLOT = 2;
    private static final int ENERGY_ITEM_SLOT = 3;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public GemEmpoweringStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GEM_EMPOWERING_STATION_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                   case 0 -> GemEmpoweringStationBlockEntity.this.progress;
                   case 1 -> GemEmpoweringStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: GemEmpoweringStationBlockEntity.this.progress = value;
                    case 1: GemEmpoweringStationBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Gem Empowering Station");
    }

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(64000, 200, 200) {
        @Override
        protected void onFinalCommit() {
            markDirty();
            getWorld().updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    };

    // this code determines where the inputs from a hopper can go in, and be extracted, depending on every side

    // input

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(pos).get(GemEmpoweringStationBlock.FACING);

        if (side == Direction.DOWN) {
            return false;
        }

        if (side == Direction.UP) {
            return slot == INPUT_SLOT;
        }

        return switch (localDir) {
            default ->
                    side.getOpposite() == Direction.NORTH && slot == INPUT_SLOT ||
                            side.getOpposite() == Direction.WEST && slot == INPUT_SLOT;
            case EAST ->
                    side.rotateYClockwise() == Direction.NORTH && slot == INPUT_SLOT ||
                            side.rotateYClockwise() == Direction.WEST && slot == INPUT_SLOT;
            case SOUTH ->
                    side == Direction.NORTH && slot == INPUT_SLOT ||
                            side == Direction.WEST && slot == INPUT_SLOT;
            case WEST ->
                    side.rotateYCounterclockwise() == Direction.NORTH && slot == INPUT_SLOT ||
                            side.rotateYCounterclockwise() == Direction.WEST && slot == INPUT_SLOT;
        };
    }

    // output

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(GemEmpoweringStationBlock.FACING);

        if(side == Direction.UP) {
            return false;
        }

        // Down extract 2
        if(side == Direction.DOWN) {
            return slot == OUTPUT_SLOT;
        }

        // bottom extract 2
        // right extract 2
        return switch (localDir) {
            default ->  side.getOpposite() == Direction.SOUTH && slot == OUTPUT_SLOT ||
                    side.getOpposite() == Direction.EAST && slot == OUTPUT_SLOT;

            case EAST -> side.rotateYClockwise() == Direction.SOUTH && slot == OUTPUT_SLOT ||
                    side.rotateYClockwise() == Direction.EAST && slot == OUTPUT_SLOT;

            case SOUTH ->   side == Direction.SOUTH && slot == OUTPUT_SLOT ||
                    side == Direction.EAST && slot == OUTPUT_SLOT;

            case WEST -> side.rotateYCounterclockwise() == Direction.SOUTH && slot == OUTPUT_SLOT ||
                    side.rotateYCounterclockwise() == Direction.EAST && slot == OUTPUT_SLOT;
        };
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GemEmpoweringScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("gem_empowering_station.progress", progress);
        nbt.putLong(("gem_empowering_station.energy"), energyStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("gem_empowering_station.progress");
        energyStorage.amount = nbt.getLong("gem_empowering_station.energy");
        super.readNbt(nbt);
    }

    // main function
    public void tick(World world, BlockPos pos, BlockState state) {
        fillUpOnEnergy(); // until we have machines/other mods giving us energy

        if (canInsertIntoOutputSlot() && hasRecipe()) {
            increateCraftingProgress();
            extractEnergy();
            markDirty(world, pos, state);

            if (hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void extractEnergy() {
        try(Transaction transaction = Transaction.openOuter()) {
            this.energyStorage.extract(32L, transaction);
            transaction.commit();
        }
    }

    private void fillUpOnEnergy() {
        if (hasEnergyItemInEnergySlot(ENERGY_ITEM_SLOT)) {
            try(Transaction transaction = Transaction.openOuter()) {
                this.energyStorage.insert(64, transaction);
                transaction.commit();
            }
        }
    }

    private boolean hasEnergyItemInEnergySlot(int energyItemSlot) {
        return this.getStack(energyItemSlot).getItem() == ModItems.PEAT_BRICK;
    }

    private void craftItem() {
        Optional<GemEmpoweringRecipe> recipe = getCurrentRecipe();

        this.removeStack(INPUT_SLOT, 1);
        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().getOutput(null).getItem(), recipe.get().getOutput(null).getCount()));
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increateCraftingProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {

        Optional<GemEmpoweringRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        };
        ItemStack output = recipe.get().getOutput(null);
        return canInsertAmountIntoOutputSlot(output.getCount())
                && canInsertItemIntoOutputSlot(output) && hasEnoughEnergyToCraft();
    }

    private boolean hasEnoughEnergyToCraft() {
        return this.energyStorage.amount >= 32L * this.maxProgress;
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getStack(OUTPUT_SLOT).getMaxCount() >= this.getStack(OUTPUT_SLOT).getCount() + count;
    }

    private Optional<GemEmpoweringRecipe> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory(this.size());
        for (int i = 0; i < this.size(); i++) {
            inventory.setStack(i, this.getStack(i));
        }

        return this.getWorld().getRecipeManager().getFirstMatch(GemEmpoweringRecipe.Type.INSTANCE, inventory, this.getWorld());

    }

    private boolean canInsertIntoOutputSlot() {
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}
