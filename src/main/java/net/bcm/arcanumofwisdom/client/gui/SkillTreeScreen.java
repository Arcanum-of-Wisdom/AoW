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
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.bcm.arcanumofwisdom.world.inventory.SkillTreeMenu;
import net.bcm.arcanumofwisdom.procedures.GUIEntityReturnProcedure;
import net.bcm.arcanumofwisdom.network.SkillTreeButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SkillTreeScreen extends AbstractContainerScreen<SkillTreeMenu> {
	private final static HashMap<String, Object> guistate = SkillTreeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_water_racer;
	Button button_lava_racer;
	Button button_shadow_warrior;
	Button button_arcana_dimension;
	Button button_deactivate_all;
	Button button_activate_all;
	Button button_lvl_effects;
	Button button_buttons;
	Button button_night_hunter;
	ImageButton imagebutton_buttonred;

	public SkillTreeScreen(SkillTreeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("arcanum_of_wisdom:textures/screens/skill_tree.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (GUIEntityReturnProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			this.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 1, this.topPos + 38, 40, 0f + (float) Math.atan((this.leftPos + 1 - mouseX) / 40.0), (float) Math.atan((this.topPos + -11 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("arcanum_of_wisdom:textures/screens/skilltree2.png"), this.leftPos + -199, this.topPos + -101, 0, 0, 400, 200, 400, 200);

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
		button_water_racer = new PlainTextButton(this.leftPos + 54, this.topPos + -54, 82, 20, Component.translatable("gui.arcanum_of_wisdom.skill_tree.button_water_racer"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new SkillTreeButtonMessage(0, x, y, z));
				SkillTreeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_water_racer", button_water_racer);
		this.addRenderableWidget(button_water_racer);
		button_lava_racer = new PlainTextButton(this.leftPos + 71, this.topPos + -37, 77, 20, Component.translatable("gui.arcanum_of_wisdom.skill_tree.button_lava_racer"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new SkillTreeButtonMessage(1, x, y, z));
				SkillTreeButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_lava_racer", button_lava_racer);
		this.addRenderableWidget(button_lava_racer);
		button_shadow_warrior = new PlainTextButton(this.leftPos + 71, this.topPos + 14, 98, 20, Component.translatable("gui.arcanum_of_wisdom.skill_tree.button_shadow_warrior"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new SkillTreeButtonMessage(2, x, y, z));
				SkillTreeButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_shadow_warrior", button_shadow_warrior);
		this.addRenderableWidget(button_shadow_warrior);
		button_arcana_dimension = new PlainTextButton(this.leftPos + 45, this.topPos + 40, 108, 20, Component.translatable("gui.arcanum_of_wisdom.skill_tree.button_arcana_dimension"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new SkillTreeButtonMessage(3, x, y, z));
				SkillTreeButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_arcana_dimension", button_arcana_dimension);
		this.addRenderableWidget(button_arcana_dimension);
		button_deactivate_all = Button.builder(Component.translatable("gui.arcanum_of_wisdom.skill_tree.button_deactivate_all"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new SkillTreeButtonMessage(4, x, y, z));
				SkillTreeButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + -159, this.topPos + -47, 98, 20).build();
		guistate.put("button:button_deactivate_all", button_deactivate_all);
		this.addRenderableWidget(button_deactivate_all);
		button_activate_all = Button.builder(Component.translatable("gui.arcanum_of_wisdom.skill_tree.button_activate_all"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new SkillTreeButtonMessage(5, x, y, z));
				SkillTreeButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + -153, this.topPos + -67, 87, 20).build();
		guistate.put("button:button_activate_all", button_activate_all);
		this.addRenderableWidget(button_activate_all);
		button_lvl_effects = Button.builder(Component.translatable("gui.arcanum_of_wisdom.skill_tree.button_lvl_effects"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new SkillTreeButtonMessage(6, x, y, z));
				SkillTreeButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + -151, this.topPos + 42, 82, 20).build();
		guistate.put("button:button_lvl_effects", button_lvl_effects);
		this.addRenderableWidget(button_lvl_effects);
		button_buttons = new PlainTextButton(this.leftPos + 165, this.topPos + 99, 61, 20, Component.translatable("gui.arcanum_of_wisdom.skill_tree.button_buttons"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new SkillTreeButtonMessage(7, x, y, z));
				SkillTreeButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_buttons", button_buttons);
		this.addRenderableWidget(button_buttons);
		button_night_hunter = new PlainTextButton(this.leftPos + 37, this.topPos + -71, 87, 20, Component.translatable("gui.arcanum_of_wisdom.skill_tree.button_night_hunter"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new SkillTreeButtonMessage(8, x, y, z));
				SkillTreeButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_night_hunter", button_night_hunter);
		this.addRenderableWidget(button_night_hunter);
		imagebutton_buttonred = new ImageButton(this.leftPos + -15, this.topPos + -113, 32, 32,
				new WidgetSprites(new ResourceLocation("arcanum_of_wisdom:textures/screens/buttonred.png"), new ResourceLocation("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new SkillTreeButtonMessage(9, x, y, z));
						SkillTreeButtonMessage.handleButtonAction(entity, 9, x, y, z);
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
