package com.JiovannyAlejos.capybaramod.init;
import com.JiovannyAlejos.capybaramod.CapybaraMod;
import com.JiovannyAlejos.capybaramod.entity.Capybara;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, CapybaraMod.MOD_ID);
    public static final RegistryObject<EntityType<Capybara>> CAPYBARA = ENTITIES.register("capybara",
            () -> EntityType.Builder.of(Capybara::new, MobCategory.CREATURE)
                    .sized(0.8f, 0.8f)
                    .build(new ResourceLocation(CapybaraMod.MOD_ID, "capybara").toString()));
}
