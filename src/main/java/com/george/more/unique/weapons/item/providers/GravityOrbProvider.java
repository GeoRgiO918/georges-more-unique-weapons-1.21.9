package com.george.more.unique.weapons.item.providers;

import com.george.more.unique.weapons.GeorgesMoreUniqueWeapons;
import com.george.more.unique.weapons.item.throwable.GravityOrbItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class GravityOrbProvider {

    public static final String NAME = "gravity_orb";

    public static Item getItem(){
        Identifier id = Identifier.of(GeorgesMoreUniqueWeapons.MOD_ID, NAME);
        RegistryKey<Item> key= RegistryKey.of(RegistryKeys.ITEM, id);


        Item.Settings settings = new Item.Settings();
        settings.registryKey(key);
        settings.maxCount(8).rarity(Rarity.RARE);
        return new GravityOrbItem(settings);
    };
}
