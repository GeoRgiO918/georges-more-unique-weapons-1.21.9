package com.george.more.unique.weapons.item.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SimpleSwordItem  extends Item {
    public SimpleSwordItem(Settings settings) {
        super(settings);
    }

    public static final Map<UUID,Float> lastCooldowns = new HashMap<>();



    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Vec3d velocity = target.getVelocity();




        if (!target.getEntityWorld().isClient() && Math.random() < 0.33) {
            target.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 5f, 0.5f);
            double xRand = (Math.random() - 0.5) * 2.4;
            double zRand = (Math.random() - 0.5) * 2.4;
            double yRand = (1.2 + Math.random() * 0.5);
            target.setVelocity(velocity.x + xRand, yRand, velocity.z + zRand);
            target.velocityDirty = true;

        }


        super.postHit(stack, target, attacker);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            float cooldown = user.getAttackCooldownProgress(0.0f);
            lastCooldowns.put(user.getUuid(), cooldown);
        }
        return super.use(world, user, hand);
    }
}
