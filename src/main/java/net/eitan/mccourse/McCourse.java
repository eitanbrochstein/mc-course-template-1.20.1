package net.eitan.mccourse;

import net.eitan.mccourse.block.ModBlocks;
import net.eitan.mccourse.effect.ModEffects;
import net.eitan.mccourse.enchantment.ModEnchantments;
import net.eitan.mccourse.item.ModItemGroup;
import net.eitan.mccourse.item.ModItems;
import net.eitan.mccourse.painting.ModPaintings;
import net.eitan.mccourse.particle.ModParticles;
import net.eitan.mccourse.potion.ModPotions;
import net.eitan.mccourse.sound.ModSounds;
import net.eitan.mccourse.util.ModLootTableModifiers;
import net.eitan.mccourse.util.ModRegistries;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class McCourse implements ModInitializer {
	public static final String MOD_ID = "mc-course";
	
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();

		ModEnchantments.regiserModEnchantments();

		ModSounds.registerSounds();
		ModLootTableModifiers.modifyLootTables();
		ModPaintings.registerPaintings();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModParticles.registerParticles();
	}
}