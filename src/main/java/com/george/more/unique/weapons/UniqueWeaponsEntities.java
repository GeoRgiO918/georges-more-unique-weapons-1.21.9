package com.george.more.unique.weapons;

import com.george.more.unique.weapons.entity.GravityOrbEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class UniqueWeaponsEntities {


    public static final RegistryKey<EntityType<?>> GRAVITY_ORB_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(GeorgesMoreUniqueWeapons.MOD_ID,"gravity_orb"));


    public static final EntityType<GravityOrbEntity> GRAVITY_ORB =  Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(GeorgesMoreUniqueWeapons.MOD_ID,"gravity_orb"),
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
        GeorgesMoreUniqueWeapons.LOGGER.info("Registring ");
    }


}
