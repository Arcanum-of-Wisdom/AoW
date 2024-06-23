package net.bcm.arcanumofwisdom.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.bcm.arcanumofwisdom.world.inventory.LVLEffectsGUIMenu;
import net.bcm.arcanumofwisdom.procedures.WisdomOverlayTextProcedure;
import net.bcm.arcanumofwisdom.procedures.LVLEffectsWarningDisplayConditionProcedure;
import net.bcm.arcanumofwisdom.procedures.LVLEffectsStatusProcedure;
import net.bcm.arcanumofwisdom.procedures.LVLEffectsOnDisplayConditionProcedure;
import net.bcm.arcanumofwisdom.procedures.LVLEffectsOffDisplayConditionProcedure;
import net.bcm.arcanumofwisdom.network.LVLEffectsGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class LVLEffectsGUIScreen extends AbstractContainerScreen<LVLEffectsGUIMenu> {
	private final static HashMap<String, Object> guistate = LVLEffectsGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_off;
	Button button_on;
	ImageButton imagebutton_buttonred;

	public LVLEffectsGUIScreen(LVLEffectsGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("arcanum_of_wisdom:textures/screens/lvl_effects_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 175 && mouseX < leftPos + 199 && mouseY > topPos + 97 && mouseY < topPos + 121)
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.lvl_effects_gui.tooltip_every_wisdom_level_enables_verta"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/skilltree2.png"), this.leftPos + -202, this.topPos + -105, 0, 0, 400, 200, 400, 200);

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
		if (LVLEffectsWarningDisplayConditionProcedure.execute(world))
			guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.lvl_effects_gui.label_empty"), -63, 58, -65536, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.lvl_effects_gui.label_lvl_effects"), -168, -69, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.lvl_effects_gui.label_info"), 176, 97, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.lvl_effects_gui.label_status"), -168, -32, -1, false);
		guiGraphics.drawString(this.font,

				LVLEffectsStatusProcedure.execute(entity), -168, -23, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.lvl_effects_gui.label_wisdom_lvl"), -168, 1, -1, false);
		guiGraphics.drawString(this.font,

				WisdomOverlayTextProcedure.execute(entity), -168, 10, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.lvl_effects_gui.label_lvl_effects_can_be_deactivated_b"), 58, -70, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.lvl_effects_gui.label_deactivated_by_admins"), 48, -62, -3355444, false);
	}

	@Override
	public void init() {
		super.init();
		button_off = new PlainTextButton(this.leftPos + -132, this.topPos + -60, 40, 20, Component.translatable("gui.arcanum_of_wisdom.lvl_effects_gui.button_off"), e -> {
			if (LVLEffectsOffDisplayConditionProcedure.execute(world, entity)) {
				PacketDistributor.SERVER.noArg().send(new LVLEffectsGUIButtonMessage(0, x, y, z));
				LVLEffectsGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (LVLEffectsOffDisplayConditionProcedure.execute(world, entity))
					super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:button_off", button_off);
		this.addRenderableWidget(button_off);
		button_on = new PlainTextButton(this.leftPos + -168, this.topPos + -60, 35, 20, Component.translatable("gui.arcanum_of_wisdom.lvl_effects_gui.button_on"), e -> {
			if (LVLEffectsOnDisplayConditionProcedure.execute(world, entity)) {
				PacketDistributor.SERVER.noArg().send(new LVLEffectsGUIButtonMessage(1, x, y, z));
				LVLEffectsGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (LVLEffectsOnDisplayConditionProcedure.execute(world, entity))
					super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:button_on", button_on);
		this.addRenderableWidget(button_on);
		imagebutton_buttonred = new ImageButton(this.leftPos + -18, this.topPos + -120, 32, 32,
				new WidgetSprites(new ResourceLocation("arcanum_of_wisdom:textures/screens/buttonred.png"), new ResourceLocation("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new LVLEffectsGUIButtonMessage(2, x, y, z));
						LVLEffectsGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
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
