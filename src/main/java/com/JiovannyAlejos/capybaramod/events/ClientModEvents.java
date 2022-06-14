package com.JiovannyAlejos.capybaramod.events;

import com.JiovannyAlejos.capybaramod.CapybaraMod;
import com.JiovannyAlejos.capybaramod.entity.EntityInit;
import com.JiovannyAlejos.capybaramod.renderer.EntityRenderer;
import com.JiovannyAlejos.capybaramod.renderer.model.CapyModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CapybaraMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    private ClientModEvents() {}

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
event.registerLayerDefinition(CapyModel.LAYER_LOCATION, CapyModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.CAPYBARA.get(), EntityRenderer::new);
    }
}