package com.george.more.unique.weapons.effects;

import com.george.more.unique.weapons.GeorgesMoreUniqueWeapons;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.stat.Stat;
import net.minecraft.util.Identifier;

public class UniqueWeaponsEffects {

    public static final RegistryEntry<StatusEffect> MAGIC_WARP = registerStatusEffect("margic_warp", new MagicWarpEffect());

    public static void registerEffects(){
        GeorgesMoreUniqueWeapons.LOGGER.info("Registring effects!");
    }

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect effect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(GeorgesMoreUniqueWeapons.MOD_ID,name),effect);
    }
}
