package com.george.moretemplates.item.providers;

import com.george.moretemplates.GeorgesMoreTemplates;
import com.george.moretemplates.item.swords.SimpleSwordItem;
import com.george.moretemplates.item.throwable.GravityOrbItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class GravityOrbProvider {

    public static final String NAME = "gravity_orb";

    public static Item getItem(){
        Identifier id = Identifier.of(GeorgesMoreTemplates.MOD_ID, NAME);
        RegistryKey<Item> key= RegistryKey.of(RegistryKeys.ITEM, id);


        Item.Settings settings = new Item.Settings();
        settings.registryKey(key);
        settings.maxCount(8).rarity(Rarity.RARE);
        return new GravityOrbItem(settings);
    };
}
