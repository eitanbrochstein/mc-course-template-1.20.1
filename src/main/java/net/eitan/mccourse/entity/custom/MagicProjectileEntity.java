package net.eitan.mccourse.entity.custom;

import net.eitan.mccourse.painting.ModPaintings;
import net.eitan.mccourse.particle.ModParticles;
import net.eitan.mccourse.sound.ModSounds;
import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ModStatus;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MagicProjectileEntity extends ProjectileEntity {
    public static final TrackedData<Boolean> HIT =
            DataTracker.registerData(MagicProjectileEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int counter = 0;
    public MagicProjectileEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();

        if (dataTracker.get(HIT)) {
            if (age >= counter) {
                discard();
            }
        }

        if (age >= 300) {
            remove(RemovalReason.DISCARDED);
        }

        Vec3d vec3 = getVelocity();
        HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
        if (hitResult.getType() != HitResult.Type.MISS) {
            onCollision(hitResult);
        }

        double d0 = getX() + vec3.x;
        double d1 = getY() + vec3.y;
        double d2 = getZ() + vec3.z;
        updateRotation();

        double d5 = vec3.x;
        double d6 = vec3.y;
        double d7 = vec3.z;

        for (int i = 1; i < 5; i++) {
            getWorld().addParticle(ModParticles.PINK_GARNET_PARTICLE, d0-(d5*2), d1-(d6*2), d2-(d7*2),
                    -d5, -d6 - 0.1D, -d7);
        }

        if (getWorld().getStatesInBox(getBoundingBox()).noneMatch(AbstractBlock.AbstractBlockState::isAir)) {
            discard();
        } else if (isInsideWaterOrBubbleColumn()) {
            discard();
        } else {
            setVelocity(vec3.multiply(0.99F));
            setPos(d0, d1, d2);
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);

        Entity hitEntity = entityHitResult.getEntity();
        Entity owner = getOwner();

        // dont hit ourself lol
        if (hitEntity == owner && getWorld().isClient()) {
            return;
        }

        getWorld().playSound(null, getX(), getY(), getZ(), ModSounds.METAL_DETECTOR_FOUND_ORE, SoundCategory.NEUTRAL,
                2F, 1F);

        LivingEntity livingEntity = owner instanceof LivingEntity ? (LivingEntity) owner : null;
        float damage = 2f;
        boolean hurt = hitEntity.damage(getDamageSources().mobProjectile(this, livingEntity), damage);
        if (hurt) {
            if (hitEntity instanceof LivingEntity livingHitEntity) {
                livingHitEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1), owner);
            }
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        for (int x = 0; x < 18; x++) {
            for (int y = 0; y < 18; y++) {
                getWorld().addParticle(ModParticles.PINK_GARNET_PARTICLE, getX(), getY(), getZ(),
                        Math.cos(x*20) * 0.15d, Math.cos(y*20) * 0.15d, Math.sin(x*20) * 0.15d);
            }
        }

        if (getWorld().isClient()) {
            return;
        }

        if (hitResult.getType() == HitResult.Type.ENTITY && hitResult instanceof EntityHitResult entityHitResult) {
            Entity hit = entityHitResult.getEntity();
            Entity owner = getOwner();

            if (owner != hit) {
                dataTracker.set(HIT, true);
                counter = age + 5;
            }
        } else {
            dataTracker.set(HIT, true);
            counter = age + 5;
        }
    }

    @Override
    protected void initDataTracker() {
        dataTracker.set(HIT, false);
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }
}
