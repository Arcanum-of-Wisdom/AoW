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

import net.bcm.arcanumofwisdom.world.inventory.AotaDecryptingGUIMenu;
import net.bcm.arcanumofwisdom.network.AotaDecryptingGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AotaDecryptingGUIScreen extends AbstractContainerScreen<AotaDecryptingGUIMenu> {
	private final static HashMap<String, Object> guistate = AotaDecryptingGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_custom_arrow_4_left;
	ImageButton imagebutton_custom_arrow_4_down;

	public AotaDecryptingGUIScreen(AotaDecryptingGUIMenu container, Inventory inventory, Component text) {
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
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -201 && mouseX < leftPos + -177 && mouseY > topPos + -15 && mouseY < topPos + 9) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.aota_decrypting_gui.tooltip_encrypted_alchemy_book"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -201 && mouseX < leftPos + -177 && mouseY > topPos + -41 && mouseY < topPos + -17) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.aota_decrypting_gui.tooltip_feather"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -201 && mouseX < leftPos + -177 && mouseY > topPos + -68 && mouseY < topPos + -44) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.aota_decrypting_gui.tooltip_ink_sac"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -201 && mouseX < leftPos + -177 && mouseY > topPos + -95 && mouseY < topPos + -71) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.aota_decrypting_gui.tooltip_paper"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 176 && mouseX < leftPos + 200 && mouseY > topPos + 56 && mouseY < topPos + 80) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.aota_decrypting_gui.tooltip_close"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 150 && mouseX < leftPos + 174 && mouseY > topPos + 56 && mouseY < topPos + 80) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.aota_decrypting_gui.tooltip_back"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -61 && mouseX < leftPos + -37 && mouseY > topPos + -50 && mouseY < topPos + -26) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.aota_decrypting_gui.tooltip_calculate_the_code"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 41 && mouseX < leftPos + 65 && mouseY > topPos + -50 && mouseY < topPos + -26) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.aota_decrypting_gui.tooltip_output_of_secret_items"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -138 && mouseX < leftPos + -114 && mouseY > topPos + -91 && mouseY < topPos + -67) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.aota_decrypting_gui.tooltip_paper_input"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -138 && mouseX < leftPos + -114 && mouseY > topPos + -64 && mouseY < topPos + -40) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.aota_decrypting_gui.tooltip_ink_sac_input"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -138 && mouseX < leftPos + -114 && mouseY > topPos + -37 && mouseY < topPos + -13) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.aota_decrypting_gui.tooltip_feather_input"), mouseX, mouseY);
		}
		if (mouseX > leftPos + -138 && mouseX < leftPos + -114 && mouseY > topPos + -10 && mouseY < topPos + 14) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.aota_decrypting_gui.tooltip_encrypted_alchemy_book_input"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/encryptedalchemybookgui.png"), this.leftPos + -103, this.topPos + -119, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/aotabookdecrypting.png"), this.leftPos + -369, this.topPos + -119, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/slot_frame_1.png"), this.leftPos + -137, this.topPos + -90, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/slot_frame_1.png"), this.leftPos + -137, this.topPos + -63, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/slot_frame_1.png"), this.leftPos + -137, this.topPos + -36, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/slot_frame_1.png"), this.leftPos + -137, this.topPos + -9, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/slot_frame_1.png"), this.leftPos + 42, this.topPos + -49, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_yellow.png"), this.leftPos + 50, this.topPos + -42, 0, 0, 6, 9, 6, 9);

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
		imagebutton_buttonred = new ImageButton(this.leftPos + 172, this.topPos + 52, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AotaDecryptingGUIButtonMessage(0, x, y, z));
						AotaDecryptingGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonred", imagebutton_buttonred);
		this.addRenderableWidget(imagebutton_buttonred);
		imagebutton_custom_arrow_4_left = new ImageButton(this.leftPos + 154, this.topPos + 60, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_left.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_left.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AotaDecryptingGUIButtonMessage(1, x, y, z));
						AotaDecryptingGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_left", imagebutton_custom_arrow_4_left);
		this.addRenderableWidget(imagebutton_custom_arrow_4_left);
		imagebutton_custom_arrow_4_down = new ImageButton(this.leftPos + -57, this.topPos + -46, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AotaDecryptingGUIButtonMessage(2, x, y, z));
						AotaDecryptingGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_down", imagebutton_custom_arrow_4_down);
		this.addRenderableWidget(imagebutton_custom_arrow_4_down);
	}
}
