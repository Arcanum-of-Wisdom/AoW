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

import net.bcm.arcanumofwisdom.world.inventory.BAWGUIACT2Menu;
import net.bcm.arcanumofwisdom.network.BAWGUIACT2ButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BAWGUIACT2Screen extends AbstractContainerScreen<BAWGUIACT2Menu> {
	private final static HashMap<String, Object> guistate = BAWGUIACT2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_custom_arrow_4_left;
	ImageButton imagebutton_custom_arrow_4_right;

	public BAWGUIACT2Screen(BAWGUIACT2Menu container, Inventory inventory, Component text) {
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
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.tooltip_next_page"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/bookofwisdom_open.png"), this.leftPos + 0, this.topPos + 1, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonresearch.png"), this.leftPos + 77, this.topPos + 109, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonactextendedresearch.png"), this.leftPos + 201, this.topPos + 100, 0, 0, 32, 32, 32, 32);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_crafting_table"), 58, 28, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_you_can_implement"), 50, 36, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_artifacts_into"), 56, 44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_combat_items_to"), 55, 52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_strenghten_them"), 54, 60, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_use_a_shielddia_sword"), 60, 68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_dia_sword_to"), 59, 76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_craft_the_artifact"), 47, 84, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_netherite_shield"), 50, 92, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_sword"), 79, 100, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_extended_research"), 191, 20, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_research_mode"), 181, 28, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_you_can_implement1"), 172, 36, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_artifacts_into1"), 179, 44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_dia_armor_to"), 182, 52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_strenghten_them1"), 176, 60, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_this_is_how_you"), 177, 69, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_can_make_the"), 185, 77, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_netherite_artifact"), 170, 85, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawguiact_2.label_armor"), 204, 92, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + 298, this.topPos + -14, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIACT2ButtonMessage(0, x, y, z));
						BAWGUIACT2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
						PacketDistributor.sendToServer(new BAWGUIACT2ButtonMessage(1, x, y, z));
						BAWGUIACT2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_left", imagebutton_custom_arrow_4_left);
		this.addRenderableWidget(imagebutton_custom_arrow_4_left);
		imagebutton_custom_arrow_4_right = new ImageButton(this.leftPos + 127, this.topPos + 176, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_left.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_left.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIACT2ButtonMessage(2, x, y, z));
						BAWGUIACT2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
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
