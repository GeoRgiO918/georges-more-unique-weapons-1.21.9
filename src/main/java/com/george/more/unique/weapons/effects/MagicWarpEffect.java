package com.george.more.unique.weapons.effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class MagicWarpEffect extends InstantStatusEffect {

    private final double maxDistance;

    public MagicWarpEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x9933FF); // Цвет и частицы
        maxDistance = 1000;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        teleport(entity, world);
        return true; // эффект сработал
    }

    // Этот метод вызывается мгновенно при применении через команду/зелье
    @Override
    public void applyInstantEffect(ServerWorld world, @Nullable Entity effectEntity, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        teleport(target, world);
    }

    private void teleport(LivingEntity target, ServerWorld world) {
            double x = target.getX() + (world.random.nextDouble() - 0.5) * 2 * maxDistance;
            double z = target.getZ() + (world.random.nextDouble() - 0.5) * 2 * maxDistance;
            double y = MathHelper.clamp(target.getY() + (target.getRandom().nextDouble() - (double)0.5F) * (double)32, (double)world.getBottomY(), (double)(world.getBottomY() + ((ServerWorld)world).getLogicalHeight() - 1));


           target.requestTeleport(x,y,z);


        }
    }