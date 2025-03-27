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

import net.bcm.arcanumofwisdom.world.inventory.BAWGUIAotaMenu;
import net.bcm.arcanumofwisdom.network.BAWGUIAotaButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BAWGUIAotaScreen extends AbstractContainerScreen<BAWGUIAotaMenu> {
	private final static HashMap<String, Object> guistate = BAWGUIAotaMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_custom_arrow_4_left;
	ImageButton imagebutton_custom_arrow_4_right;
	ImageButton imagebutton_custom_arrow_4_left1;
	ImageButton imagebutton_aotabooksmall;
	ImageButton imagebutton_aotapotionssmall;

	public BAWGUIAotaScreen(BAWGUIAotaMenu container, Inventory inventory, Component text) {
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
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.tooltip_next_page"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 123 && mouseX < leftPos + 147 && mouseY > topPos + 170 && mouseY < topPos + 194) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.tooltip_last_page"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/bookofwisdom_open.png"), this.leftPos + 0, this.topPos + -1, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/aotarecipecutted.png"), this.leftPos + 56, this.topPos + 75, 0, 0, 75, 65, 75, 65);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/aotasmall.png"), this.leftPos + 181, this.topPos + 105, 0, 0, 65, 50, 65, 50);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_arcana"), 63, 20, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_artifacts_can_be_processed_using"), 69, 29, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_some_items_can"), 58, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_be_crafted_into"), 55, 48, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_unique_potions"), 58, 56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_using_the_aota_which_is"), 58, 66, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_options"), 197, 22, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_simulation"), 170, 96, -13434676, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_book"), 201, 35, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_lets_you_discover"), 174, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_new_potions_and"), 177, 49, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_gives_you_hints"), 178, 57, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_potions"), 197, 67, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_lets_you_craft_the"), 170, 75, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota.label_potions1"), 188, 83, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + 298, this.topPos + -14, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIAotaButtonMessage(0, x, y, z));
						BAWGUIAotaButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
						PacketDistributor.sendToServer(new BAWGUIAotaButtonMessage(1, x, y, z));
						BAWGUIAotaButtonMessage.handleButtonAction(entity, 1, x, y, z);
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
						PacketDistributor.sendToServer(new BAWGUIAotaButtonMessage(3, x, y, z));
						BAWGUIAotaButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_left1", imagebutton_custom_arrow_4_left1);
		this.addRenderableWidget(imagebutton_custom_arrow_4_left1);
		imagebutton_aotabooksmall = new ImageButton(this.leftPos + 198, this.topPos + 127, 35, 25,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/aotabooksmall.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/aotabookhoveredsmall.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_aotabooksmall", imagebutton_aotabooksmall);
		this.addRenderableWidget(imagebutton_aotabooksmall);
		imagebutton_aotapotionssmall = new ImageButton(this.leftPos + 184, this.topPos + 105, 36, 29,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/aotapotionssmall.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/aotapotionshoveredsmall.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_aotapotionssmall", imagebutton_aotapotionssmall);
		this.addRenderableWidget(imagebutton_aotapotionssmall);
	}
}
