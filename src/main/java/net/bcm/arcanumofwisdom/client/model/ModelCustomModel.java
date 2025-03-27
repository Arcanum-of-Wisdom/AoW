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
public class ModelCustomModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("arcanum_of_wisdom", "model_custom_model"), "main");
	public final ModelPart Head;

	public ModelCustomModel(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -8.0F, -5.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 36).addBox(-4.0F, -5.0F, -4.5F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 36)
						.addBox(-2.0F, -2.0F, -4.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 40).addBox(-4.0F, -6.0F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 27)
						.addBox(1.0F, -6.0F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 42).addBox(3.0F, -7.0F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 42)
						.addBox(-4.0F, -7.0F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 29).addBox(-3.0F, -8.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 41)
						.addBox(-4.0F, -2.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 41).addBox(2.0F, -2.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 38)
						.addBox(-2.0F, -1.0F, -5.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 40).addBox(-4.0F, -8.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 42)
						.addBox(3.0F, -8.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 10).addBox(4.0F, -8.0F, -5.0F, 1.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(22, 10)
						.addBox(-5.0F, -8.0F, -5.0F, 1.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 27).addBox(-6.0F, -1.0F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(20, 27)
						.addBox(4.0F, -1.0F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(34, 0)
						.addBox(-4.0F, -8.0F, 4.0F, 8.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 36).addBox(-3.0F, -8.0F, 5.0F, 6.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 32)
						.addBox(1.0F, -8.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
