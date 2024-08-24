package net.eitan.mccourse.recipe;

import net.eitan.mccourse.McCourse;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(McCourse.MOD_ID, GemEmpoweringRecipe.Serializer.ID),
                GemEmpoweringRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(McCourse.MOD_ID, GemEmpoweringRecipe.Type.ID),
                GemEmpoweringRecipe.Type.INSTANCE);
    }
}
