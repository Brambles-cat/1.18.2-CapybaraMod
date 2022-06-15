package com.JiovannyAlejos.capybaramod.init;

import com.JiovannyAlejos.capybaramod.CapybaraMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CapybaraMod.MOD_ID);
    public static final RegistryObject<SoundEvent> CAPY_AMBIENT = SOUNDS.register(
            "entity.capybara.ambient",
            () -> new SoundEvent(new ResourceLocation(CapybaraMod.MOD_ID, "entity.capybara.ambient")));

    public static final RegistryObject<SoundEvent> CAPY_HURT = SOUNDS.register(
            "entity.capybara.hurt",
            () -> new SoundEvent(new ResourceLocation(CapybaraMod.MOD_ID, "entity.capybara.hurt")));

    public static final RegistryObject<SoundEvent> CAPY_DEATH = SOUNDS.register(
            "entity.capybara.death",
            () -> new SoundEvent(new ResourceLocation(CapybaraMod.MOD_ID, "entity.capybara.death")));
}
