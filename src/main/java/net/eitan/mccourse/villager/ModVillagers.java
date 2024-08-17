package net.eitan.mccourse.villager;

import com.google.common.collect.ImmutableSet;
import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> SOUND_POI_KEY = registerPoiKey("soundpoi");

    public static final PointOfInterestType SOUND_POI = registerPoi("soundpoi", ModBlocks.SOUND_BLOCK);

    public static final VillagerProfession SOUND_MASTER = registerProffesion("soundmaster", SOUND_POI_KEY);

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(McCourse.MOD_ID, name));
    }

    private static PointOfInterestType registerPoi(String name, Block soundBlock) {
        return PointOfInterestHelper.register(new Identifier(McCourse.MOD_ID, name), 1, 1, soundBlock);
    }

    private static VillagerProfession registerProffesion(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(McCourse.MOD_ID, name),
                new VillagerProfession(name, entry -> true, entry -> entry.matchesKey(type), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_CELEBRATE));
    }

    public static void registerVillagers() {
        McCourse.LOGGER.info("Registering Villagers for " + McCourse.MOD_ID);
    }

}
