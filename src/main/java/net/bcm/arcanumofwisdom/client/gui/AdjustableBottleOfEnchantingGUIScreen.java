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
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.bcm.arcanumofwisdom.world.inventory.AdjustableBottleOfEnchantingGUIMenu;
import net.bcm.arcanumofwisdom.network.AdjustableBottleOfEnchantingGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdjustableBottleOfEnchantingGUIScreen extends AbstractContainerScreen<AdjustableBottleOfEnchantingGUIMenu> {
	private final static HashMap<String, Object> guistate = AdjustableBottleOfEnchantingGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox ABOE_xp_amount;
	Button button_throw;
	ImageButton imagebutton_experience_bottle;

	public AdjustableBottleOfEnchantingGUIScreen(AdjustableBottleOfEnchantingGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 1;
		this.imageHeight = 1;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		ABOE_xp_amount.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 8 && mouseX < leftPos + 32 && mouseY > topPos + 47 && mouseY < topPos + 71) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.adjustable_bottle_of_enchanting_gui.tooltip_throw"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -16 && mouseX < leftPos + 8 && mouseY > topPos + 47 && mouseY < topPos + 71) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.adjustable_bottle_of_enchanting_gui.tooltip_throw1"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -40 && mouseX < leftPos + -16 && mouseY > topPos + 47 && mouseY < topPos + 71) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.adjustable_bottle_of_enchanting_gui.tooltip_throw2"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/xpbigbottle.png"), this.leftPos + -135, this.topPos + -139, 0, 0, 256, 256, 256, 256);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (ABOE_xp_amount.isFocused())
			return ABOE_xp_amount.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String ABOE_xp_amountValue = ABOE_xp_amount.getValue();
		super.resize(minecraft, width, height);
		ABOE_xp_amount.setValue(ABOE_xp_amountValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.adjustable_bottle_of_enchanting_gui.label_select_xp_amount"), -43, 18, -16711936, false);
	}

	@Override
	public void init() {
		super.init();
		ABOE_xp_amount = new EditBox(this.font, this.leftPos + -58, this.topPos + 28, 118, 18, Component.translatable("gui.arcanum_of_wisdom.adjustable_bottle_of_enchanting_gui.ABOE_xp_amount")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.arcanum_of_wisdom.adjustable_bottle_of_enchanting_gui.ABOE_xp_amount").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.arcanum_of_wisdom.adjustable_bottle_of_enchanting_gui.ABOE_xp_amount").getString());
				else
					setSuggestion(null);
			}
		};
		ABOE_xp_amount.setMaxLength(32767);
		ABOE_xp_amount.setSuggestion(Component.translatable("gui.arcanum_of_wisdom.adjustable_bottle_of_enchanting_gui.ABOE_xp_amount").getString());
		guistate.put("text:ABOE_xp_amount", ABOE_xp_amount);
		this.addWidget(this.ABOE_xp_amount);
		button_throw = new PlainTextButton(this.leftPos + -27, this.topPos + 51, 51, 20, Component.translatable("gui.arcanum_of_wisdom.adjustable_bottle_of_enchanting_gui.button_throw"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdjustableBottleOfEnchantingGUIButtonMessage(0, x, y, z));
				AdjustableBottleOfEnchantingGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_throw", button_throw);
		this.addRenderableWidget(button_throw);
		imagebutton_experience_bottle = new ImageButton(this.leftPos + 3, this.topPos + 48, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/experience_bottle.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/experience_bottle.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AdjustableBottleOfEnchantingGUIButtonMessage(1, x, y, z));
						AdjustableBottleOfEnchantingGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_experience_bottle", imagebutton_experience_bottle);
		this.addRenderableWidget(imagebutton_experience_bottle);
	}
}
