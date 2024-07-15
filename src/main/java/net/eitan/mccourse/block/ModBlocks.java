package net.eitan.mccourse.block;

import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.block.custom.SoundBlock;
import net.eitan.mccourse.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)),
            Rarity.EPIC
            // also create() to make your own rules
    );

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock(
            "raw_pink_garnet_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)),
            Rarity.RARE
            // also create() to make your own rules
    );

    public static final Block DEEPSLATE_PINK_GARNET_ORE = registerBlock(
            "deepslate_pink_garnet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE), UniformIntProvider.create(200, 400)),
            Rarity.RARE
    );

    public static final Block END_STONE_PINK_GARNET_ORE = registerBlock(
            "end_stone_pink_garnet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE), UniformIntProvider.create(500, 1000)),
            Rarity.EPIC
    );

    public static final Block NETHER_PINK_GARNET_ORE = registerBlock(
            "nether_pink_garnet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK), UniformIntProvider.create(400, 600)),
            Rarity.UNCOMMON
    );

    public static final Block PINK_GARNET_ORE = registerBlock(
            "pink_garnet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE), UniformIntProvider.create(100, 200)),
            Rarity.RARE
    );

    public static final Block SOUND_BLOCK = registerBlock(
        "sound_block",
        new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)),
        Rarity.COMMON 
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
