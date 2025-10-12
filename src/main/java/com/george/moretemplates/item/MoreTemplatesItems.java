package com.george.moretemplates.item;

import com.george.moretemplates.GeorgesMoreTemplates;
import com.george.moretemplates.item.providers.GravityOrbProvider;
import com.george.moretemplates.item.providers.SimpleSwordProvider;
import com.george.moretemplates.item.providers.SimpleTemplateProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class MoreTemplatesItems {

    public final static Item SIMPLE_TEMPLATE = registerItem(SimpleTemplateProvider.NAME, SimpleTemplateProvider.getItem());
    public final static Item SIMPLE_SWORD = registerItem(SimpleSwordProvider.NAME,SimpleSwordProvider.getItem());
    public final static Item GRAVITY_ORB = registerItem(GravityOrbProvider.NAME, GravityOrbProvider.getItem());


    public static void registerSmithingTemplates(){
        GeorgesMoreTemplates.LOGGER.info("Registring smithing templates");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries ->
        {
            fabricItemGroupEntries.add(SIMPLE_TEMPLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries ->
        {
            fabricItemGroupEntries.add(SIMPLE_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries ->
        {
            fabricItemGroupEntries.add(GRAVITY_ORB);
        });


    }


    private static Item registerItem(String ITEM_NAME, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(GeorgesMoreTemplates.MOD_ID,ITEM_NAME),item);
    }


}
