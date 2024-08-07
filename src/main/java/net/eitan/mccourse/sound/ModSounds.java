package net.eitan.mccourse.sound;

import net.eitan.mccourse.McCourse;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent RICKROLL = registerSoundEvent("rickroll");
    public static final SoundEvent METAL_DETECTOR_FOUND_ORE = registerSoundEvent("metal_detector_found_ore");

    public static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(McCourse.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        McCourse.LOGGER.info("Registering Mod Sounds for " + McCourse.MOD_ID);
    }
}
