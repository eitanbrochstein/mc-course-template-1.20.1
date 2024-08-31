package net.eitan.mccourse.screen;

import net.eitan.mccourse.block.entity.GemEmpoweringStationBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public class GemEmpoweringScreenHandler extends ScreenHandler {

    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final GemEmpoweringStationBlockEntity blockEntity;

    public GemEmpoweringScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(2));
    }

    public GemEmpoweringScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.GEM_EMPOWERING_SCREEN_HANDLER_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) blockEntity), 4); // 4 because 4 slots
        this.inventory = ((Inventory) blockEntity);
        this.propertyDelegate = arrayPropertyDelegate;
        this.blockEntity = ((GemEmpoweringStationBlockEntity) blockEntity);

        this.addSlot(new Slot(inventory, 0, 80, 11));
        this.addSlot(new Slot(inventory, 1, 26, 59));
        this.addSlot(new Slot(inventory, 2, 80, 59));
        this.addSlot(new Slot(inventory, 3, 134, 59));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(arrayPropertyDelegate);
    }

    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int progressArrowSize = 26;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress: 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invslot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invslot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invslot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
