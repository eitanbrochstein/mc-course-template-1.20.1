package net.eitan.mccourse.datagen;

import java.util.concurrent.CompletableFuture;

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
    }
}
