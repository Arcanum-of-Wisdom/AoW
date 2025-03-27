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

import net.bcm.arcanumofwisdom.world.inventory.BAWGUIArcanaHowToEnterTheADMenu;
import net.bcm.arcanumofwisdom.network.BAWGUIArcanaHowToEnterTheADButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BAWGUIArcanaHowToEnterTheADScreen extends AbstractContainerScreen<BAWGUIArcanaHowToEnterTheADMenu> {
	private final static HashMap<String, Object> guistate = BAWGUIArcanaHowToEnterTheADMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_custom_arrow_4_left;

	public BAWGUIArcanaHowToEnterTheADScreen(BAWGUIArcanaHowToEnterTheADMenu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 203 && mouseX < leftPos + 227 && mouseY > topPos + 140 && mouseY < topPos + 164) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.tooltip_read_artifacts_to_learn_more_a"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 203 && mouseX < leftPos + 227 && mouseY > topPos + 72 && mouseY < topPos + 96) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.tooltip_this_is_the_symbol_which_you_fin"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 277 && mouseX < leftPos + 301 && mouseY > topPos + -10 && mouseY < topPos + 14) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.tooltip_back"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 301 && mouseX < leftPos + 325 && mouseY > topPos + -10 && mouseY < topPos + 14) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.tooltip_close"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/bookofwisdom_open.png"), this.leftPos + 0, this.topPos + 1, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttoncombine.png"), this.leftPos + 199, this.topPos + 68, 0, 0, 32, 32, 32, 32);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_hot_to_get_to"), 53, 26, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_the_arcana_dimension"), 53, 35, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_1_get_all_artifacts"), 47, 48, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_2_craft_a_lab_table"), 47, 56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_table"), 62, 64, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_3_combine_all"), 47, 73, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_artifacts_to_one"), 62, 81, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_combined_artifact"), 62, 89, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_4_hold_it_in_your"), 47, 98, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_offhand"), 62, 107, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_5_press_the_key"), 47, 116, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_to_enter_n"), 62, 124, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_combine_function"), 171, 42, -3368704, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_in_the"), 199, 51, -3368704, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_laboratory_table"), 172, 60, -3368704, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_standard_is_n"), 62, 132, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_arcana_how_to_enter_the_ad.label_info"), 205, 147, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + 298, this.topPos + -14, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIArcanaHowToEnterTheADButtonMessage(0, x, y, z));
						BAWGUIArcanaHowToEnterTheADButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
						PacketDistributor.sendToServer(new BAWGUIArcanaHowToEnterTheADButtonMessage(1, x, y, z));
						BAWGUIArcanaHowToEnterTheADButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_left", imagebutton_custom_arrow_4_left);
		this.addRenderableWidget(imagebutton_custom_arrow_4_left);
	}
}
