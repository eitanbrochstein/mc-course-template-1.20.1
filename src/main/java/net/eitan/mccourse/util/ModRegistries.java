package net.eitan.mccourse.util;

import net.eitan.mccourse.event.AttackEntityHandler;
import net.eitan.mccourse.item.ModItems;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.ComposterBlock;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
        registerCompostables();
        registerEntity();
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.PEAT_BRICK, 200);
    }

    private static void registerCompostables() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CAULIFLOWER, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CAULIFLOWER_SEEDS, 0.25f);
    }

    private static void registerEntity() {
        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
    }
}
