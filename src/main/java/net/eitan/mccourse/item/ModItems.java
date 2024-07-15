package net.eitan.mccourse.item;

import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.block.ModBlocks;
import net.eitan.mccourse.item.custom.MetalDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
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
