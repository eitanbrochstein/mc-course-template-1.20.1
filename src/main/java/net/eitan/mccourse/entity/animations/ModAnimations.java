// Save this class in your mod and generate all required imports

/**
 * Made with Blockbench 4.11.1
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author Author
 */

package net.eitan.mccourse.entity.animations;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class ModAnimations {
    public static final Animation PORCUPINE_IDLE = Animation.Builder.create(2f).looping()
            .addBoneAnimation("torso",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0.35f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.875f, AnimationHelper.createTranslationalVector(0f, 0.4f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.25f, AnimationHelper.createTranslationalVector(0f, 0.4f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5f, AnimationHelper.createTranslationalVector(0f, 0.35f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.875f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("torso",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("skull",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.3433333f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5f, AnimationHelper.createTranslationalVector(0f, 0.2f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.9583433f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("skull",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(2f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(2f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(-2f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.25f, AnimationHelper.createRotationalVector(-2f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_front_leg",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.75f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_front_leg",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.9167666f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.7916767f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_back_leg",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.125f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.7916767f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_back_leg",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.2916767f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.9167667f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation PORCUPINE_WALK = Animation.Builder.create(2.5f).looping()
            .addBoneAnimation("torso",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.4167667f, AnimationHelper.createTranslationalVector(0f, 0f, -0.15f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.9583434f, AnimationHelper.createTranslationalVector(0f, 0f, -0.05f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0.05f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2.125f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_front_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.0834333f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.625f, AnimationHelper.createRotationalVector(-11f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2.0834335f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_front_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0.20834334f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5416766f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.0834333f, AnimationHelper.createRotationalVector(-11f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.2916767f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.875f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_back_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.3433333f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.875f, AnimationHelper.createRotationalVector(-11f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2.2916765f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_back_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.875f, AnimationHelper.createRotationalVector(-11f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5834333f, AnimationHelper.createRotationalVector(-7.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2.0834335f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();

    public static final Animation PORCUPINE_ATTACK = Animation.Builder.create(2.0F).looping()
		.addBoneAnimation("torso", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.4167F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0417F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5417F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.6667F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("torso", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5417F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("skull", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.4167F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0417F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.25F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5417F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.6667F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("skull", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("hair", new Transformation(Transformation.Targets.SCALE,
			new Keyframe(1.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0417F, AnimationHelper.createScalingVector(1.25F, 1.25F, 1.25F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.25F, AnimationHelper.createScalingVector(1.25F, 1.25F, 1.25F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("spikes", new Transformation(Transformation.Targets.SCALE,
			new Keyframe(1.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0417F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.25F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("spikes2", new Transformation(Transformation.Targets.SCALE,
			new Keyframe(1.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0417F, AnimationHelper.createScalingVector(1.25F, 1.25F, 1.25F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.25F, AnimationHelper.createScalingVector(1.25F, 1.25F, 1.25F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("spikes3", new Transformation(Transformation.Targets.SCALE,
			new Keyframe(1.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0417F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.25F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("spikes4", new Transformation(Transformation.Targets.SCALE,
			new Keyframe(1.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0417F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.25F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("spikes5", new Transformation(Transformation.Targets.SCALE,
			new Keyframe(1.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0417F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.25F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("spikes6", new Transformation(Transformation.Targets.SCALE,
			new Keyframe(1.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0417F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.25F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("spikes7", new Transformation(Transformation.Targets.SCALE,
			new Keyframe(1.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0417F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.25F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("spikes8", new Transformation(Transformation.Targets.SCALE,
			new Keyframe(1.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0417F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.25F, AnimationHelper.createScalingVector(1.15F, 1.15F, 1.15F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.25F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.25F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("right_back_leg", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.25F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("right_back_leg", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("left_back_leg", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.25F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("left_back_leg", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
            new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .build();

    public static final Animation PORCUPINE_SIT = Animation.Builder.create(2f).looping()
            .addBoneAnimation("porcupine",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("torso",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -0.3f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.4583433f, AnimationHelper.createTranslationalVector(0f, 0.3f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.125f, AnimationHelper.createTranslationalVector(0f, 0.5f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.7916767f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, -0.3f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("torso",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-15f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("skull",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_front_leg",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createTranslationalVector(0f, 0.25f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_front_leg",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createTranslationalVector(0f, 0.25f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_back_leg",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -1f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.25f, AnimationHelper.createTranslationalVector(0f, -0.75f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2f, AnimationHelper.createTranslationalVector(0f, -1f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_back_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_back_leg",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -1f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.25f, AnimationHelper.createTranslationalVector(0f, -0.75f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.9583433f, AnimationHelper.createTranslationalVector(0f, -1f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_back_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
}