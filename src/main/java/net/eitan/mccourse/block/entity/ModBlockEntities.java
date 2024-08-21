package net.eitan.mccourse.block.entity;

import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<GemEmpoweringStationBlockEntity> GEM_EMPOWERING_STATION_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE,
                    new Identifier(McCourse.MOD_ID, "gem_empowering_block_entity"),
                    FabricBlockEntityTypeBuilder.create(GemEmpoweringStationBlockEntity::new, ModBlocks.GEM_EMPOWERING_STATION).build(null));

    public static void registerBlockEntites() {
        McCourse.LOGGER.info("Registering Block Entities for" + McCourse.MOD_ID);
    }
}
