package com.george.more.unique.weapons.item.providers;

import com.george.more.unique.weapons.GeorgesMoreUniqueWeapons;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class BaseItemProvider {

    public static Item getItem(String itemName){

        Identifier id = Identifier.of(GeorgesMoreUniqueWeapons.MOD_ID, itemName);
        RegistryKey<Item> key= RegistryKey.of(RegistryKeys.ITEM, id);

        Item.Settings settings = new Item.Settings();
        settings.registryKey(key);
        return  new Item(settings);

    }
}
