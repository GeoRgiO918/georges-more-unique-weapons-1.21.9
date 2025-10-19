package com.george.more.unique.weapons;

import com.george.more.unique.weapons.effects.UniqueWeaponsEffects;
import com.george.more.unique.weapons.item.UniqueWeaponsItems;
import com.george.more.unique.weapons.loottable.UniqueWeaponsLootTableModifiers;
import com.george.more.unique.weapons.other.UniqueWeaponsDispenseBehaviors;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeorgesMoreUniqueWeapons implements ModInitializer {
	public static final String MOD_ID = "georges-more-unique-weapons";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
		UniqueWeaponsItems.registerSmithingTemplates();
		UniqueWeaponsEntities.registerEntities();
		UniqueWeaponsLootTableModifiers.modifyLootTable();
		UniqueWeaponsDispenseBehaviors.register();
		UniqueWeaponsEffects.registerEffects();

	}
}