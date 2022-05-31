package com.JiovannyAlejos.capybaramod.renderer.model;

import com.JiovannyAlejos.capybaramod.CapybaraMod;
import com.JiovannyAlejos.capybaramod.entity.Capybara;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class CapyModel<Type extends Capybara> extends EntityModel<Type> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(CapybaraMod.MOD_ID, "capybara"), "main");
	private final ModelPart LegPairOne;
	private final ModelPart LegPairTwo;
	private final ModelPart Head;
	private final ModelPart bb_main;

	public CapyModel(ModelPart root) {
		this.LegPairOne = root.getChild("LegPairOne");
		this.LegPairTwo = root.getChild("LegPairTwo");
		this.Head = root.getChild("Head");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		// legs one
		partdefinition.addOrReplaceChild("LegPairOne", CubeListBuilder.create().texOffs(20, 20).addBox(-2.9F, -3.0F, 4.3F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(0.9F, -3.0F, -4.7F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		// legs two
		partdefinition.addOrReplaceChild("LegPairTwo", CubeListBuilder.create().texOffs(14, 17).addBox(0.9F, -3.0F, 4.3F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
			.texOffs(0, 5).addBox(-2.9F, -3.0F, -4.6F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		// head
		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -10.0F, -9.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
			.texOffs(6, 0).addBox(-3.0F, -11.0F, -4.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(6, 5).addBox(1.0F, -11.0F, -4.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		// main body
		partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -8.0F, -5.0F, 6.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LegPairOne.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegPairTwo.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}