package net.eitan.mccourse.world.tree;

import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.mixin.FoliagerPlacerTypesInvoker;
import net.eitan.mccourse.world.tree.custom.DriftwoodFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> DRIFTWOOD_FOLIAGE_PLACER = FoliagerPlacerTypesInvoker.callRegister(
            "driftwood_foliage_placer", DriftwoodFoliagePlacer.CODEC);
    public static void register() {
        McCourse.LOGGER.info("Registering the Foliage Placers for " + McCourse.MOD_ID);
    }
}
