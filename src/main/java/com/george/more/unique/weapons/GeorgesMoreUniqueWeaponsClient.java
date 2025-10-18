package com.george.more.unique.weapons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class GeorgesMoreUniqueWeaponsClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(
                UniqueWeaponsEntities.GRAVITY_ORB,
                FlyingItemEntityRenderer::new
        );




    }
}
