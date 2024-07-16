package net.eitan.mccourse;

import net.eitan.mccourse.block.ModBlocks;
import net.eitan.mccourse.item.ModItemGroup;
import net.eitan.mccourse.item.ModItems;
import net.eitan.mccourse.util.ModRegistries;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.GraphicsMode;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.client.MinecraftClient;

public class McCourse implements ModInitializer {
	public static final String MOD_ID = "mc-course";
	
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Identifier rickroll = new Identifier("mc-course:rickroll");
	public static SoundEvent RICKROLL = SoundEvent.of(rickroll);

	GameOptions options = MinecraftClient.getInstance().options;
	GraphicsMode graphicsMode = options.getGraphicsMode().getValue();

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();
	}
}