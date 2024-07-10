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

import net.bcm.arcanumofwisdom.world.inventory.ALTResearchGUIMenu;
import net.bcm.arcanumofwisdom.network.ALTResearchGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ALTResearchGUIScreen extends AbstractContainerScreen<ALTResearchGUIMenu> {
	private final static HashMap<String, Object> guistate = ALTResearchGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_custom_arrow_1_right;
	ImageButton imagebutton_large_button_back;

	public ALTResearchGUIScreen(ALTResearchGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("arcanum_of_wisdom:textures/screens/alt_research_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 84 && mouseX < leftPos + 108 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.alt_research_gui.tooltip_click_here_to_craft_the_netherit"), mouseX, mouseY);
		if (mouseX > leftPos + 176 && mouseX < leftPos + 200 && mouseY > topPos + 148 && mouseY < topPos + 172)
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.alt_research_gui.tooltip_you_can_use_1_diamond_sword_1_n"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/altbackground.png"), this.leftPos + 0, this.topPos + -4, 0, 0, 176, 88, 176, 88);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/button_skill.png"), this.leftPos + 36, this.topPos + 27, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/button_skill_highlight.png"), this.leftPos + 16, this.topPos + 47, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/button_skill_highlight.png"), this.leftPos + 56, this.topPos + 47, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/button_vanilla_2_pressed.png"), this.leftPos + 123, this.topPos + 37, 0, 0, 20, 20, 20, 20);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.alt_research_gui.label_research"), 67, 2, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.alt_research_gui.label_info"), 177, 155, -3355444, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + 168, this.topPos + -30, 32, 32,
				new WidgetSprites(new ResourceLocation("arcanum_of_wisdom:textures/screens/buttonred.png"), new ResourceLocation("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new ALTResearchGUIButtonMessage(0, x, y, z));
						ALTResearchGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonred", imagebutton_buttonred);
		this.addRenderableWidget(imagebutton_buttonred);
		imagebutton_custom_arrow_1_right = new ImageButton(this.leftPos + 88, this.topPos + 39, 16, 16,
				new WidgetSprites(new ResourceLocation("arcanum_of_wisdom:textures/screens/custom_arrow_1_right.png"), new ResourceLocation("arcanum_of_wisdom:textures/screens/custom_arrow_1_right.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new ALTResearchGUIButtonMessage(1, x, y, z));
						ALTResearchGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_1_right", imagebutton_custom_arrow_1_right);
		this.addRenderableWidget(imagebutton_custom_arrow_1_right);
		imagebutton_large_button_back = new ImageButton(this.leftPos + 200, this.topPos + -24, 20, 20,
				new WidgetSprites(new ResourceLocation("arcanum_of_wisdom:textures/screens/large_button_back.png"), new ResourceLocation("arcanum_of_wisdom:textures/screens/large_button_back_highlight.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new ALTResearchGUIButtonMessage(2, x, y, z));
						ALTResearchGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
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
