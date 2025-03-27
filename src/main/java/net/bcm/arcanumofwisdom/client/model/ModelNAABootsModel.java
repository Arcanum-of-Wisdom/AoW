package net.bcm.arcanumofwisdom.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelNAABootsModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("arcanum_of_wisdom", "model_naa_boots_model"), "main");
	public final ModelPart RightLeg;
	public final ModelPart LeftLeg;

	public ModelNAABootsModel(ModelPart root) {
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(0, 6).addBox(-2.2F, 12.0F, -2.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(18, 0).addBox(-2.0F, 7.0F, -4.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 16)
						.addBox(-2.0F, 9.0F, -5.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 12).addBox(-2.0F, 6.0F, 2.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(-3.0F, 7.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(24, 7).addBox(1.0F, 7.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(20, 29)
						.addBox(-3.0F, 7.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 29).addBox(-3.0F, 6.0F, 2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(12, 12).addBox(-2.0F, 6.0F, 2.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 20).addBox(-2.0F, 7.0F, -4.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 27)
						.addBox(-2.0F, 9.0F, -5.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.0F, 12.0F, -2.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(22, 20)
						.addBox(2.0F, 7.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(4, 29).addBox(2.0F, 6.0F, 2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 29)
						.addBox(2.0F, 7.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 29).addBox(-2.0F, 7.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
