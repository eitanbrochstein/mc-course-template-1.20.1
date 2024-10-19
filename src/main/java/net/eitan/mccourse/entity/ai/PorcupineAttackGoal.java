package net.eitan.mccourse.entity.ai;

import net.eitan.mccourse.entity.custom.PorcupineEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Hand;

public class PorcupineAttackGoal extends MeleeAttackGoal {
    private final PorcupineEntity entity;
    private int attackDelay = 20;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    public PorcupineAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((PorcupineEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        ticksUntilNextAttack = 20;
    }

    @Override
    protected void attack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            shouldCountTillNextAttack = true;

            if (isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if (isTimeToAttack()) {
                mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= getSquaredMaxAttackDistance(pEnemy);
    }

    protected void resetAttackCooldown() {
        ticksUntilNextAttack = getTickCount(attackDelay*2);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack() {
        return ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        resetAttackCooldown();
        mob.swingHand(Hand.MAIN_HAND);
        mob.tryAttack(pEnemy);
    }

    // like draw method, checks every tick
    @Override
    public void tick() {
        super.tick();
        if (shouldCountTillNextAttack) {
            ticksUntilNextAttack = Math.max(ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
