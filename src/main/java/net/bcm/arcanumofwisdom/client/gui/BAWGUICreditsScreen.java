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

import net.bcm.arcanumofwisdom.world.inventory.BAWGUICreditsMenu;
import net.bcm.arcanumofwisdom.network.BAWGUICreditsButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BAWGUICreditsScreen extends AbstractContainerScreen<BAWGUICreditsMenu> {
	private final static HashMap<String, Object> guistate = BAWGUICreditsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_custom_arrow_4_left;
	ImageButton imagebutton_large_button_download;
	ImageButton imagebutton_custom_arrow_1_right;
	ImageButton imagebutton_custom_arrow_1_right1;
	ImageButton imagebutton_custom_arrow_1_right2;

	public BAWGUICreditsScreen(BAWGUICreditsMenu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 242 && mouseX < leftPos + 266 && mouseY > topPos + 104 && mouseY < topPos + 128) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.tooltip_aod_is_another_project_in_develo"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 223 && mouseX < leftPos + 247 && mouseY > topPos + 128 && mouseY < topPos + 152) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.tooltip_more_infos"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 277 && mouseX < leftPos + 301 && mouseY > topPos + -10 && mouseY < topPos + 14) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.tooltip_back"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 302 && mouseX < leftPos + 326 && mouseY > topPos + -9 && mouseY < topPos + 15) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.tooltip_close"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/bookofwisdom_open.png"), this.leftPos + 0, this.topPos + 1, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_grey.png"), this.leftPos + 252, this.topPos + 116, 0, 0, 6, 9, 6, 9);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_arcana"), 77, 28, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_idea_story"), 49, 37, -11206413, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_benl4b"), 49, 46, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_development"), 49, 58, -11206413, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_benl4b1"), 49, 67, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_textures"), 49, 78, -11206413, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_benl4b2"), 50, 87, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_special_thanks_to"), 48, 95, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_christalpower2_for"), 49, 104, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_his_template_pack"), 50, 113, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_advertisement"), 183, 29, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_more_mods"), 190, 41, -16777012, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_curseforge"), 175, 52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_modrinth"), 175, 69, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_github"), 175, 85, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_aod"), 208, 116, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_credits.label_curseforge1"), 185, 133, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + 298, this.topPos + -14, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUICreditsButtonMessage(0, x, y, z));
						BAWGUICreditsButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
						PacketDistributor.sendToServer(new BAWGUICreditsButtonMessage(1, x, y, z));
						BAWGUICreditsButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_left", imagebutton_custom_arrow_4_left);
		this.addRenderableWidget(imagebutton_custom_arrow_4_left);
		imagebutton_large_button_download = new ImageButton(this.leftPos + 225, this.topPos + 128, 20, 20,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/large_button_download.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/button_download_highlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUICreditsButtonMessage(2, x, y, z));
						BAWGUICreditsButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_large_button_download", imagebutton_large_button_download);
		this.addRenderableWidget(imagebutton_large_button_download);
		imagebutton_custom_arrow_1_right = new ImageButton(this.leftPos + 246, this.topPos + 50, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUICreditsButtonMessage(3, x, y, z));
						BAWGUICreditsButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_1_right", imagebutton_custom_arrow_1_right);
		this.addRenderableWidget(imagebutton_custom_arrow_1_right);
		imagebutton_custom_arrow_1_right1 = new ImageButton(this.leftPos + 246, this.topPos + 66, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUICreditsButtonMessage(4, x, y, z));
						BAWGUICreditsButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_1_right1", imagebutton_custom_arrow_1_right1);
		this.addRenderableWidget(imagebutton_custom_arrow_1_right1);
		imagebutton_custom_arrow_1_right2 = new ImageButton(this.leftPos + 246, this.topPos + 82, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_1_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUICreditsButtonMessage(5, x, y, z));
						BAWGUICreditsButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_1_right2", imagebutton_custom_arrow_1_right2);
		this.addRenderableWidget(imagebutton_custom_arrow_1_right2);
	}
}
