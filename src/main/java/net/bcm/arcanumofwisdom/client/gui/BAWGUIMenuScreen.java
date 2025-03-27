package net.bcm.arcanumofwisdom.client.gui;

import org.joml.Vector3f;
import org.joml.Quaternionf;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.bcm.arcanumofwisdom.world.inventory.BAWGUIMenuMenu;
import net.bcm.arcanumofwisdom.procedures.GUIEntityReturnProcedure;
import net.bcm.arcanumofwisdom.procedures.GUIEntityNameReturnProcedure;
import net.bcm.arcanumofwisdom.network.BAWGUIMenuButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BAWGUIMenuScreen extends AbstractContainerScreen<BAWGUIMenuMenu> {
	private final static HashMap<String, Object> guistate = BAWGUIMenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_custom_arrow_4_right;
	ImageButton imagebutton_custom_arrow_4_right1;
	ImageButton imagebutton_custom_arrow_4_right2;
	ImageButton imagebutton_custom_arrow_4_right3;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_custom_arrow_4_right4;
	ImageButton imagebutton_custom_arrow_4_right5;

	public BAWGUIMenuScreen(BAWGUIMenuMenu container, Inventory inventory, Component text) {
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
		if (GUIEntityReturnProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			this.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 96, this.topPos + 148, 62, 0f + (float) Math.atan((this.leftPos + 96 - mouseX) / 40.0), (float) Math.atan((this.topPos + 99 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 279 && mouseX < leftPos + 303 && mouseY > topPos + -12 && mouseY < topPos + 12) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.tooltip_close"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 84 && mouseX < leftPos + 108 && mouseY > topPos + 125 && mouseY < topPos + 149) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.tooltip_yes_thats_you_d"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 170 && mouseX < leftPos + 194 && mouseY > topPos + 137 && mouseY < topPos + 161) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.tooltip_yes_thats_your_name"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 194 && mouseX < leftPos + 218 && mouseY > topPos + 137 && mouseY < topPos + 161) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.tooltip_forgot_your_name_well_here_it_i"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 84 && mouseX < leftPos + 108 && mouseY > topPos + 101 && mouseY < topPos + 125) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.tooltip_you_look_great_today_d"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 84 && mouseX < leftPos + 108 && mouseY > topPos + 77 && mouseY < topPos + 101) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.tooltip_you_look_great_today_d1"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 84 && mouseX < leftPos + 108 && mouseY > topPos + 53 && mouseY < topPos + 77) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.tooltip_you_look_great_today_d2"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 205 && mouseX < leftPos + 229 && mouseY > topPos + 20 && mouseY < topPos + 44) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.tooltip_arcanum_of_wisdom"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/bookofwisdom_open.png"), this.leftPos + 1, this.topPos + 0, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/altcombinebuttonhovered.png"), this.leftPos + 74, this.topPos + 35, 0, 10, 32, 10, 32, 32);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.label_the_book_of_arcana_wisdom"), 209, 27, -14241, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.label_artifacts"), 172, 53, -13421773, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.label_laboratory_table"), 172, 89, -13421773, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.label_wisdom"), 172, 107, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.label_arcana"), 172, 35, -13421773, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.label_welcome"), 171, 139, -13312, false);
		guiGraphics.drawString(this.font,

				GUIEntityNameReturnProcedure.execute(entity), 171, 147, -13312, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.label_items"), 172, 71, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.bawgui_menu.label_mod_support"), 172, 125, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_custom_arrow_4_right = new ImageButton(this.leftPos + 248, this.topPos + 33, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIMenuButtonMessage(0, x, y, z));
						BAWGUIMenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right", imagebutton_custom_arrow_4_right);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right);
		imagebutton_custom_arrow_4_right1 = new ImageButton(this.leftPos + 248, this.topPos + 51, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIMenuButtonMessage(1, x, y, z));
						BAWGUIMenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right1", imagebutton_custom_arrow_4_right1);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right1);
		imagebutton_custom_arrow_4_right2 = new ImageButton(this.leftPos + 248, this.topPos + 87, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIMenuButtonMessage(2, x, y, z));
						BAWGUIMenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right2", imagebutton_custom_arrow_4_right2);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right2);
		imagebutton_custom_arrow_4_right3 = new ImageButton(this.leftPos + 248, this.topPos + 104, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIMenuButtonMessage(3, x, y, z));
						BAWGUIMenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right3", imagebutton_custom_arrow_4_right3);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right3);
		imagebutton_buttonred = new ImageButton(this.leftPos + 276, this.topPos + -16, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIMenuButtonMessage(4, x, y, z));
						BAWGUIMenuButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonred", imagebutton_buttonred);
		this.addRenderableWidget(imagebutton_buttonred);
		imagebutton_custom_arrow_4_right4 = new ImageButton(this.leftPos + 248, this.topPos + 69, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIMenuButtonMessage(5, x, y, z));
						BAWGUIMenuButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right4", imagebutton_custom_arrow_4_right4);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right4);
		imagebutton_custom_arrow_4_right5 = new ImageButton(this.leftPos + 248, this.topPos + 122, 16, 16,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_4_right.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/custom_arrow_5_right.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new BAWGUIMenuButtonMessage(6, x, y, z));
						BAWGUIMenuButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_custom_arrow_4_right5", imagebutton_custom_arrow_4_right5);
		this.addRenderableWidget(imagebutton_custom_arrow_4_right5);
	}

	private void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
		Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
		Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
		pose.mul(cameraOrientation);
		float f2 = entity.yBodyRot;
		float f3 = entity.getYRot();
		float f4 = entity.getXRot();
		float f5 = entity.yHeadRotO;
		float f6 = entity.yHeadRot;
		entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
		entity.setYRot(180.0F + angleXComponent * 40.0F);
		entity.setXRot(-angleYComponent * 20.0F);
		entity.yHeadRot = entity.getYRot();
		entity.yHeadRotO = entity.getYRot();
		InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, new Vector3f(0, 0, 0), pose, cameraOrientation, entity);
		entity.yBodyRot = f2;
		entity.setYRot(f3);
		entity.setXRot(f4);
		entity.yHeadRotO = f5;
		entity.yHeadRot = f6;
	}
}
