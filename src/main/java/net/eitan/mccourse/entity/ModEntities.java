package net.eitan.mccourse.entity;

import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.entity.custom.PorcupineEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<PorcupineEntity> PORCUPINE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(McCourse.MOD_ID, "porcupine"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PorcupineEntity::new).dimensions(EntityDimensions.fixed(
                    0.75f, // width of hitbox
                    0.75f // height of hitbox
            )).build());

    public static void registerModEntites() {
        McCourse.LOGGER.info("Registering Mod Entities for " + McCourse.MOD_ID);
    }
}