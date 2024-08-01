package net.eitan.mccourse.datagen;

import net.eitan.mccourse.block.ModBlocks;
import net.eitan.mccourse.block.custom.CauliflowerCropBlock;
import net.eitan.mccourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

public class ModLootGenerator extends FabricBlockLootTableProvider {

    public ModLootGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }
    
    @Override
    public void generate() {
        addDrop(ModBlocks.PINK_GARNET_ORE);
        addDrop(ModBlocks.RAW_PINK_GARNET_BLOCK);
        addDrop(ModBlocks.PINK_GARNET_SLAB, slabDrops(ModBlocks.PINK_GARNET_SLAB));
        addDrop(ModBlocks.PINK_GARNET_STAIRS);
        addDrop(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        addDrop(ModBlocks.PINK_GARNET_BUTTON);
        addDrop(ModBlocks.PINK_GARNET_FENCE);
        addDrop(ModBlocks.PINK_GARNET_FENCE_GATE);
        addDrop(ModBlocks.PINK_GARNET_WALL);
        addDrop(ModBlocks.PINK_GARNET_DOOR, doorDrops(ModBlocks.PINK_GARNET_DOOR));
        addDrop(ModBlocks.PINK_GARNET_TRAPDOOR);

        // silk touch, non silk touch
        addDrop(ModBlocks.PINK_GARNET_ORE, oreDrops(ModBlocks.PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        addDrop(ModBlocks.DEEPSLATE_PINK_GARNET_ORE, oreDrops(ModBlocks.DEEPSLATE_PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        addDrop(ModBlocks.NETHER_PINK_GARNET_ORE, oreDrops(ModBlocks.NETHER_PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        addDrop(ModBlocks.END_STONE_PINK_GARNET_ORE, oreDrops(ModBlocks.END_STONE_PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.CAULIFLOWER_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CauliflowerCropBlock.AGE, 6));
        this.addDrop(ModBlocks.CAULIFLOWER_CROP, this.cropDrops(ModBlocks.CAULIFLOWER_CROP, ModItems.CAULIFLOWER, ModItems.CAULIFLOWER_SEEDS, builder2));
    }
}
