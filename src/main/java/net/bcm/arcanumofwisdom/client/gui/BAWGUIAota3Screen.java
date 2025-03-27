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

import net.bcm.arcanumofwisdom.world.inventory.BAWGUIAota3Menu;
import net.bcm.arcanumofwisdom.network.BAWGUIAota3ButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BAWGUIAota3Screen extends AbstractContainerScreen<BAWGUIAota3Menu> {
	private final static HashMap<String, Object> guistate = BAWGUIAota3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_custom_arrow_4_left;
	ImageButton imagebutton_custom_arrow_4_right;
	ImageButton imagebutton_custom_arrow_4_left1;
	ImageButton imagebutton_buttonred1;

	public BAWGUIAota3Screen(BAWGUIAota3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 200;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 165 && mouseX < leftPos + 189 && mouseY > topPos + 170 && mouseY < topPos + 194) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_3.tooltip_next_page"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 123 && mouseX < leftPos + 147 && mouseY > topPos + 170 && mouseY < topPos + 194) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_3.tooltip_last_page"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 80 && mouseX < leftPos + 104 && mouseY > topPos + 115 && mouseY < topPos + 139) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_3.tooltip_reveal_all_potion_recipes"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/bookofwisdom_open.png"), this.leftPos + 0, this.topPos + -1, 0, 0, 300, 200, 300, 200);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_3.label_arcana"), 58, 21, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_3.label_disclaimer"), 66, 35, -65485, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_3.label_the_button_below"), 54, 44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_3.label_will_open_a_list"), 55, 53, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_3.label_with_all_potion"), 57, 63, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_3.label_recipes_if_you"), 56, 73, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_3.label_want_to_find_them"), 51, 82, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_3.label_on_your_own"), 65, 90, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_aota_3.label_do_not_push_it"), 57, 99, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + 298, this.topPos + -14, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIAota3ButtonMessage(0, x, y, z));
						BAWGUIAota3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonred", imagebutton_buttonred);
		this.addRenderableWidget(imagebutton_buttonred);
		imagebutton_custom_arrow_4_left = new ImageButton(this.leftPos + 282, this.topPos + -5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_left.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_left.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIAota3ButtonMessage(1, x, y, z));
						BAWGUIAota3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_left", imagebutton_custom_arrow_4_left);
		this.addRenderableWidget(imagebutton_custom_arrow_4_left);
		imagebutton_custom_arrow_4_right = new ImageButton(this.leftPos + 169, this.topPos + 174, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right", imagebutton_custom_arrow_4_right);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right);
		imagebutton_custom_arrow_4_left1 = new ImageButton(this.leftPos + 127, this.topPos + 174, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_left.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_left.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIAota3ButtonMessage(3, x, y, z));
						BAWGUIAota3ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_left1", imagebutton_custom_arrow_4_left1);
		this.addRenderableWidget(imagebutton_custom_arrow_4_left1);
		imagebutton_buttonred1 = new ImageButton(this.leftPos + 76, this.topPos + 111, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonred1", imagebutton_buttonred1);
		this.addRenderableWidget(imagebutton_buttonred1);
	}
}
