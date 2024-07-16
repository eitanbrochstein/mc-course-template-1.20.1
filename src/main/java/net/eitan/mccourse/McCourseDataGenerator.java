package net.eitan.mccourse;

import net.eitan.mccourse.datagen.ModBlockTagProvider;
import net.eitan.mccourse.datagen.ModItemTagProvider;
import net.eitan.mccourse.datagen.ModLootGenerator;
import net.eitan.mccourse.datagen.ModModelProvider;
import net.eitan.mccourse.datagen.ModRecipeGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class McCourseDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootGenerator::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeGenerator::new);
	}
}
