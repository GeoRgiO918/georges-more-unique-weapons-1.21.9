package com.george.moretemplates;

import com.george.moretemplates.item.MoreTemplatesItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeorgesMoreTemplates implements ModInitializer {
	public static final String MOD_ID = "georges-more-templates";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
		MoreTemplatesItems.registerSmithingTemplates();
		MoreTemplatesEntities.registerEntities();

	}
}