package net.eitan.mccourse.item;

import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.block.ModBlocks;
import net.eitan.mccourse.entity.ModEntities;
import net.eitan.mccourse.entity.custom.PorcupineEntity;
import net.eitan.mccourse.item.custom.DataTabletItem;
import net.eitan.mccourse.item.custom.DiceItem;
import net.eitan.mccourse.item.custom.MetalDetectorItem;
import net.eitan.mccourse.item.custom.ModArmorItem;
import net.eitan.mccourse.item.custom.ModPosionSword;
import net.eitan.mccourse.item.custom.PaxelItem;
import net.eitan.mccourse.item.custom.RadiationStaffItem;
import net.eitan.mccourse.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet",
            new Item(new FabricItemSettings())
    );

    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",
            new Item(new FabricItemSettings().maxCount(16))
    );

    public static final Item METAL_DETECTOR = registerItem("metal_detector",
        new MetalDetectorItem(new FabricItemSettings().maxDamage(256))
    );

    public static final Item CAULIFLOWER = registerItem("cauliflower",
        new Item(new FabricItemSettings().food(ModFoodComponents.CAULIFLOWER))
    );

    public static final Item PEAT_BRICK = registerItem("peat_brick",
        new Item(new FabricItemSettings())
    );

    public static final Item PINK_GARNET_SWORD = registerItem("pink_garnet_sword",
        new ModPosionSword(ModToolMaterial.PINK_GARNET, 7, 20f, new FabricItemSettings())
    );

    public static final Item PINK_GARNET_PICKAXE = registerItem("pink_garnet_pickaxe",
        new PickaxeItem(ModToolMaterial.PINK_GARNET, 6, 1.5f, new FabricItemSettings())
    );

    public static final Item PINK_GARNET_SHOVEL = registerItem("pink_garnet_shovel",
        new ShovelItem(ModToolMaterial.PINK_GARNET, 2, 1f, new FabricItemSettings())
    );

    public static final Item PINK_GARNET_AXE = registerItem("pink_garnet_axe",
        new AxeItem(ModToolMaterial.PINK_GARNET, 10, 1.5f, new FabricItemSettings())
    );

    public static final Item PINK_GARNET_HOE = registerItem("pink_garnet_hoe",
        new HoeItem(ModToolMaterial.PINK_GARNET, -5, 100f, new FabricItemSettings())
    );

    public static final Item PINK_GARNET_PAXEL = registerItem("pink_garnet_paxel",
        new PaxelItem(ModToolMaterial.PINK_GARNET, 12, 10f, new FabricItemSettings())
    );

    public static final Item PINK_GARNET_HELMET = registerItem("pink_garnet_helmet",
        new ModArmorItem(ModArmorMaterial.PINK_GARNET, ArmorItem.Type.HELMET, new FabricItemSettings())
    );

    public static final Item PINK_GARNET_CHESTPLATE = registerItem("pink_garnet_chestplate",
        new ModArmorItem(ModArmorMaterial.PINK_GARNET, ArmorItem.Type.CHESTPLATE, new FabricItemSettings())
    );

    public static final Item PINK_GARNET_LEGGINGS = registerItem("pink_garnet_leggings",
        new ModArmorItem(ModArmorMaterial.PINK_GARNET, ArmorItem.Type.LEGGINGS, new FabricItemSettings())
    );

    public static final Item PINK_GARNET_BOOTS = registerItem("pink_garnet_boots",
        new ModArmorItem(ModArmorMaterial.PINK_GARNET, ArmorItem.Type.BOOTS, new FabricItemSettings())
    );

    public static final Item PINK_GARNET_HORSE_ARMOR = registerItem("pink_garnet_horse_armor",
        new HorseArmorItem(100, "pink_garnet", new FabricItemSettings())
    );

    public static final Item DATA_TABLET = registerItem("data_tablet",
        new DataTabletItem(new FabricItemSettings().maxCount(1))
    );

    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds",
        new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP, new FabricItemSettings())
    );

    public static final Item BAR_BRAWL_MUSIC_DISC = registerItem("bar_brawl_music_disc",
        new MusicDiscItem(9, ModSounds.BAR_BRAWL, new FabricItemSettings().maxCount(1), 122)
    );

    public static final Item RICKROLL_MUSIC_DISC = registerItem("rickroll_music_disc",
        new MusicDiscItem(9, ModSounds.RICKROLL, new FabricItemSettings().maxCount(1), 212)
    );

    public static final Item PINK_GARNET_SHIELD = registerItem("pink_garnet_shield",
            new ShieldItem(new FabricItemSettings().maxCount(1).maxDamage(500))
    );


    public static final Item RADIATION_STAFF = registerItem("radiation_staff",
            new RadiationStaffItem(new FabricItemSettings().maxCount(1).maxDamage(1024)));

    public static final Item PINK_GARNET_BOW = registerItem("pink_garnet_bow",
            new BowItem(new FabricItemSettings().maxCount(1).maxDamage(500)));

    public static final Item DRIFTWOOD_SIGN = registerItem("driftwood_sign",
        new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.DRIFTWOOD_SIGN, ModBlocks.DRIFTWOOD_WALL_SIGN));
    
    public static final Item DRIFTWOOD_HANGING_SIGN = registerItem("driftwood_hanging_sign",
        new HangingSignItem(ModBlocks.DRIFTWOOD_HANGING_SIGN, ModBlocks.DRIFTWOOD_HANGING_WALL_SIGN, new FabricItemSettings().maxCount(16)));

    public static final Item PORCUPINE_SPAWN_EGG = registerItem("porcupine_spawn_egg",
            new SpawnEggItem(ModEntities.PORCUPINE, 0xa86518, 0x3b260f, new FabricItemSettings()));

    public static final Item DICE = registerItem("dice",
        new DiceItem(new FabricItemSettings()));

    // Register a new item with a name, and the object item, the registries give the type to the Item
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(McCourse.MOD_ID, name), item);
    }

    private static void ItemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(PINK_GARNET);
        entries.add(RAW_PINK_GARNET);
        entries.add(ModBlocks.PINK_GARNET_BLOCK);
        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        entries.add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
        entries.add(ModBlocks.END_STONE_PINK_GARNET_ORE);
        entries.add(ModBlocks.NETHER_PINK_GARNET_ORE);
        entries.add(ModBlocks.PINK_GARNET_ORE);
    }

    public static void registerModItems() {
        McCourse.LOGGER.info("Registering Mod Items for " + McCourse.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::ItemGroupIngredients);
    }
}
