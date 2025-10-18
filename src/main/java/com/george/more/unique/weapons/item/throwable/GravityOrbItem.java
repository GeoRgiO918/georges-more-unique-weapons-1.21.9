package com.george.more.unique.weapons.item.throwable;

import com.george.more.unique.weapons.entity.GravityOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public class GravityOrbItem extends Item implements ProjectileItem {

    public static float POWER = 1.5F;

    public GravityOrbItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        world.playSound(
                null,
                user.getX(),
                user.getY(),
                user.getZ(),
                SoundEvents.ENTITY_ENDER_PEARL_THROW,
                SoundCategory.NEUTRAL,
                0.5F,
                0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );

        if (world instanceof ServerWorld serverWorld) {
            GravityOrbEntity orb = new GravityOrbEntity(serverWorld, user,itemStack);
            orb.setItem(itemStack);
            orb.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, POWER, 1.0F);
            serverWorld.spawnEntity(orb);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        itemStack.decrementUnlessCreative(1, user);

        return ActionResult.SUCCESS;
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        return new GravityOrbEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack);
    }
}