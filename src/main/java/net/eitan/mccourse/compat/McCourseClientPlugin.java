package net.eitan.mccourse.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.eitan.mccourse.block.ModBlocks;
import net.eitan.mccourse.recipe.GemEmpoweringRecipe;
import net.eitan.mccourse.screen.GemEmpoweringScreen;

public class McCourseClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new GemEmpoweringCategory());

        registry.addWorkstations(GemEmpoweringCategory.GEM_EMPOWERING, EntryStacks.of(ModBlocks.GEM_EMPOWERING_STATION));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(GemEmpoweringRecipe.class, GemEmpoweringRecipe.Type.INSTANCE,
                GemEmpoweringDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), GemEmpoweringScreen.class,
                GemEmpoweringCategory.GEM_EMPOWERING);
    }
}
