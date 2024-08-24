package net.eitan.mccourse.datagen;

import java.util.List;
import java.util.function.Consumer;

import net.eitan.mccourse.block.ModBlocks;
import net.eitan.mccourse.datagen.recipe.GemEmpoweringRecipeBuilder;
import net.eitan.mccourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }
    
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK)
        .pattern("SSS")
        .pattern("SSS")
        .pattern("SSS")
        .input('S', ModItems.RAW_PINK_GARNET)
        .criterion(FabricRecipeProvider.hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
        .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PINK_GARNET_BLOCK) + "_"));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PINK_GARNET, RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK);

        offerSmelting(exporter, List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE, ModBlocks.NETHER_PINK_GARNET_ORE, ModBlocks.END_STONE_PINK_GARNET_ORE), RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
        offerBlasting(exporter, List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE, ModBlocks.NETHER_PINK_GARNET_ORE, ModBlocks.END_STONE_PINK_GARNET_ORE), RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");

        new GemEmpoweringRecipeBuilder(ModItems.RAW_PINK_GARNET, ModItems.PINK_GARNET, 3)
        .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
        .offerTo(exporter);

        new GemEmpoweringRecipeBuilder(Items.COAL, Items.DIAMOND, 7)
        .criterion(hasItem(Items.COAL), conditionsFromItem(ModItems.PINK_GARNET))
        .offerTo(exporter);

        new GemEmpoweringRecipeBuilder(Items.STICK, Items.END_ROD, 1)
        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.COAL))
        .offerTo(exporter);

        new GemEmpoweringRecipeBuilder(Items.REDSTONE, Items.EMERALD, 8)
        .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
        .offerTo(exporter);
    }
}
