package net.bcm.arcanumofwisdom.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.bcm.arcanumofwisdom.world.inventory.BAWGUIModSupportMenu;
import net.bcm.arcanumofwisdom.procedures.ConnectModsReturnProcedure;
import net.bcm.arcanumofwisdom.procedures.ConnectModsReturnNegativeProcedure;
import net.bcm.arcanumofwisdom.network.BAWGUIModSupportButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BAWGUIModSupportScreen extends AbstractContainerScreen<BAWGUIModSupportMenu> {
	private final static HashMap<String, Object> guistate = BAWGUIModSupportMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_github;
	Button button_curseforge;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_custom_arrow_4_left;
	ImageButton imagebutton_button_gear;
	ImageButton imagebutton_large_button_download;
	ImageButton imagebutton_custom_arrow_4_right;

	public BAWGUIModSupportScreen(BAWGUIModSupportMenu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 200 && mouseX < leftPos + 224 && mouseY > topPos + 17 && mouseY < topPos + 41) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.tooltip_arcanum_of_dimensions"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 120 && mouseX < leftPos + 144 && mouseY > topPos + 120 && mouseY < topPos + 144) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.tooltip_click_on_github_or_curseforge"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 80 && mouseX < leftPos + 104 && mouseY > topPos + 109 && mouseY < topPos + 133) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.tooltip_get_forwarded_to_the_github_qa"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 80 && mouseX < leftPos + 104 && mouseY > topPos + 133 && mouseY < topPos + 157) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.tooltip_get_forwarded_to_the_curseforge"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 201 && mouseX < leftPos + 225 && mouseY > topPos + 132 && mouseY < topPos + 156) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.tooltip_toggle_shared_features"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 277 && mouseX < leftPos + 301 && mouseY > topPos + -9 && mouseY < topPos + 15) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.tooltip_back"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 302 && mouseX < leftPos + 326 && mouseY > topPos + -10 && mouseY < topPos + 14) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.tooltip_close"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 332 && mouseX < leftPos + 356 && mouseY > topPos + 192 && mouseY < topPos + 216) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.tooltip_open_creditspage"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/bookofwisdom_open.png"), this.leftPos + 0, this.topPos + 1, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/bgpart_bookofwisdom.png"), this.leftPos + 0, this.topPos + -1, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_grey.png"), this.leftPos + 125, this.topPos + 124, 0, 0, 12, 18, 12, 18);

		if (ConnectModsReturnNegativeProcedure.execute(world)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/light_bulb_red.png"), this.leftPos + 227, this.topPos + 136, 0, 0, 16, 16, 16, 16);
		}
		if (ConnectModsReturnProcedure.execute(world)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/light_bulb_green.png"), this.leftPos + 227, this.topPos + 136, 0, 0, 16, 16, 16, 16);
		}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_arcana"), 63, 23, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_this_mod_is"), 63, 33, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_compatible_with"), 52, 41, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_almost_all_mods"), 53, 49, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_however_aow_uses"), 49, 57, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_ingame_attributes"), 48, 65, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_be_careful_when"), 55, 74, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_manipulating_these"), 47, 83, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_for_questions"), 58, 95, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_ask_here"), 70, 104, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_aod"), 205, 25, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_aod_is_a_secondary"), 169, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_mod_based_on_the_story"), 175, 48, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_story_of_aow"), 182, 56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_you_can_install_it"), 169, 64, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_independently_of"), 169, 72, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_aow_or_together"), 177, 81, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_if_so_please_use"), 171, 89, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_aow_loadsecmods"), 178, 98, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_to_enable_connected"), 173, 106, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_connected_features"), 171, 114, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_or_click_here"), 178, 122, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_download_aod_here"), 155, 182, -13369345, false);
		if (ConnectModsReturnNegativeProcedure.execute(world))
			guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_off"), 227, 139, -3407821, false);
		if (ConnectModsReturnProcedure.execute(world))
			guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_on"), 229, 139, -16724941, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.label_credits"), 288, 199, -3355444, false);
	}

	@Override
	public void init() {
		super.init();
		button_github = new PlainTextButton(this.leftPos + 75, this.topPos + 116, 66, 20, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.button_github"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new BAWGUIModSupportButtonMessage(0, x, y, z));
				BAWGUIModSupportButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_github", button_github);
		this.addRenderableWidget(button_github);
		button_curseforge = new PlainTextButton(this.leftPos + 66, this.topPos + 137, 87, 20, Component.translatable("gui.arcanum_of_wisdom.bawgui_mod_support.button_curseforge"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new BAWGUIModSupportButtonMessage(1, x, y, z));
				BAWGUIModSupportButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_curseforge", button_curseforge);
		this.addRenderableWidget(button_curseforge);
		imagebutton_buttonred = new ImageButton(this.leftPos + 298, this.topPos + -14, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIModSupportButtonMessage(2, x, y, z));
						BAWGUIModSupportButtonMessage.handleButtonAction(entity, 2, x, y, z);
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
						PacketDistributor.sendToServer(new BAWGUIModSupportButtonMessage(3, x, y, z));
						BAWGUIModSupportButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_left", imagebutton_custom_arrow_4_left);
		this.addRenderableWidget(imagebutton_custom_arrow_4_left);
		imagebutton_button_gear = new ImageButton(this.leftPos + 203, this.topPos + 134, 20, 20,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/button_gear.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/button_gear_highlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIModSupportButtonMessage(4, x, y, z));
						BAWGUIModSupportButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_gear", imagebutton_button_gear);
		this.addRenderableWidget(imagebutton_button_gear);
		imagebutton_large_button_download = new ImageButton(this.leftPos + 253, this.topPos + 177, 20, 20,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/large_button_download.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/button_download_highlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIModSupportButtonMessage(5, x, y, z));
						BAWGUIModSupportButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_large_button_download", imagebutton_large_button_download);
		this.addRenderableWidget(imagebutton_large_button_download);
		imagebutton_custom_arrow_4_right = new ImageButton(this.leftPos + 336, this.topPos + 197, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIModSupportButtonMessage(6, x, y, z));
						BAWGUIModSupportButtonMessage.handleButtonAction(entity, 6, x, y, z);
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
