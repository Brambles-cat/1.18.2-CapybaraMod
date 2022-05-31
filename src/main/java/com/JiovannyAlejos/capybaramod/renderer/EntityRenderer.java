package com.JiovannyAlejos.capybaramod.renderer;

import com.JiovannyAlejos.capybaramod.CapybaraMod;
import com.JiovannyAlejos.capybaramod.entity.Capybara;
import com.JiovannyAlejos.capybaramod.renderer.model.CapyModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityRenderer<Type extends Capybara> extends MobRenderer<Type, EntityModel<Type>> {

    public static final ResourceLocation Texture = new ResourceLocation(CapybaraMod.MOD_ID, "textures/entities/capy.png");

    public EntityRenderer(EntityRendererProvider.Context context) {
        super(context, new CapyModel<>(context.bakeLayer(CapyModel.LAYER_LOCATION)), 0.5f);
        // third is shadow size
    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {return Texture;}
}
