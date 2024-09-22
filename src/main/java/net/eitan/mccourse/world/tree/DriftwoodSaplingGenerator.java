package net.eitan.mccourse.world.tree;

import blue.endless.jankson.annotation.Nullable;
import net.eitan.mccourse.world.ModConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class DriftwoodSaplingGenerator extends SaplingGenerator {

    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random arg0, boolean arg1) {
        return ModConfiguredFeatures.DRIFTWOOD_KEY;
    }
    
}
