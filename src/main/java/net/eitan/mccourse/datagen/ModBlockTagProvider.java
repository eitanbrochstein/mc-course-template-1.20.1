package net.eitan.mccourse.datagen;

import java.util.concurrent.CompletableFuture;

import net.eitan.mccourse.block.ModBlocks;
import net.eitan.mccourse.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BlockTags;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    
    @Override
    protected void configure(WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
        .add(ModBlocks.PINK_GARNET_ORE)
        .forceAddTag(BlockTags.GOLD_ORES)
        .forceAddTag(BlockTags.COAL_ORES)
        .forceAddTag(BlockTags.COPPER_ORES)
        .forceAddTag(BlockTags.DIAMOND_ORES)
        .forceAddTag(BlockTags.IRON_ORES)
        .forceAddTag(BlockTags.LAPIS_ORES)
        .forceAddTag(BlockTags.REDSTONE_ORES)
        .forceAddTag(BlockTags.EMERALD_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(
            ModBlocks.PINK_GARNET_ORE,
            ModBlocks.PINK_GARNET_BLOCK,
            ModBlocks.RAW_PINK_GARNET_BLOCK,
            ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
            ModBlocks.END_STONE_PINK_GARNET_ORE,
            ModBlocks.NETHER_PINK_GARNET_ORE
        );

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(
            ModBlocks.RAW_PINK_GARNET_BLOCK,
            ModBlocks.NETHER_PINK_GARNET_ORE,
            ModBlocks.END_STONE_PINK_GARNET_ORE
        );

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(
            ModBlocks.PINK_GARNET_BLOCK,
            ModBlocks.PINK_GARNET_ORE,
            ModBlocks.DEEPSLATE_PINK_GARNET_ORE
        );
    }
}
