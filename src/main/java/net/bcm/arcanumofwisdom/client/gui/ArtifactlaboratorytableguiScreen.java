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

import net.bcm.arcanumofwisdom.world.inventory.ArtifactlaboratorytableguiMenu;
import net.bcm.arcanumofwisdom.network.ArtifactlaboratorytableguiButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ArtifactlaboratorytableguiScreen extends AbstractContainerScreen<ArtifactlaboratorytableguiMenu> {
	private final static HashMap<String, Object> guistate = ArtifactlaboratorytableguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_combine;
	Button button_research;
	ImageButton imagebutton_buttonred;

	public ArtifactlaboratorytableguiScreen(ArtifactlaboratorytableguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("arcanum_of_wisdom:textures/screens/artifactlaboratorytablegui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 96 && mouseX < leftPos + 120 && mouseY > topPos + 34 && mouseY < topPos + 58)
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifactlaboratorytablegui.tooltip_you_can_combine_all_5_artifacts"), mouseX, mouseY);
		if (mouseX > leftPos + 96 && mouseX < leftPos + 120 && mouseY > topPos + 7 && mouseY < topPos + 31)
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifactlaboratorytablegui.tooltip_you_can_study_artifacts_to_imple"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/altbackground.png"), this.leftPos + 0, this.topPos + -6, 0, 0, 176, 88, 176, 88);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/book_of_wisdom_small.png"), this.leftPos + 96, this.topPos + 34, 0, 0, 25, 25, 25, 25);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/book_of_wisdom_small.png"), this.leftPos + 96, this.topPos + 7, 0, 0, 25, 25, 25, 25);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.artifactlaboratorytablegui.label_artifact_laboratory_table"), 24, -16, -6710887, false);
	}

	@Override
	public void init() {
		super.init();
		button_combine = new PlainTextButton(this.leftPos + 29, this.topPos + 35, 61, 20, Component.translatable("gui.arcanum_of_wisdom.artifactlaboratorytablegui.button_combine"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new ArtifactlaboratorytableguiButtonMessage(0, x, y, z));
				ArtifactlaboratorytableguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_combine", button_combine);
		this.addRenderableWidget(button_combine);
		button_research = new PlainTextButton(this.leftPos + 29, this.topPos + 7, 67, 20, Component.translatable("gui.arcanum_of_wisdom.artifactlaboratorytablegui.button_research"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new ArtifactlaboratorytableguiButtonMessage(1, x, y, z));
				ArtifactlaboratorytableguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_research", button_research);
		this.addRenderableWidget(button_research);
		imagebutton_buttonred = new ImageButton(this.leftPos + 168, this.topPos + -30, 32, 32,
				new WidgetSprites(new ResourceLocation("arcanum_of_wisdom:textures/screens/buttonred.png"), new ResourceLocation("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new ArtifactlaboratorytableguiButtonMessage(2, x, y, z));
						ArtifactlaboratorytableguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
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
