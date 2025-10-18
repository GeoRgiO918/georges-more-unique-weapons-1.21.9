package com.george.more.unique.weapons.item.providers;

import com.george.more.unique.weapons.GeorgesMoreUniqueWeapons;
import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class SimpleTemplateProvider {

    public static final String NAME = "simple_template";
    public static final String APPLIES_TO_KEY = "item.georges-more-unique-weapons.simple_template.applies_to";
    public static final String INGREDIENTS_KEY = "item.georges-more-unique-weapons.simple_template.ingredients";
    public static final String BASE_SLOT_DESCRIPTION = "item.georges-more-unique-weapons.simple_template.base_slot_description";
    public static final String UPGRADE_KEY = "upgrade.georges-more-unique-weapons.simple_template";
    public static final List<Identifier> BASE_SLOT_ICON = List.of(Identifier.of("item/empty_slot_sword"));
    public static final List<Identifier> ADDITIONS_SLOT_ICON = List.of(Identifier.of("item/empty_slot_ingot"));


    public static SmithingTemplateItem getItem() {

        Identifier id = Identifier.of(GeorgesMoreUniqueWeapons.MOD_ID, NAME);
        RegistryKey<Item> key= RegistryKey.of(RegistryKeys.ITEM, id);

        Item.Settings settings = new Item.Settings();
        settings.registryKey(key);
        settings.rarity(Rarity.EPIC);
        return new SmithingTemplateItem(
                Text.translatable(APPLIES_TO_KEY),
                Text.translatable(INGREDIENTS_KEY),
                Text.translatable(BASE_SLOT_DESCRIPTION),
                Text.translatable(UPGRADE_KEY),
                BASE_SLOT_ICON,
                ADDITIONS_SLOT_ICON,
                settings);
    }

}
