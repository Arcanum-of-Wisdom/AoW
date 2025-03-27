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

import net.bcm.arcanumofwisdom.world.inventory.ArtifactlaboratorytableguiMenu;
import net.bcm.arcanumofwisdom.network.ArtifactlaboratorytableguiButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ArtifactlaboratorytableguiScreen extends AbstractContainerScreen<ArtifactlaboratorytableguiMenu> {
	private final static HashMap<String, Object> guistate = ArtifactlaboratorytableguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_buttoncombine;
	ImageButton imagebutton_buttondestroy;
	ImageButton imagebutton_buttonextract;

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

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 76 && mouseX < leftPos + 100 && mouseY > topPos + 49 && mouseY < topPos + 73) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifactlaboratorytablegui.tooltip_you_can_combine_all_5_artifacts"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 25 && mouseX < leftPos + 49 && mouseY > topPos + 50 && mouseY < topPos + 74) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifactlaboratorytablegui.tooltip_you_can_extract_all_5_artifacts"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 126 && mouseX < leftPos + 150 && mouseY > topPos + 49 && mouseY < topPos + 73) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifactlaboratorytablegui.tooltip_you_can_destroy_artifacts_to_ext"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 176 && mouseX < leftPos + 200 && mouseY > topPos + -8 && mouseY < topPos + 16) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifactlaboratorytablegui.tooltip_close"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/book_of_wisdom_small.png"), this.leftPos + 54, this.topPos + 49, 0, 0, 25, 25, 25, 25);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/book_of_wisdom_small.png"), this.leftPos + 93, this.topPos + 49, 0, 0, 25, 25, 25, 25);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/book_of_wisdom_small.png"), this.leftPos + 15, this.topPos + 49, 0, 0, 25, 25, 25, 25);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/book_of_wisdom_small.png"), this.leftPos + 132, this.topPos + 49, 0, 0, 25, 25, 25, 25);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/altbackground.png"), this.leftPos + 0, this.topPos + 18, 0, 0, 176, 88, 176, 88);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.artifactlaboratorytablegui.label_artifact_laboratory_table"), 22, 7, -6710887, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + 172, this.topPos + -12, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArtifactlaboratorytableguiButtonMessage(0, x, y, z));
						ArtifactlaboratorytableguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonred", imagebutton_buttonred);
		this.addRenderableWidget(imagebutton_buttonred);
		imagebutton_buttoncombine = new ImageButton(this.leftPos + 72, this.topPos + 45, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttoncombine.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/altcombinebuttonhovered.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArtifactlaboratorytableguiButtonMessage(1, x, y, z));
						ArtifactlaboratorytableguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttoncombine", imagebutton_buttoncombine);
		this.addRenderableWidget(imagebutton_buttoncombine);
		imagebutton_buttondestroy = new ImageButton(this.leftPos + 122, this.topPos + 45, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttondestroy.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/altdestroybuttonhovered.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArtifactlaboratorytableguiButtonMessage(2, x, y, z));
						ArtifactlaboratorytableguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttondestroy", imagebutton_buttondestroy);
		this.addRenderableWidget(imagebutton_buttondestroy);
		imagebutton_buttonextract = new ImageButton(this.leftPos + 21, this.topPos + 46, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonextract.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/altextractbuttonhovered.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArtifactlaboratorytableguiButtonMessage(3, x, y, z));
						ArtifactlaboratorytableguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonextract", imagebutton_buttonextract);
		this.addRenderableWidget(imagebutton_buttonextract);
	}
}
