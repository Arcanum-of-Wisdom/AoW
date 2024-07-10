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

import net.bcm.arcanumofwisdom.world.inventory.ALTCombineGUIMenu;
import net.bcm.arcanumofwisdom.network.ALTCombineGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ALTCombineGUIScreen extends AbstractContainerScreen<ALTCombineGUIMenu> {
	private final static HashMap<String, Object> guistate = ALTCombineGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_custom_arrow_1_right;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_large_button_back;

	public ALTCombineGUIScreen(ALTCombineGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("arcanum_of_wisdom:textures/screens/alt_combine_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 75 && mouseX < leftPos + 99 && mouseY > topPos + 26 && mouseY < topPos + 50)
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.alt_combine_gui.tooltip_click_here_to_combine_all_5_arti"), mouseX, mouseY);
		if (mouseX > leftPos + 174 && mouseX < leftPos + 198 && mouseY > topPos + 147 && mouseY < topPos + 171)
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.alt_combine_gui.tooltip_use_all_5_artifacts_to_craft_a_c"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/altbackground.png"), this.leftPos + -1, this.topPos + -6, 0, 0, 176, 88, 176, 88);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/button_vanilla_2_pressed.png"), this.leftPos + 103, this.topPos + 27, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/button_skill.png"), this.leftPos + 54, this.topPos + 16, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/button_skill.png"), this.leftPos + 28, this.topPos + 16, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/button_skill.png"), this.leftPos + 28, this.topPos + 38, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/button_skill.png"), this.leftPos + 54, this.topPos + 38, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/button_skill.png"), this.leftPos + 41, this.topPos + 51, 0, 0, 20, 20, 20, 20);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.alt_combine_gui.label_research"), 68, -17, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.alt_combine_gui.label_info"), 175, 155, -3355444, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_custom_arrow_1_right = new ImageButton(this.leftPos + 79, this.topPos + 29, 16, 16,
				new WidgetSprites(new ResourceLocation("arcanum_of_wisdom:textures/screens/custom_arrow_1_right.png"), new ResourceLocation("arcanum_of_wisdom:textures/screens/custom_arrow_1_right.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new ALTCombineGUIButtonMessage(0, x, y, z));
						ALTCombineGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_1_right", imagebutton_custom_arrow_1_right);
		this.addRenderableWidget(imagebutton_custom_arrow_1_right);
		imagebutton_buttonred = new ImageButton(this.leftPos + 167, this.topPos + -30, 32, 32,
				new WidgetSprites(new ResourceLocation("arcanum_of_wisdom:textures/screens/buttonred.png"), new ResourceLocation("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new ALTCombineGUIButtonMessage(1, x, y, z));
						ALTCombineGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonred", imagebutton_buttonred);
		this.addRenderableWidget(imagebutton_buttonred);
		imagebutton_large_button_back = new ImageButton(this.leftPos + 199, this.topPos + -24, 20, 20,
				new WidgetSprites(new ResourceLocation("arcanum_of_wisdom:textures/screens/large_button_back.png"), new ResourceLocation("arcanum_of_wisdom:textures/screens/large_button_back_highlight.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new ALTCombineGUIButtonMessage(2, x, y, z));
						ALTCombineGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_large_button_back", imagebutton_large_button_back);
		this.addRenderableWidget(imagebutton_large_button_back);
	}
}
