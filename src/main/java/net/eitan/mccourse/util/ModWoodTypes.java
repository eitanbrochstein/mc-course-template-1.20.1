package net.eitan.mccourse.util;

import net.eitan.mccourse.McCourse;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeRegistry;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class ModWoodTypes {
    public static final WoodType DRIFTWOOD = WoodTypeRegistry.register(new Identifier(McCourse.MOD_ID, "driftwood"), BlockSetType.OAK);
}
