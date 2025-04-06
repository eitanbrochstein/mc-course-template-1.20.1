package net.eitan.mccourse.world.tree;

import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.mixin.TrunkPlacerTypeInvoker;
import net.eitan.mccourse.world.tree.custom.DriftwoodTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> DRIFTWOOD_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("driftwood_trunk_placer",
            DriftwoodTrunkPlacer.CODEC);

    public static void register() {
        McCourse.LOGGER.info("Registering Trunk Placer for: " + McCourse.MOD_ID);
    }
}