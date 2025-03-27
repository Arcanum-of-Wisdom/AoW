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

import net.bcm.arcanumofwisdom.world.inventory.ArtifactcraftingtableGUIMenu;
import net.bcm.arcanumofwisdom.network.ArtifactcraftingtableGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ArtifactcraftingtableGUIScreen extends AbstractContainerScreen<ArtifactcraftingtableGUIMenu> {
	private final static HashMap<String, Object> guistate = ArtifactcraftingtableGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_buttonresearch;
	ImageButton imagebutton_buttonactextendedresearch;

	public ArtifactcraftingtableGUIScreen(ArtifactcraftingtableGUIMenu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 58 && mouseX < leftPos + 82 && mouseY > topPos + 50 && mouseY < topPos + 74) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifactcraftingtable_gui.tooltip_you_can_study_artifacts_to_imple"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 93 && mouseX < leftPos + 117 && mouseY > topPos + 50 && mouseY < topPos + 74) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifactcraftingtable_gui.tooltip_you_can_extend_your_research_and"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 176 && mouseX < leftPos + 200 && mouseY > topPos + -8 && mouseY < topPos + 16) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.artifactcraftingtable_gui.tooltip_close"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.artifactcraftingtable_gui.label_artifact_laboratory_table"), 27, 7, -6710887, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + 172, this.topPos + -12, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArtifactcraftingtableGUIButtonMessage(0, x, y, z));
						ArtifactcraftingtableGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonred", imagebutton_buttonred);
		this.addRenderableWidget(imagebutton_buttonred);
		imagebutton_buttonresearch = new ImageButton(this.leftPos + 54, this.topPos + 46, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonresearch.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/actresearchbuttonhovered.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArtifactcraftingtableGUIButtonMessage(1, x, y, z));
						ArtifactcraftingtableGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonresearch", imagebutton_buttonresearch);
		this.addRenderableWidget(imagebutton_buttonresearch);
		imagebutton_buttonactextendedresearch = new ImageButton(this.leftPos + 90, this.topPos + 46, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonactextendedresearch.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonactextendedresearchhovered.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArtifactcraftingtableGUIButtonMessage(2, x, y, z));
						ArtifactcraftingtableGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonactextendedresearch", imagebutton_buttonactextendedresearch);
		this.addRenderableWidget(imagebutton_buttonactextendedresearch);
	}
}
