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

import net.bcm.arcanumofwisdom.world.inventory.ButtonsGUIMenu;
import net.bcm.arcanumofwisdom.procedures.ButtonsGUIShadowPowerProcedure;
import net.bcm.arcanumofwisdom.procedures.ButtonsGUIArcanaDimensionProcedure;
import net.bcm.arcanumofwisdom.network.ButtonsGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ButtonsGUIScreen extends AbstractContainerScreen<ButtonsGUIMenu> {
	private final static HashMap<String, Object> guistate = ButtonsGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;

	public ButtonsGUIScreen(ButtonsGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("arcanum_of_wisdom:textures/screens/buttons_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/skilltree2.png"), this.leftPos + -201, this.topPos + -106, 0, 0, 400, 200, 400, 200);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.buttons_gui.label_shadow_warrior"), -167, -71, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.buttons_gui.label_arcana_dimension"), -167, 31, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.buttons_gui.label_you_can_edit_these_keys"), 34, -71, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.buttons_gui.label_in_your_settings"), 52, -61, -3355444, false);
		guiGraphics.drawString(this.font,

				ButtonsGUIShadowPowerProcedure.execute(), -167, -53, -16738048, false);
		guiGraphics.drawString(this.font,

				ButtonsGUIArcanaDimensionProcedure.execute(), -167, 48, -16738048, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.buttons_gui.label_default_n"), -167, 40, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.buttons_gui.label_default_b"), -167, -62, -6710887, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + -18, this.topPos + -120, 32, 32,
				new WidgetSprites(new ResourceLocation("arcanum_of_wisdom:textures/screens/buttonred.png"), new ResourceLocation("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new ButtonsGUIButtonMessage(0, x, y, z));
						ButtonsGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
