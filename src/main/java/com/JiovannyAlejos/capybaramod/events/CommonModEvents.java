package com.JiovannyAlejos.capybaramod.events;

import com.JiovannyAlejos.capybaramod.CapybaraMod;
import com.JiovannyAlejos.capybaramod.entity.Capybara;
import com.JiovannyAlejos.capybaramod.entity.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = CapybaraMod.MOD_ID, bus = Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.CAPYBARA.get(), Capybara.createAttribute().build());
    }
}
