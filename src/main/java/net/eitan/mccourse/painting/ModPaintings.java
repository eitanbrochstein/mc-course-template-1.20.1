package net.eitan.mccourse.painting;

import net.eitan.mccourse.McCourse;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPaintings {
    public static final PaintingVariant SAW_THEM = registerPainting("saw_them", new PaintingVariant(16, 16));
    public static final PaintingVariant SHRIMP = registerPainting("shrimp", new PaintingVariant(32, 16));
    public static final PaintingVariant WORLD = registerPainting("world", new PaintingVariant(16, 32));

    public static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(McCourse.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings() {
        McCourse.LOGGER.info("Registering Paintings for " + McCourse.MOD_ID);
    }
}
