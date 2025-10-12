package com.george.moretemplates.item.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SimpleSwordItem  extends Item {
    public SimpleSwordItem(Settings settings) {
        super(settings);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Vec3d velocity = target.getVelocity();

        if (!target.getEntityWorld().isClient()) {
            target.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 3f, 0.7f);
            double xRand = (Math.random() - 0.5) * 2.4;
            double zRand = (Math.random() - 0.5) * 2.4;
            double yRand = 1.2 + Math.random() * 0.5;  target.setVelocity(velocity.x + xRand, yRand, velocity.z + zRand);
            target.velocityDirty = true;

        }


        super.postHit(stack, target, attacker);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {

        return super.use(world, user, hand);
    }
}
