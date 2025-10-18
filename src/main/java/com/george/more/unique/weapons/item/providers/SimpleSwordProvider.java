package com.george.more.unique.weapons.item.providers;

import com.george.more.unique.weapons.GeorgesMoreUniqueWeapons;
import com.george.more.unique.weapons.item.swords.SimpleSwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class SimpleSwordProvider {

    public static final String NAME = "simple_sword";

    public static Item getItem(){
        Identifier id = Identifier.of(GeorgesMoreUniqueWeapons.MOD_ID, NAME);
        RegistryKey<Item> key= RegistryKey.of(RegistryKeys.ITEM, id);

        Item.Settings settings = new Item.Settings();
        settings.registryKey(key);
        settings.rarity(Rarity.EPIC);
        settings.sword(ToolMaterial.NETHERITE,4f,-2.8f);
        return new SimpleSwordItem(settings);
    };



}
