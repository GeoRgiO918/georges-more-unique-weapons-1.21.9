package com.george.more.unique.weapons.item;

import com.george.more.unique.weapons.GeorgesMoreUniqueWeapons;
import com.george.more.unique.weapons.item.providers.BaseItemProvider;
import com.george.more.unique.weapons.item.providers.GravityOrbProvider;
import com.george.more.unique.weapons.item.providers.SimpleSwordProvider;
import com.george.more.unique.weapons.item.providers.SimpleTemplateProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class UniqueWeaponsItems {

    public final static Item SIMPLE_TEMPLATE = registerItem(SimpleTemplateProvider.NAME, SimpleTemplateProvider.getItem());
    public final static Item SIMPLE_SWORD = registerItem(SimpleSwordProvider.NAME,SimpleSwordProvider.getItem());
    public final static Item GRAVITY_ORB = registerItem(GravityOrbProvider.NAME, GravityOrbProvider.getItem());
    public final static Item GRAVITY_INGOT = registerItem("gravity_ingot", BaseItemProvider.getItem("gravity_ingot"));


    public static void registerSmithingTemplates(){
        GeorgesMoreUniqueWeapons.LOGGER.info("Registring smithing templates");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries ->
        {
            fabricItemGroupEntries.add(SIMPLE_TEMPLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries ->
        {
            fabricItemGroupEntries.add(SIMPLE_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries ->
        {
            fabricItemGroupEntries.add(GRAVITY_ORB);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries ->
        {
            fabricItemGroupEntries.add(GRAVITY_INGOT);
        });



    }


    private static Item registerItem(String ITEM_NAME, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(GeorgesMoreUniqueWeapons.MOD_ID,ITEM_NAME),item);
    }


}
