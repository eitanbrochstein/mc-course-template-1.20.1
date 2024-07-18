package net.eitan.mccourse.block;

import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.block.custom.SoundBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
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

    public static final Block PINK_GARNET_STAIRS = registerBlock(
        "pink_garnet_stairs",
        new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)),
        Rarity.UNCOMMON
    );

    public static final Block PINK_GARNET_SLAB = registerBlock(
        "pink_garnet_slab",
        new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB)),
        Rarity.UNCOMMON
    );

    public static final Block PINK_GARNET_BUTTON = registerBlock(
        "pink_garnet_button",
        new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON), BlockSetType.IRON, 10, true),
        Rarity.UNCOMMON
    );

    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock(
        "pink_garnet_pressure_plate",
        new PressurePlateBlock(ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.NETHER_BRICK_FENCE), BlockSetType.IRON),
        Rarity.UNCOMMON
    );

    public static final Block PINK_GARNET_FENCE = registerBlock(
        "pink_garnet_fence",
        new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)),
        Rarity.UNCOMMON
    );

    public static final Block PINK_GARNET_FENCE_GATE = registerBlock(
        "pink_garnet_fence_gate",
        new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.ACACIA),
        Rarity.UNCOMMON
    );

    public static final Block PINK_GARNET_WALL = registerBlock(
        "pink_garnet_wall",
        new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)),
        Rarity.UNCOMMON
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
