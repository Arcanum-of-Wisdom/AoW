package net.bcm.arcanumofwisdom.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.bcm.arcanumofwisdom.world.inventory.BAWGUIArtifacts3Menu;
import net.bcm.arcanumofwisdom.network.BAWGUIArtifacts3ButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BAWGUIArtifacts3Screen extends AbstractContainerScreen<BAWGUIArtifacts3Menu> {
	private final static HashMap<String, Object> guistate = BAWGUIArtifacts3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_custom_arrow_4_left;
	ImageButton imagebutton_custom_arrow_4_left1;
	ImageButton imagebutton_custom_arrow_4_right;

	public BAWGUIArtifacts3Screen(BAWGUIArtifacts3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 200;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 123 && mouseX < leftPos + 147 && mouseY > topPos + 171 && mouseY < topPos + 195) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.tooltip_last_page"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 167 && mouseX < leftPos + 191 && mouseY > topPos + 171 && mouseY < topPos + 195) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.tooltip_next_page"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/bookofwisdom_open.png"), this.leftPos + 1, this.topPos + 1, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/artifactofmagic.png"), this.leftPos + 85, this.topPos + 36, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/artifactofdimensions.png"), this.leftPos + 207, this.topPos + 36, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_magic"), 81, 28, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_dimensions"), 189, 28, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_main_ability"), 48, 50, -13312, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_main_ability1"), 171, 50, -13312, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_resets_hp_to_20"), 49, 59, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_grants_luck"), 49, 67, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_grants_hero_of"), 49, 75, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_the_village"), 85, 83, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_grants_the_ability"), 171, 60, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_to_teleport_to"), 171, 68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_the_overworld"), 171, 77, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_nether_or_end"), 172, 86, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_sword_ability"), 49, 91, -13421569, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_sword_ability1"), 172, 94, -13421569, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_deals_damage_to"), 49, 99, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_nearby_undead"), 49, 107, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_creatures"), 49, 115, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_deals_damage_to1"), 172, 102, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_every_boss_in"), 172, 110, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_minecraft"), 172, 118, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_cd"), 48, 43, -65485, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_artifacts_3.label_cd1000"), 171, 43, -65485, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + 298, this.topPos + -14, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIArtifacts3ButtonMessage(0, x, y, z));
						BAWGUIArtifacts3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonred", imagebutton_buttonred);
		this.addRenderableWidget(imagebutton_buttonred);
		imagebutton_custom_arrow_4_left = new ImageButton(this.leftPos + 282, this.topPos + -5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_left.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_left.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIArtifacts3ButtonMessage(1, x, y, z));
						BAWGUIArtifacts3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_left", imagebutton_custom_arrow_4_left);
		this.addRenderableWidget(imagebutton_custom_arrow_4_left);
		imagebutton_custom_arrow_4_left1 = new ImageButton(this.leftPos + 128, this.topPos + 176, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_left.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_left.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIArtifacts3ButtonMessage(2, x, y, z));
						BAWGUIArtifacts3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_left1", imagebutton_custom_arrow_4_left1);
		this.addRenderableWidget(imagebutton_custom_arrow_4_left1);
		imagebutton_custom_arrow_4_right = new ImageButton(this.leftPos + 170, this.topPos + 176, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIArtifacts3ButtonMessage(3, x, y, z));
						BAWGUIArtifacts3ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right", imagebutton_custom_arrow_4_right);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right);
	}
}
