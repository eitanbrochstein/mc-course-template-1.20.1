package net.eitan.mccourse.entity.layer;

import net.eitan.mccourse.McCourse;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer PORCUPINE = new EntityModelLayer(
            new Identifier(McCourse.MOD_ID, "porcupine"),
            "main"
    );
}
