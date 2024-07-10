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

import net.bcm.arcanumofwisdom.world.inventory.ArtifactOfDimensionsGUIMenu;
import net.bcm.arcanumofwisdom.network.ArtifactOfDimensionsGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ArtifactOfDimensionsGUIScreen extends AbstractContainerScreen<ArtifactOfDimensionsGUIMenu> {
	private final static HashMap<String, Object> guistate = ArtifactOfDimensionsGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_custom_arrow_4_right;
	ImageButton imagebutton_custom_arrow_4_right1;
	ImageButton imagebutton_custom_arrow_4_right2;

	public ArtifactOfDimensionsGUIScreen(ArtifactOfDimensionsGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("arcanum_of_wisdom:textures/screens/artifact_of_dimensions_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 221 && mouseX < leftPos + 245 && mouseY > topPos + 64 && mouseY < topPos + 88)
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_dimensions_gui.tooltip_please_read_the_information_befo1"), mouseX, mouseY);
		if (mouseX > leftPos + 222 && mouseX < leftPos + 246 && mouseY > topPos + 117 && mouseY < topPos + 141)
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_dimensions_gui.tooltip_please_read_the_information_befo2"), mouseX, mouseY);
		if (mouseX > leftPos + 221 && mouseX < leftPos + 245 && mouseY > topPos + 12 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_dimensions_gui.tooltip_please_read_the_information_befo"), mouseX, mouseY);
		if (mouseX > leftPos + 76 && mouseX < leftPos + 100 && mouseY > topPos + 183 && mouseY < topPos + 207)
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_dimensions_gui.tooltip_be_careful_when_teleporting_if"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/artifactofdimensionsbackground2.png"), this.leftPos + -113, this.topPos + -19, 0, 0, 400, 200, 400, 200);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.artifact_of_dimensions_gui.label_info"), 77, 181, -3355444, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_custom_arrow_4_right = new ImageButton(this.leftPos + 225, this.topPos + 17, 16, 16,
				new WidgetSprites(new ResourceLocation("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), new ResourceLocation("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new ArtifactOfDimensionsGUIButtonMessage(0, x, y, z));
						ArtifactOfDimensionsGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right", imagebutton_custom_arrow_4_right);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right);
		imagebutton_custom_arrow_4_right1 = new ImageButton(this.leftPos + 225, this.topPos + 69, 16, 16,
				new WidgetSprites(new ResourceLocation("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), new ResourceLocation("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new ArtifactOfDimensionsGUIButtonMessage(1, x, y, z));
						ArtifactOfDimensionsGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right1", imagebutton_custom_arrow_4_right1);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right1);
		imagebutton_custom_arrow_4_right2 = new ImageButton(this.leftPos + 225, this.topPos + 122, 16, 16,
				new WidgetSprites(new ResourceLocation("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), new ResourceLocation("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new ArtifactOfDimensionsGUIButtonMessage(2, x, y, z));
						ArtifactOfDimensionsGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
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
