package com.JiovannyAlejos.capybaramod.item;

import com.JiovannyAlejos.capybaramod.CapybaraMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> items =
            DeferredRegister.create(ForgeRegistries.ITEMS, CapybaraMod.MOD_ID);

    public static final RegistryObject<Item> WATER_SPOUT = items.register("water_spout",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        items.register(eventBus);
        items.register("test", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    }
}