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

import net.bcm.arcanumofwisdom.world.inventory.AltarOfTheAlchemistGUIMenu;
import net.bcm.arcanumofwisdom.network.AltarOfTheAlchemistGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AltarOfTheAlchemistGUIScreen extends AbstractContainerScreen<AltarOfTheAlchemistGUIMenu> {
	private final static HashMap<String, Object> guistate = AltarOfTheAlchemistGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_altarofthealchemistbook;
	ImageButton imagebutton_altarofthealchemistpotions;
	ImageButton imagebutton_buttonredhighlight;

	public AltarOfTheAlchemistGUIScreen(AltarOfTheAlchemistGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 260;
		this.imageHeight = 200;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 236 && mouseX < leftPos + 260 && mouseY > topPos + -1 && mouseY < topPos + 23) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_gui.tooltip_close"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/alatarofthealchemistgui.png"), this.leftPos + 0, this.topPos + -2, 0, 0, 260, 200, 260, 200);

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
		imagebutton_altarofthealchemistbook = new ImageButton(this.leftPos + 64, this.topPos + 87, 138, 98,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/altarofthealchemistbook.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/altarofthealchemistbookhover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AltarOfTheAlchemistGUIButtonMessage(0, x, y, z));
						AltarOfTheAlchemistGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_altarofthealchemistbook", imagebutton_altarofthealchemistbook);
		this.addRenderableWidget(imagebutton_altarofthealchemistbook);
		imagebutton_altarofthealchemistpotions = new ImageButton(this.leftPos + 11, this.topPos + -1, 142, 113,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/altarofthealchemistpotions.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/altarofthealchemistpotionshover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AltarOfTheAlchemistGUIButtonMessage(1, x, y, z));
						AltarOfTheAlchemistGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_altarofthealchemistpotions", imagebutton_altarofthealchemistpotions);
		this.addRenderableWidget(imagebutton_altarofthealchemistpotions);
		imagebutton_buttonredhighlight = new ImageButton(this.leftPos + 232, this.topPos + -4, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AltarOfTheAlchemistGUIButtonMessage(2, x, y, z));
						AltarOfTheAlchemistGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonredhighlight", imagebutton_buttonredhighlight);
		this.addRenderableWidget(imagebutton_buttonredhighlight);
	}
}
