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
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.bcm.arcanumofwisdom.world.inventory.AOWSettingsGUIMenu;
import net.bcm.arcanumofwisdom.procedures.ToggleWarningResetButtonProcedure;
import net.bcm.arcanumofwisdom.procedures.ToggleResetWisdomButtonProcedure;
import net.bcm.arcanumofwisdom.procedures.GUIEntityReturnProcedure;
import net.bcm.arcanumofwisdom.network.AOWSettingsGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AOWSettingsGUIScreen extends AbstractContainerScreen<AOWSettingsGUIMenu> {
	private final static HashMap<String, Object> guistate = AOWSettingsGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_toggle;
	Button button_reset;
	Button button_reset1;

	public AOWSettingsGUIScreen(AOWSettingsGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 240;
		this.imageHeight = 118;
	}

	private static final ResourceLocation texture = new ResourceLocation("arcanum_of_wisdom:textures/screens/aow_settings_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (GUIEntityReturnProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			this.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + -49, this.topPos + 107, 35, 0f, 0, livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.label_arcanum_of_wisdom_settings"), 5, 3, -6750157, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.label_show_overlay"), 5, 15, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.label_reset_wisdom"), 5, 44, -12829636, false);
		if (ToggleWarningResetButtonProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.label_only_in"), 185, 39, -3407821, false);
		if (ToggleWarningResetButtonProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.label_creative_mode"), 168, 49, -3407821, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.label_reset_countdowns"), 5, 63, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.label_for_the"), 4, 71, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.label_holy_branch"), 5, 79, -12829636, false);
		if (ToggleWarningResetButtonProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.label_only_in1"), 186, 63, -3407821, false);
		if (ToggleWarningResetButtonProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.label_creative_mode1"), 168, 73, -3407821, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.label_and_shadow_worrior"), 5, 88, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_toggle = Button.builder(Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.button_toggle"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new AOWSettingsGUIButtonMessage(0, x, y, z));
				AOWSettingsGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 180, this.topPos + 15, 56, 20).build();
		guistate.put("button:button_toggle", button_toggle);
		this.addRenderableWidget(button_toggle);
		button_reset = Button.builder(Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.button_reset"), e -> {
			if (ToggleResetWisdomButtonProcedure.execute(entity)) {
				PacketDistributor.SERVER.noArg().send(new AOWSettingsGUIButtonMessage(1, x, y, z));
				AOWSettingsGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 185, this.topPos + 39, 51, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ToggleResetWisdomButtonProcedure.execute(entity))
					super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_reset", button_reset);
		this.addRenderableWidget(button_reset);
		button_reset1 = Button.builder(Component.translatable("gui.arcanum_of_wisdom.aow_settings_gui.button_reset1"), e -> {
			if (ToggleResetWisdomButtonProcedure.execute(entity)) {
				PacketDistributor.SERVER.noArg().send(new AOWSettingsGUIButtonMessage(2, x, y, z));
				AOWSettingsGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 185, this.topPos + 63, 51, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ToggleResetWisdomButtonProcedure.execute(entity))
					super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_reset1", button_reset1);
		this.addRenderableWidget(button_reset1);
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
