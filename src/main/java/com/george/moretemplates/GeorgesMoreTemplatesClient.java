package com.george.moretemplates;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class GeorgesMoreTemplatesClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(
                MoreTemplatesEntities.GRAVITY_ORB,
                FlyingItemEntityRenderer::new
        );

    }
}
