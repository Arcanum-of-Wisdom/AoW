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

import net.bcm.arcanumofwisdom.world.inventory.AltarOfTheAlchemistPotionsGUIMenu;
import net.bcm.arcanumofwisdom.procedures.RedstonelampActivatePProcedure;
import net.bcm.arcanumofwisdom.procedures.RedstonelampActivate2PProcedure;
import net.bcm.arcanumofwisdom.network.AltarOfTheAlchemistPotionsGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AltarOfTheAlchemistPotionsGUIScreen extends AbstractContainerScreen<AltarOfTheAlchemistPotionsGUIMenu> {
	private final static HashMap<String, Object> guistate = AltarOfTheAlchemistPotionsGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_button_gear;
	ImageButton imagebutton_buttonred;

	public AltarOfTheAlchemistPotionsGUIScreen(AltarOfTheAlchemistPotionsGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("arcanum_of_wisdom:textures/screens/altar_of_the_alchemist_potions_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 76 && mouseX < leftPos + 100 && mouseY > topPos + 44 && mouseY < topPos + 68) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_potions_gui.tooltip_glass_bottle"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -57 && mouseX < leftPos + -33 && mouseY > topPos + 21 && mouseY < topPos + 45) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_potions_gui.tooltip_redstone"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 36 && mouseX < leftPos + 60 && mouseY > topPos + 44 && mouseY < topPos + 68) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_potions_gui.tooltip_water_bucket"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 116 && mouseX < leftPos + 140 && mouseY > topPos + 44 && mouseY < topPos + 68) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_potions_gui.tooltip_empty"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 159 && mouseX < leftPos + 183 && mouseY > topPos + 45 && mouseY < topPos + 69) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_potions_gui.tooltip_activate_brewing_stand"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 207 && mouseX < leftPos + 231 && mouseY > topPos + 44 && mouseY < topPos + 68) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_potions_gui.tooltip_output"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -57 && mouseX < leftPos + -33 && mouseY > topPos + 45 && mouseY < topPos + 69) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_potions_gui.tooltip_ominous_potion"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 259 && mouseX < leftPos + 283 && mouseY > topPos + -20 && mouseY < topPos + 4) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_potions_gui.tooltip_close"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -33 && mouseX < leftPos + -9 && mouseY > topPos + 22 && mouseY < topPos + 46) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_potions_gui.tooltip_when_both_lamps_turn_red_the_ma"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -33 && mouseX < leftPos + -9 && mouseY > topPos + 46 && mouseY < topPos + 70) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_potions_gui.tooltip_when_both_lamps_turn_red_the_ma1"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/altarofthealchemistpotionsgui.png"), this.leftPos + -89, this.topPos + 0, 0, 0, 352, 176, 352, 176);

		if (RedstonelampActivatePProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/redstonelampred.png"), this.leftPos + -32, this.topPos + 26, 0, 0, 16, 16, 16, 16);
		}
		if (RedstonelampActivatePProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/black_item.png"), this.leftPos + -53, this.topPos + 26, 0, 0, 16, 16, 16, 16);
		}
		if (RedstonelampActivate2PProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/redstonelampred.png"), this.leftPos + -32, this.topPos + 48, 0, 0, 16, 16, 16, 16);
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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_button_gear = new ImageButton(this.leftPos + 161, this.topPos + 47, 20, 20,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/button_gear.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/button_gear_highlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AltarOfTheAlchemistPotionsGUIButtonMessage(0, x, y, z));
						AltarOfTheAlchemistPotionsGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_gear", imagebutton_button_gear);
		this.addRenderableWidget(imagebutton_button_gear);
		imagebutton_buttonred = new ImageButton(this.leftPos + 255, this.topPos + -24, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AltarOfTheAlchemistPotionsGUIButtonMessage(1, x, y, z));
						AltarOfTheAlchemistPotionsGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonred", imagebutton_buttonred);
		this.addRenderableWidget(imagebutton_buttonred);
	}
}
