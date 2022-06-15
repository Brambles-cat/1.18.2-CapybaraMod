package com.JiovannyAlejos.capybaramod;

import com.JiovannyAlejos.capybaramod.init.EntityInit;
import com.JiovannyAlejos.capybaramod.init.SoundInit;
import com.JiovannyAlejos.capybaramod.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CapybaraMod.MOD_ID)
public class CapybaraMod {
    public static final String MOD_ID = "capybaramod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public CapybaraMod() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        SoundInit.SOUNDS.register(eventBus);
        ModItems.register(eventBus);
        EntityInit.ENTITIES.register(eventBus);
        // Register ourselves for server and other game events we are interested in
        //MinecraftForge.EVENT_BUS.register(this);
    }
}
