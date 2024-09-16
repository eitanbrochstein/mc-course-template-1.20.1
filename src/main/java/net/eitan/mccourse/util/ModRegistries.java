package net.eitan.mccourse.util;

import net.eitan.mccourse.block.ModBlocks;
import net.eitan.mccourse.command.ReturnHomeCommand;
import net.eitan.mccourse.command.SetHomeCommand;
import net.eitan.mccourse.event.AttackEntityHandler;
import net.eitan.mccourse.event.PlayerCopyHandler;
import net.eitan.mccourse.item.ModItems;
import net.eitan.mccourse.mixin.BrewingRecipeRegistryMixin;
import net.eitan.mccourse.potion.ModPotions;
import net.eitan.mccourse.villager.ModVillagers;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
        registerCompostables();
        registerCommands();
        registerEntity();
        registerPotionRecipes();
        registerCustomTrades();
        registerStrippables();
        registerFlammables();
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

    private static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LEAVES, 5, 30);
    }


    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_LOG, ModBlocks.STRIPPED_DRIFTWOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_WOOD, ModBlocks.STRIPPED_DRIFTWOOD_WOOD); 
    }

    private static void registerEntity() {
        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
        ServerPlayerEvents.COPY_FROM.register(new PlayerCopyHandler());
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.PINK_GARNET, ModPotions.SLIMEY_POTION);
    }

    private static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, Factories -> {
            Factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.CAULIFLOWER, 2),
                    12,
                    2,
                    0.02f
            )));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1, Factories -> {
            Factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 26),
                    new ItemStack(ModItems.PINK_GARNET_PAXEL, 1),
                    6,
                    2,
                    0.05f
            )));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 1, Factories -> {
            Factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.RADIATION_STAFF, 1),
                    6,
                    2,
                    0.05f
            )));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 1, Factories -> {
            Factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(Items.NOTE_BLOCK, 1),
                    6,
                    2,
                    0.05f
            )));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 2, Factories -> {
            Factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(ModItems.RICKROLL_MUSIC_DISC, 1),
                    6,
                    2,
                    0.05f
            )));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 2, Factories -> {
            Factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(ModItems.BAR_BRAWL_MUSIC_DISC, 1),
                    6,
                    2,
                    0.05f
            )));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 3, Factories -> {
            Factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 20),
                    new ItemStack(ModItems.METAL_DETECTOR, 1),
                    6,
                    2,
                    0.05f
            )));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 3, Factories -> {
            Factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 32),
                    new ItemStack(ModBlocks.GEM_EMPOWERING_STATION, 1),
                    6,
                    2,
                    0.05f
            )));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 4, Factories -> {
            Factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.PINK_GARNET, 1),
                    new ItemStack(Items.EMERALD, 3),
                    12,
                    2,
                    0.05f
            )));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 4, Factories -> {
            Factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(ModItems.PINK_GARNET_AXE, 1),
                    6,
                    2,
                    0.05f
            )));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 4, Factories -> {
            Factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 17),
                    new ItemStack(ModItems.PINK_GARNET_SWORD, 1),
                    6,
                    2,
                    0.05f
            )));
        });
    }
}
