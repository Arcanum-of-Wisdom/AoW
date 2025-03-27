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
public class ModelNAA_chestplate_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("arcanum_of_wisdom", "model_naa_chestplate_model"), "main");
	public final ModelPart Mod;
	public final ModelPart Body2;
	public final ModelPart ArmRight;
	public final ModelPart ArmLeft;

	public ModelNAA_chestplate_model(ModelPart root) {
		this.Mod = root.getChild("Mod");
		this.Body2 = this.Mod.getChild("Body2");
		this.ArmRight = this.Mod.getChild("ArmRight");
		this.ArmLeft = this.Mod.getChild("ArmLeft");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Mod = partdefinition.addOrReplaceChild("Mod", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Body2 = Mod.addOrReplaceChild("Body2",
				CubeListBuilder.create().texOffs(20, 9).addBox(-3.5F, 0.5F, -3.0F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 0).addBox(4.5F, -0.5F, -3.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 9)
						.addBox(-8.5F, -0.5F, -3.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 30).addBox(8.0F, -0.5F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 26)
						.addBox(-9.0F, -0.5F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(38, 14).addBox(8.0F, 3.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(20, 38)
						.addBox(-9.0F, 3.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(32, 34).addBox(4.5F, -0.5F, 2.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 41)
						.addBox(5.5F, 3.5F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(34, 41).addBox(-7.5F, 3.5F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 21)
						.addBox(-8.5F, -0.5F, 2.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 21).addBox(4.5F, -1.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 25)
						.addBox(-8.5F, -1.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 7).addBox(-4.5F, 0.5F, 1.5F, 9.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-5.0F, -0.5F, -2.75F, 10.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(28, 19).addBox(-3.5F, 10.5F, -2.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 5)
						.addBox(-2.5F, 11.5F, -2.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 21).addBox(-4.5F, 7.5F, -2.5F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 26)
						.addBox(3.5F, 2.5F, -1.5F, 1.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(24, 26).addBox(-4.5F, 2.5F, -1.5F, 1.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(20, 17)
						.addBox(-4.0F, 11.5F, 1.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 30).addBox(-4.5F, 0.5F, -2.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 38)
						.addBox(3.5F, 0.5F, -2.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 38).addBox(4.5F, 2.5F, -2.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 38)
						.addBox(-5.5F, 2.5F, -2.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 38).addBox(-5.5F, 2.5F, 1.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 38)
						.addBox(4.5F, 2.5F, 1.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -24.0F, 0.0F));
		PartDefinition cube_r1 = Body2.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(36, 39).addBox(-7.0F, -0.5F, -0.75F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 19).addBox(-7.0F, -0.5F, 4.0F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, -2.0F, 0.0F, 0.0F, -0.8727F));
		PartDefinition cube_r2 = Body2.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(28, 39).addBox(-7.0F, -0.5F, -0.75F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 7).addBox(-7.0F, -0.5F, 4.0F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, -2.0F, 0.0F, 0.0F, -2.2689F));
		PartDefinition ArmRight = Mod.addOrReplaceChild("ArmRight", CubeListBuilder.create(), PartPose.offset(-5.0F, -22.0F, 0.0F));
		PartDefinition ArmLeft = Mod.addOrReplaceChild("ArmLeft", CubeListBuilder.create(), PartPose.offset(5.0F, -22.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Mod.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
