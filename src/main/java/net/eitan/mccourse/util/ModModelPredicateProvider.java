package net.eitan.mccourse.util;

import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {
    public static void registerModModels() {
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET, new Identifier(McCourse.MOD_ID, "on"), (stack, world, entity, set) -> stack.hasNbt() ? 1f: 0f);
    }
}
