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
	private final ModelPart legPairOne;
	private final ModelPart legPairTwo;
	private final ModelPart head;
	private final ModelPart bb_main;

	public CapyModel(ModelPart root) {
		this.legPairOne = root.getChild("LegPairOne");
		this.legPairTwo = root.getChild("LegPairTwo");
		this.head = root.getChild("Head");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		// legs one
		partdefinition.addOrReplaceChild("LegPairOne", CubeListBuilder.create()
			.texOffs(20, 20).addBox(-2.9F, -3.0f, 4.3F, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f))
			.texOffs(0, 0).addBox(0.9F, -3.0f, -4.7F, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset(0.0f, 24.0f, 0.0f));

		// legs two
		partdefinition.addOrReplaceChild("LegPairTwo", CubeListBuilder.create()
			.texOffs(14, 17).addBox(0.9F, -3.0f, 4.3F, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f))
			.texOffs(0, 5).addBox(-2.9F, -3.0f, -4.6F, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset(0.0f, 24.0f, 0.0f));

		// head
		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create()
			.texOffs(0, 17).addBox(-2.0f, -10.0f, -9.0f, 4.0f, 4.0f, 6.0f, new CubeDeformation(0.0f))
			.texOffs(6, 0).addBox(-3.0f, -11.0f, -4.0f, 2.0f, 2.0f, 0.0f, new CubeDeformation(0.0f))
			.texOffs(6, 5).addBox(1.0f, -11.0f, -4.0f, 2.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset(0.0f, 24.0f, 0.0f));
		// main body
		partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -8.0f, -5.0f, 6.0f, 6.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offset(0.0f, 24.0f, 0.0f));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.setRotation(
			headPitch * (float)Math.PI / 180,
			netHeadYaw * (float)Math.PI / 180,
			0.0f
		);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		legPairOne.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legPairTwo.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}