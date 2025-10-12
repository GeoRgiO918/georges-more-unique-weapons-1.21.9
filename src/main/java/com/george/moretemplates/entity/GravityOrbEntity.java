package com.george.moretemplates.entity;

import com.george.moretemplates.GeorgesMoreTemplates;
import com.george.moretemplates.MoreTemplatesEntities;
import com.george.moretemplates.item.MoreTemplatesItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class GravityOrbEntity extends ThrownItemEntity {

    public GravityOrbEntity(EntityType<? extends GravityOrbEntity> entityType, World world) {
        super(entityType, world);
    }

    public GravityOrbEntity(World world, LivingEntity owner, ItemStack stack) {
        super(MoreTemplatesEntities.GRAVITY_ORB, owner, world, stack);
    }

    public GravityOrbEntity(World world, double x, double y, double z, ItemStack stack) {
        super(MoreTemplatesEntities.GRAVITY_ORB, x, y, z, world, stack);
    }



    @Override
    protected Item getDefaultItem() {
        return MoreTemplatesItems.GRAVITY_ORB;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);

        if (!this.getEntityWorld().isClient()) {
            ServerWorld world = (ServerWorld) this.getEntityWorld();
            Vec3d pos = this.getEntityPos();

            // Визуальный эффект
            world.spawnParticles(ParticleTypes.PORTAL, pos.x, pos.y, pos.z, 50, 1.0, 1.0, 1.0, 0.1);
            world.playSound(null, pos.x, pos.y, pos.z, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);

            // Радиус воздействия
            double radius = 10.0D;
            List<LivingEntity> nearby = world.getEntitiesByClass(LivingEntity.class, new Box(
                    pos.x - radius, pos.y - radius, pos.z - radius,
                    pos.x + radius, pos.y + radius, pos.z + radius
            ), e -> e.isAlive() && e != this.getOwner());

            for (LivingEntity entity : nearby) {
                // Подброс
                entity.addVelocity(0.0, 1.2, 0.0);
                // Эффект левитации
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 40, 1));
            }

            this.discard();
        }
    }


    protected ParticleEffect getParticleType() {
        return ParticleTypes.PORTAL;
    }
}