package com.george.moretemplates;

import com.george.moretemplates.entity.GravityOrbEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class MoreTemplatesEntities {


    public static final RegistryKey<EntityType<?>> GRAVITY_ORB_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(GeorgesMoreTemplates.MOD_ID,"gravity_orb"));


    public static final EntityType<GravityOrbEntity> GRAVITY_ORB =  Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(GeorgesMoreTemplates.MOD_ID,"gravity_orb"),
            EntityType.Builder.<GravityOrbEntity>create(GravityOrbEntity::new, SpawnGroup.MISC)
                    .dimensions(0.25F, 0.25F).build(GRAVITY_ORB_KEY)
    );



    public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return register(keyOf(id), type);
    }

    public static RegistryKey<EntityType<?>> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.ofVanilla(id));
    }


    public static <T extends Entity> EntityType<T> register(RegistryKey<EntityType<?>> key, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, key, type.build(key));
    }

    public static void registerEntities(){
        GeorgesMoreTemplates.LOGGER.info("Registring ");
    }


}
