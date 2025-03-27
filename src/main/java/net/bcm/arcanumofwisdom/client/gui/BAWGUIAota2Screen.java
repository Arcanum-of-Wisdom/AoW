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

import net.bcm.arcanumofwisdom.world.inventory.BAWGUIAota2Menu;
import net.bcm.arcanumofwisdom.network.BAWGUIAota2ButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BAWGUIAota2Screen extends AbstractContainerScreen<BAWGUIAota2Menu> {
	private final static HashMap<String, Object> guistate = BAWGUIAota2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_custom_arrow_4_left;
	ImageButton imagebutton_custom_arrow_4_right;
	ImageButton imagebutton_custom_arrow_4_left1;

	public BAWGUIAota2Screen(BAWGUIAota2Menu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 165 && mouseX < leftPos + 189 && mouseY > topPos + 170 && mouseY < topPos + 194) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.tooltip_next_page"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 123 && mouseX < leftPos + 147 && mouseY > topPos + 170 && mouseY < topPos + 194) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.tooltip_last_page"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 201 && mouseX < leftPos + 225 && mouseY > topPos + 132 && mouseY < topPos + 156) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.tooltip_potion_name_recipe"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/bookofwisdom_open.png"), this.leftPos + 0, this.topPos + -1, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/black_item.png"), this.leftPos + 52, this.topPos + 84, 0, 0, 8, 8, 8, 8);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/black_item.png"), this.leftPos + 52, this.topPos + 94, 0, 0, 8, 8, 8, 8);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/redstonelampred.png"), this.leftPos + 63, this.topPos + 84, 0, 0, 8, 8, 8, 8);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/redstonelampred.png"), this.leftPos + 63, this.topPos + 94, 0, 0, 8, 8, 8, 8);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/black_item.png"), this.leftPos + 57, this.topPos + 104, 0, 0, 8, 8, 8, 8);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/black_item.png"), this.leftPos + 57, this.topPos + 114, 0, 0, 8, 8, 8, 8);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/black_item.png"), this.leftPos + 52, this.topPos + 124, 0, 0, 8, 8, 8, 8);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/button_gear.png"), this.leftPos + 102, this.topPos + 144, 0, 0, 10, 10, 10, 10);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_yellow.png"), this.leftPos + 64, this.topPos + 124, 0, 0, 6, 9, 6, 9);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/totem.png"), this.leftPos + 205, this.topPos + 136, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_arcana"), 61, 19, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_the_new_potions"), 54, 27, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_to_craft_one_of_the"), 45, 39, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_new_potions_you_must"), 54, 47, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_have_to_insert"), 57, 55, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_these_items_into_the"), 51, 63, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_the_marked_slots"), 50, 71, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_1"), 53, 83, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_2"), 53, 93, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_3"), 58, 103, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_4"), 58, 113, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_5"), 53, 123, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_redstone_dust"), 73, 83, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_ominous_bottle"), 73, 93, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_water_bucket"), 73, 103, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_glass_bottle"), 73, 114, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_secret_item"), 73, 124, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_when_you_are_ready"), 49, 134, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_click"), 67, 144, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_how_to_get"), 189, 19, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_the_secret_items"), 175, 28, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_to_get_secret_items"), 173, 38, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_you_have_to_find_random"), 176, 47, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_the_right_items_to"), 169, 56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_put_in_slot_5"), 183, 66, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_once_you_drank_a"), 174, 76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_new_potion_you"), 179, 85, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_unlock_the_recipe"), 174, 95, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_and_it_will_be_shown_in"), 175, 104, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_when_you_hover_over"), 182, 113, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_2.label_over_it"), 168, 122, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + 298, this.topPos + -14, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIAota2ButtonMessage(0, x, y, z));
						BAWGUIAota2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
						PacketDistributor.sendToServer(new BAWGUIAota2ButtonMessage(1, x, y, z));
						BAWGUIAota2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_left", imagebutton_custom_arrow_4_left);
		this.addRenderableWidget(imagebutton_custom_arrow_4_left);
		imagebutton_custom_arrow_4_right = new ImageButton(this.leftPos + 169, this.topPos + 174, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right", imagebutton_custom_arrow_4_right);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right);
		imagebutton_custom_arrow_4_left1 = new ImageButton(this.leftPos + 127, this.topPos + 174, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_left.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_left.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIAota2ButtonMessage(3, x, y, z));
						BAWGUIAota2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_left1", imagebutton_custom_arrow_4_left1);
		this.addRenderableWidget(imagebutton_custom_arrow_4_left1);
	}
}
