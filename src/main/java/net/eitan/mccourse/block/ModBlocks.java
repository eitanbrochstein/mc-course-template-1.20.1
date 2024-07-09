package net.eitan.mccourse.block;

import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).breakInstantly()),
            Rarity.EPIC
            // also create() to make your own rules
    );

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock(
            "raw_pink_garnet_block",
            new Block(FabricBlockSettings.create().collidable(true).strength(10).hardness(10)),
            Rarity.RARE
            // also create() to make your own rules
    );

    public static final Block DEEPSLATE_PINK_GARNET_ORE = registerBlock(
            "deepslate_pink_garnet_ore",
            new Block(FabricBlockSettings.create().collidable(true).hardness(3)),
            Rarity.RARE
    );

    public static final Block END_STONE_PINK_GARNET_ORE = registerBlock(
            "end_stone_pink_garnet_ore",
            new Block(FabricBlockSettings.create().collidable(true).hardness(6)),
            Rarity.EPIC
    );

    public static final Block NETHER_PINK_GARNET_ORE = registerBlock(
            "nether_pink_garnet_ore",
            new Block(FabricBlockSettings.create().collidable(true).strength(1,1)),
            Rarity.UNCOMMON
    );

    public static final Block PINK_GARNET_ORE = registerBlock(
            "pink_garnet_ore",
            new Block(FabricBlockSettings.create().collidable(true).strength(2, 3)),
            Rarity.RARE
    );

    private static Block registerBlock(String name, Block block, Rarity rarity) {
        registerBlockItem(name, block, rarity);
        // minecraft type, name with mod id, block itself
        return Registry.register(Registries.BLOCK, new Identifier(McCourse.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, Rarity rarity) {
        return Registry.register(Registries.ITEM, new Identifier(McCourse.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().rarity(rarity))
        );
    }

    public static void registerModBlocks() {
        McCourse.LOGGER.info("Registering ModBlocks for " + McCourse.MOD_ID);
    }
}
