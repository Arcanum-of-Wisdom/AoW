package net.bcm.arcanumofwisdom.client.gui;

import org.joml.Vector3f;
import org.joml.Quaternionf;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.bcm.arcanumofwisdom.world.inventory.ArtifactOfDeformationGUIMenu;
import net.bcm.arcanumofwisdom.procedures.GUIEntityReturnProcedure;
import net.bcm.arcanumofwisdom.network.ArtifactOfDeformationGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ArtifactOfDeformationGUIScreen extends AbstractContainerScreen<ArtifactOfDeformationGUIMenu> {
	private final static HashMap<String, Object> guistate = ArtifactOfDeformationGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_custom_arrow_1_up;
	ImageButton imagebutton_custom_arrow_1_down;
	ImageButton imagebutton_custom_arrow_1_up1;
	ImageButton imagebutton_custom_arrow_1_down1;

	public ArtifactOfDeformationGUIScreen(ArtifactOfDeformationGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 50;
		this.imageHeight = 50;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (GUIEntityReturnProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			this.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + -109, this.topPos + 102, 30, 0f + (float) Math.atan((this.leftPos + -109 - mouseX) / 40.0), (float) Math.atan((this.topPos + 53 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 15 && mouseX < leftPos + 39 && mouseY > topPos + 89 && mouseY < topPos + 113) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_deformation_gui.tooltip_you_gain_specific_updowngrades"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/artifactofdeformationbg.png"), this.leftPos + -174, this.topPos + -78, 0, 0, 400, 200, 400, 200);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_deformation_gui.label_info"), 16, 96, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_deformation_gui.label_12"), 107, -3, -16737997, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_deformation_gui.label_x15"), 107, -21, -16724890, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_deformation_gui.label_x12"), 108, 15, -6750106, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_deformation_gui.label_x151"), 108, 33, -3407770, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_deformation_gui.label_cd_800"), 143, -3, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_deformation_gui.label_cd_1000"), 143, -20, -65434, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_deformation_gui.label_cd_8001"), 143, 16, -3407821, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_deformation_gui.label_cd_10001"), 143, 34, -65434, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + 10, this.topPos + -93, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArtifactOfDeformationGUIButtonMessage(0, x, y, z));
						ArtifactOfDeformationGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonred", imagebutton_buttonred);
		this.addRenderableWidget(imagebutton_buttonred);
		imagebutton_custom_arrow_1_up = new ImageButton(this.leftPos + 87, this.topPos + -6, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_up.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_up.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArtifactOfDeformationGUIButtonMessage(1, x, y, z));
						ArtifactOfDeformationGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_1_up", imagebutton_custom_arrow_1_up);
		this.addRenderableWidget(imagebutton_custom_arrow_1_up);
		imagebutton_custom_arrow_1_down = new ImageButton(this.leftPos + 87, this.topPos + 12, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_down.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_down.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArtifactOfDeformationGUIButtonMessage(2, x, y, z));
						ArtifactOfDeformationGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_1_down", imagebutton_custom_arrow_1_down);
		this.addRenderableWidget(imagebutton_custom_arrow_1_down);
		imagebutton_custom_arrow_1_up1 = new ImageButton(this.leftPos + 87, this.topPos + -24, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_up.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_up.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArtifactOfDeformationGUIButtonMessage(3, x, y, z));
						ArtifactOfDeformationGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_1_up1", imagebutton_custom_arrow_1_up1);
		this.addRenderableWidget(imagebutton_custom_arrow_1_up1);
		imagebutton_custom_arrow_1_down1 = new ImageButton(this.leftPos + 87, this.topPos + 30, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_down.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_down.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArtifactOfDeformationGUIButtonMessage(4, x, y, z));
						ArtifactOfDeformationGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_1_down1", imagebutton_custom_arrow_1_down1);
		this.addRenderableWidget(imagebutton_custom_arrow_1_down1);
	}

	private void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
		Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
		Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
		pose.mul(cameraOrientation);
		float f2 = entity.yBodyRot;
		float f3 = entity.getYRot();
		float f4 = entity.getXRot();
		float f5 = entity.yHeadRotO;
		float f6 = entity.yHeadRot;
		entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
		entity.setYRot(180.0F + angleXComponent * 40.0F);
		entity.setXRot(-angleYComponent * 20.0F);
		entity.yHeadRot = entity.getYRot();
		entity.yHeadRotO = entity.getYRot();
		InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, new Vector3f(0, 0, 0), pose, cameraOrientation, entity);
		entity.yBodyRot = f2;
		entity.setYRot(f3);
		entity.setXRot(f4);
		entity.yHeadRotO = f5;
		entity.yHeadRot = f6;
	}
}
