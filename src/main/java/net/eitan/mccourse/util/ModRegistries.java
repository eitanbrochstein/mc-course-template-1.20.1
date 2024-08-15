package net.eitan.mccourse.util;

import net.eitan.mccourse.command.ReturnHomeCommand;
import net.eitan.mccourse.command.SetHomeCommand;
import net.eitan.mccourse.event.AttackEntityHandler;
import net.eitan.mccourse.event.PlayerCopyHandler;
import net.eitan.mccourse.item.ModItems;
import net.eitan.mccourse.mixin.BrewingRecipeRegistryMixin;
import net.eitan.mccourse.potion.ModPotions;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.ComposterBlock;
import net.minecraft.potion.Potions;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
        registerCompostables();
        registerCommands();
        registerEntity();
        registerPotionRecipes();
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.PEAT_BRICK, 200);
    }

    private static void registerCompostables() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CAULIFLOWER, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CAULIFLOWER_SEEDS, 0.25f);
    }

    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }

    private static void registerEntity() {
        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
        ServerPlayerEvents.COPY_FROM.register(new PlayerCopyHandler());
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.PINK_GARNET, ModPotions.SLIMEY_POTION);
    }
}
