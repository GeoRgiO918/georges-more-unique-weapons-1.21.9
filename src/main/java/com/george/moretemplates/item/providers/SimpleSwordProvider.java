package com.george.moretemplates.item.providers;

import com.george.moretemplates.GeorgesMoreTemplates;
import com.george.moretemplates.item.swords.SimpleSwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class SimpleSwordProvider {

    public static final String NAME = "simple_sword";

    public static Item getItem(){
        Identifier id = Identifier.of(GeorgesMoreTemplates.MOD_ID, NAME);
        RegistryKey<Item> key= RegistryKey.of(RegistryKeys.ITEM, id);

        Item.Settings settings = new Item.Settings();
        settings.registryKey(key);
        settings.rarity(Rarity.EPIC);
        settings.sword(ToolMaterial.NETHERITE,10f,1f);
        return new SimpleSwordItem(settings);
    };



}
