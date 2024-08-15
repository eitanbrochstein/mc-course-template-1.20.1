package net.eitan.mccourse.effect;

import net.eitan.mccourse.McCourse;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final StatusEffect SLIMEY = regiterStatusEffect("slimey",
            // add attribute modifier adds the slowness to the effect
            new SlimeyEffect(StatusEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            "7107DE5E-7CE8-4030-940E-514C1F160890", -0.25f,
                            EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

    private static StatusEffect regiterStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(McCourse.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        McCourse.LOGGER.info("Registering Mod Effects for " + McCourse.MOD_ID);
    }
}
