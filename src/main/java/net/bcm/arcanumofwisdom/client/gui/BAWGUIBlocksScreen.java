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

import net.bcm.arcanumofwisdom.world.inventory.BAWGUIBlocksMenu;
import net.bcm.arcanumofwisdom.network.BAWGUIBlocksButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BAWGUIBlocksScreen extends AbstractContainerScreen<BAWGUIBlocksMenu> {
	private final static HashMap<String, Object> guistate = BAWGUIBlocksMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_custom_arrow_4_left;
	ImageButton imagebutton_custom_arrow_4_right;
	ImageButton imagebutton_custom_arrow_4_right1;
	ImageButton imagebutton_custom_arrow_4_right2;

	public BAWGUIBlocksScreen(BAWGUIBlocksMenu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 47 && mouseX < leftPos + 71 && mouseY > topPos + 84 && mouseY < topPos + 108) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.tooltip_artifact_laboratory_table"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 47 && mouseX < leftPos + 71 && mouseY > topPos + 108 && mouseY < topPos + 132) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.tooltip_artifact_crafting_table"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 132 && mouseY < topPos + 156) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.tooltip_altar_of_the_alchemist"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 278 && mouseX < leftPos + 302 && mouseY > topPos + -10 && mouseY < topPos + 14) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.tooltip_back"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 302 && mouseX < leftPos + 326 && mouseY > topPos + -10 && mouseY < topPos + 14) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.tooltip_close"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 122 && mouseX < leftPos + 146 && mouseY > topPos + 84 && mouseY < topPos + 108) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.tooltip_more_information"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 122 && mouseX < leftPos + 146 && mouseY > topPos + 109 && mouseY < topPos + 133) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.tooltip_more_information1"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 122 && mouseX < leftPos + 146 && mouseY > topPos + 134 && mouseY < topPos + 158) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.tooltip_more_information2"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/bookofwisdom_open.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 300, 200, 300, 200);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.label_arcana"), 77, 28, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.label_there_are_three"), 54, 37, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.label_special_blocks_in"), 49, 46, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.label_aow_which_all_have"), 58, 56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.label_have_unique"), 66, 65, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.label_functions"), 69, 75, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.label_alt"), 50, 91, -16724941, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.label_act"), 51, 117, -16724941, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_blocks.label_aota"), 51, 141, -16724941, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + 298, this.topPos + -14, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIBlocksButtonMessage(0, x, y, z));
						BAWGUIBlocksButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
						PacketDistributor.sendToServer(new BAWGUIBlocksButtonMessage(1, x, y, z));
						BAWGUIBlocksButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_left", imagebutton_custom_arrow_4_left);
		this.addRenderableWidget(imagebutton_custom_arrow_4_left);
		imagebutton_custom_arrow_4_right = new ImageButton(this.leftPos + 125, this.topPos + 88, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIBlocksButtonMessage(2, x, y, z));
						BAWGUIBlocksButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right", imagebutton_custom_arrow_4_right);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right);
		imagebutton_custom_arrow_4_right1 = new ImageButton(this.leftPos + 125, this.topPos + 113, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIBlocksButtonMessage(3, x, y, z));
						BAWGUIBlocksButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right1", imagebutton_custom_arrow_4_right1);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right1);
		imagebutton_custom_arrow_4_right2 = new ImageButton(this.leftPos + 125, this.topPos + 137, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIBlocksButtonMessage(4, x, y, z));
						BAWGUIBlocksButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right2", imagebutton_custom_arrow_4_right2);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right2);
	}
}
