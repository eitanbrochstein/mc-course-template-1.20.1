package net.eitan.mccourse.item.custom;

import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.entity.custom.MagicProjectileEntity;
import net.eitan.mccourse.sound.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RadiationStaffItem extends Item {

    public RadiationStaffItem(Settings settings) {
        super(settings);
    }

    // use() for right clicking
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.METAL_DETECTOR_FOUND_ORE, SoundCategory.NEUTRAL, 1.5F, 1F);
        // cooldown
        user.getItemCooldownManager().set(this, 40);
        // spawn if not client
        if (!world.isClient()) {
            MagicProjectileEntity magicProjectile = new MagicProjectileEntity(world, user);
            magicProjectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0.25F);
            world.spawnEntity(magicProjectile);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));

        // check if in creative
        if (!user.getAbilities().creativeMode) {
            itemStack.damage(1, user, p -> {p.sendToolBreakStatus(hand);});
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
    
}
