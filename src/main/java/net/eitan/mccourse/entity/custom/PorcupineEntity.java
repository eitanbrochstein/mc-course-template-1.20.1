package net.eitan.mccourse.entity.custom;

import net.eitan.mccourse.entity.ModEntities;
import net.eitan.mccourse.entity.ai.PorcupineAttackGoal;
import net.eitan.mccourse.entity.variant.PorcupineVariant;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.world.EntityView;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PorcupineEntity extends TameableEntity {
    private static final TrackedData<Boolean> ATTTACKING =
            DataTracker.registerData(PorcupineEntity.class, TrackedDataHandlerRegistry.BOOLEAN); // track if the entity is attacking

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(PorcupineEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public final AnimationState sitAnimationState = new AnimationState();

    public PorcupineEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        goalSelector.add(0, new SwimGoal(this));

        goalSelector.add(0, new SitGoal(this));

        goalSelector.add(1, new PorcupineAttackGoal(this, 1.1D, true));

        goalSelector.add(2, new FollowParentGoal(this, 1.1D));
        goalSelector.add(2, new FollowOwnerGoal(this, 1.1D, 10f, 3f, false));

        goalSelector.add(3, new WanderAroundFarGoal(this, 1.0D));
        goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        goalSelector.add(5, new LookAroundGoal(this));

        targetSelector.add(1, new RevengeGoal(this));
    }

    private void setupAnimationStates() {
        if (idleAnimationTimeout <= 0) {
            idleAnimationTimeout = this.random.nextInt(40) + 80;
            idleAnimationState.start(this.age);
        } else {
            --idleAnimationTimeout;
        }
        if (isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 40; // length of animation in ticks
            attackAnimationState.start(this.age);
        } else {
            --attackAnimationTimeout;
        }

        if (!isAttacking()) {
            attackAnimationState.stop();
        }

        if (isInSittingPose()) {
            sitAnimationState.startIfNotRunning(this.age);
        } else {
            sitAnimationState.stop();
        }
    }

    protected void updateLimbs(float v) {
        float f;
        if (getPose() == EntityPose.STANDING) {
            f = Math.min(v * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }
        limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();

        if (getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    @Override
    public boolean shouldRenderName() {
        return false;
    }

    public static DefaultAttributeContainer.Builder createPorcupineAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 12)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.PORCUPINE.create(world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        dataTracker.startTracking(ATTTACKING, false); // start tracking for attacking
        dataTracker.startTracking(DATA_ID_TYPE_VARIANT, 0);
    }

    @Override
    public void setAttacking(boolean attacking) {
        dataTracker.set(ATTTACKING, attacking); // set attacking true when mob attacks
    }

    public boolean isAttacking() {
        return dataTracker.get(ATTTACKING); // boolean for attacking
    }

    /* VARIANT */

    public PorcupineVariant getVariant() {
        return PorcupineVariant.byId(getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(PorcupineVariant variant) {
        dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        PorcupineVariant variant = Util.getRandom(PorcupineVariant.values(), random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", getTypeVariant());
        nbt.ou
    }

    /* SOUNDS */

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CAT_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_DOLPHIN_DEATH;
    }

    /* TAMEABLE */

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();

        Item itemForTaming = Items.APPLE;

        if (item == itemForTaming && !isTamed()) {
            if (getWorld().isClient()) {
                return ActionResult.CONSUME;
            } else {
                if (!player.getAbilities().creativeMode) {
                    itemStack.decrement(1);
                }

                if (!getWorld().isClient) {
                    super.setOwner(player);
                    navigation.recalculatePath();
                    setTarget(null);
                    getWorld().sendEntityStatus(this, (byte) 7);
                    setSitting(true);
                    setInSittingPose(true);

                    return ActionResult.SUCCESS;
                }
            }
        }

        if (isTamed() && hand == Hand.MAIN_HAND) {
            boolean sitting = !isSitting();
            setSitting(sitting);
            setInSittingPose(sitting);

            return ActionResult.SUCCESS;
        }

        return super.interactMob(player, hand);
    }

    @Override
    public EntityView method_48926() {
        return getWorld();
    }
}
