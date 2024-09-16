package net.eitan.mccourse.datagen;

import java.util.concurrent.CompletableFuture;

import net.eitan.mccourse.block.ModBlocks;
import net.eitan.mccourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.ItemTags;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }
    
    @Override
    protected void configure(WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(
            ModItems.PINK_GARNET_HELMET,
            ModItems.PINK_GARNET_CHESTPLATE,
            ModItems.PINK_GARNET_LEGGINGS,
            ModItems.PINK_GARNET_BOOTS
        );

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS).add(
                ModItems.BAR_BRAWL_MUSIC_DISC,
                ModItems.RICKROLL_MUSIC_DISC
        );

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
            .add(ModBlocks.DRIFTWOOD_LOG.asItem(), ModBlocks.DRIFTWOOD_WOOD.asItem(), 
                ModBlocks.STRIPPED_DRIFTWOOD_LOG.asItem(), ModBlocks.STRIPPED_DRIFTWOOD_WOOD.asItem());
        
        getOrCreateTagBuilder(ItemTags.PLANKS)
            .add(ModBlocks.DRIFTWOOD_PLANKS.asItem());
    }
}
