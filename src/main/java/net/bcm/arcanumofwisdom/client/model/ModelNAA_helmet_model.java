package net.bcm.arcanumofwisdom.client.model;

import net.neoforged.fml.common.Mod;

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
public class ModelNAA_helmet_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("arcanum_of_wisdom", "model_naa_helmet_model"), "main");
	public final ModelPart Mod;
	public final ModelPart Head2;

	public ModelNAA_helmet_model(ModelPart root) {
		this.Mod = root.getChild("Mod");
		this.Head2 = this.Mod.getChild("Head2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Mod = partdefinition.addOrReplaceChild("Mod", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition Head2 = Mod.addOrReplaceChild("Head2",
				CubeListBuilder.create().texOffs(44, 21).addBox(-1.0F, -9.0F, 4.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 45).addBox(-3.0F, -9.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(44, 45)
						.addBox(1.0F, -9.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 29).addBox(1.0F, -7.0F, 3.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(44, 10)
						.addBox(-4.0F, -7.0F, 3.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(44, 15).addBox(-1.0F, -7.0F, 3.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 46)
						.addBox(-2.0F, -3.0F, 3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 46).addBox(1.0F, -3.0F, 3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(26, 46)
						.addBox(3.0F, -8.0F, 3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(30, 46).addBox(-4.0F, -8.0F, 3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 46)
						.addBox(2.0F, -3.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 46).addBox(-4.0F, -3.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 34)
						.addBox(3.0F, -9.0F, 4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 26).addBox(4.0F, -9.0F, -5.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(34, 0)
						.addBox(4.0F, -2.0F, -5.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 36).addBox(-5.0F, -2.0F, -5.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(20, 26)
						.addBox(-5.0F, -9.0F, -5.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.0F, -10.0F, -5.0F, 8.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(40, 26)
						.addBox(-2.0F, -2.0F, 4.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 36).addBox(-4.0F, -9.0F, -5.0F, 8.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 36)
						.addBox(-4.0F, -9.0F, -6.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 46).addBox(-5.0F, -9.0F, 4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 10)
						.addBox(-5.0F, -8.0F, -5.0F, 1.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(22, 10).addBox(4.0F, -8.0F, -5.0F, 1.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Mod.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}
