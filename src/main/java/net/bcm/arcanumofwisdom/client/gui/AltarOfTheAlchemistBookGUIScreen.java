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

import net.bcm.arcanumofwisdom.world.inventory.AltarOfTheAlchemistBookGUIMenu;
import net.bcm.arcanumofwisdom.procedures.TotemnotdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.TotemdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.RegensatnotdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.RegensatdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.RegenHPnotdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.RegenHPdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.MiningboosternotdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.MiningboosterdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.InstantsaturationnotdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.InstantsaturationdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.InstantcomebacknotdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.InstantcomebackdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.FistboosternotdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.FistboosterdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.FistOfDoomnotdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.FistOfDoomdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.ElytryenhancerdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.ElytraenhancernotdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.ArmorboosternotdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.procedures.ArmorboosterdiscoveredPProcedure;
import net.bcm.arcanumofwisdom.network.AltarOfTheAlchemistBookGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AltarOfTheAlchemistBookGUIScreen extends AbstractContainerScreen<AltarOfTheAlchemistBookGUIMenu> {
	private final static HashMap<String, Object> guistate = AltarOfTheAlchemistBookGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_buttonred;
	ImageButton imagebutton_aotabookmark;

	public AltarOfTheAlchemistBookGUIScreen(AltarOfTheAlchemistBookGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 260;
		this.imageHeight = 200;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (ElytraenhancernotdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 25 && mouseX < leftPos + 49 && mouseY > topPos + 46 && mouseY < topPos + 70) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_elytra_enhancer"), mouseX, mouseY);
			}
		if (RegenHPnotdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 46 && mouseY < topPos + 70) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_regenerative_health_pool"), mouseX, mouseY);
			}
		if (TotemnotdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 73 && mouseX < leftPos + 97 && mouseY > topPos + 46 && mouseY < topPos + 70) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_totem"), mouseX, mouseY);
			}
		if (InstantsaturationnotdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 97 && mouseX < leftPos + 121 && mouseY > topPos + 46 && mouseY < topPos + 70) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_instant_saturation"), mouseX, mouseY);
			}
		if (RegensatnotdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 25 && mouseX < leftPos + 49 && mouseY > topPos + 70 && mouseY < topPos + 94) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_regenerative_saturation_pool"), mouseX, mouseY);
			}
		if (InstantcomebacknotdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 70 && mouseY < topPos + 94) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_instant_comeback"), mouseX, mouseY);
			}
		if (ElytryenhancerdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 25 && mouseX < leftPos + 49 && mouseY > topPos + 46 && mouseY < topPos + 70) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_elytra_enhancer1"), mouseX, mouseY);
			}
		if (RegenHPdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 46 && mouseY < topPos + 70) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_regenerative_health_pool1"), mouseX, mouseY);
			}
		if (TotemdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 73 && mouseX < leftPos + 97 && mouseY > topPos + 46 && mouseY < topPos + 70) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_totem1"), mouseX, mouseY);
			}
		if (InstantsaturationdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 97 && mouseX < leftPos + 121 && mouseY > topPos + 46 && mouseY < topPos + 70) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_instant_saturation1"), mouseX, mouseY);
			}
		if (RegensatdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 25 && mouseX < leftPos + 49 && mouseY > topPos + 70 && mouseY < topPos + 94) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_regenerative_saturation_pool1"), mouseX, mouseY);
			}
		if (InstantcomebackdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 70 && mouseY < topPos + 94) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_instant_comeback1"), mouseX, mouseY);
			}
		if (ArmorboosternotdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 73 && mouseX < leftPos + 97 && mouseY > topPos + 70 && mouseY < topPos + 94) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_armor_booster"), mouseX, mouseY);
			}
		if (ArmorboosterdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 73 && mouseX < leftPos + 97 && mouseY > topPos + 70 && mouseY < topPos + 94) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_armor_booster1"), mouseX, mouseY);
			}
		if (MiningboosterdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 97 && mouseX < leftPos + 121 && mouseY > topPos + 70 && mouseY < topPos + 94) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_mining_booster"), mouseX, mouseY);
			}
		if (MiningboosternotdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 97 && mouseX < leftPos + 121 && mouseY > topPos + 70 && mouseY < topPos + 94) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_mining_booster_iron_pickaxe"), mouseX, mouseY);
			}
		if (FistboosterdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 25 && mouseX < leftPos + 49 && mouseY > topPos + 94 && mouseY < topPos + 118) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_fistbooster"), mouseX, mouseY);
			}
		if (FistboosternotdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 25 && mouseX < leftPos + 49 && mouseY > topPos + 94 && mouseY < topPos + 118) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_fistbooster_blazerod"), mouseX, mouseY);
			}
		if (FistOfDoomdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 94 && mouseY < topPos + 118) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_fist_of_doom"), mouseX, mouseY);
			}
		if (FistOfDoomnotdiscoveredPProcedure.execute(entity))
			if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 94 && mouseY < topPos + 118) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_fist_of_doom_lava_bucket"), mouseX, mouseY);
			}
		if (mouseX > leftPos + 55 && mouseX < leftPos + 79 && mouseY > topPos + 157 && mouseY < topPos + 181) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_chapter_1_decrypting_encrypted"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 51 && mouseX < leftPos + 75 && mouseY > topPos + 181 && mouseY < topPos + 205) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_chapter_1_decrypting_encrypted1"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 258 && mouseX < leftPos + 282 && mouseY > topPos + -22 && mouseY < topPos + 2) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.tooltip_close"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/altarofthealchemistbookgui.png"), this.leftPos + -20, this.topPos + -1, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/elytraenhancer.png"), this.leftPos + 29, this.topPos + 50, 0, 0, 16, 16, 16, 16);

		if (ElytryenhancerdiscoveredPProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_grey.png"), this.leftPos + 32, this.topPos + 49, 0, 0, 12, 18, 12, 18);
		}

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/regenhp.png"), this.leftPos + 52, this.topPos + 50, 0, 0, 16, 16, 16, 16);

		if (RegenHPdiscoveredPProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_grey.png"), this.leftPos + 55, this.topPos + 49, 0, 0, 12, 18, 12, 18);
		}

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/totem.png"), this.leftPos + 76, this.topPos + 50, 0, 0, 16, 16, 16, 16);

		if (TotemdiscoveredPProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_grey.png"), this.leftPos + 79, this.topPos + 49, 0, 0, 12, 18, 12, 18);
		}

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/regensatpool.png"), this.leftPos + 29, this.topPos + 74, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/instantsat.png"), this.leftPos + 100, this.topPos + 50, 0, 0, 16, 16, 16, 16);

		if (InstantsaturationdiscoveredPProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_grey.png"), this.leftPos + 103, this.topPos + 49, 0, 0, 12, 18, 12, 18);
		}
		if (RegensatdiscoveredPProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_grey.png"), this.leftPos + 32, this.topPos + 73, 0, 0, 12, 18, 12, 18);
		}

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/instantcomeback.png"), this.leftPos + 52, this.topPos + 74, 0, 0, 16, 16, 16, 16);

		if (InstantcomebackdiscoveredPProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_grey.png"), this.leftPos + 55, this.topPos + 73, 0, 0, 12, 18, 12, 18);
		}

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/armorbooster.png"), this.leftPos + 76, this.topPos + 74, 0, 0, 16, 16, 16, 16);

		if (ArmorboosterdiscoveredPProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_grey.png"), this.leftPos + 79, this.topPos + 73, 0, 0, 12, 18, 12, 18);
		}

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/miningbooster.png"), this.leftPos + 100, this.topPos + 74, 0, 0, 16, 16, 16, 16);

		if (MiningboosterdiscoveredPProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_grey.png"), this.leftPos + 103, this.topPos + 73, 0, 0, 12, 18, 12, 18);
		}

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/fistbooster.png"), this.leftPos + 29, this.topPos + 98, 0, 0, 16, 16, 16, 16);

		if (FistboosterdiscoveredPProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_grey.png"), this.leftPos + 32, this.topPos + 97, 0, 0, 12, 18, 12, 18);
		}

		guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/fistofdoom.png"), this.leftPos + 52, this.topPos + 98, 0, 0, 16, 16, 16, 16);

		if (FistOfDoomdiscoveredPProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/question_mark_grey.png"), this.leftPos + 55, this.topPos + 97, 0, 0, 12, 18, 12, 18);
		}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.label_discovered_alchemist"), 47, 19, -16711841, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.label_alchemist"), 49, 27, -16711843, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.arcanum_of_wisdom.altar_of_the_alchemist_book_gui.label_potions"), 55, 35, -16711843, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_buttonred = new ImageButton(this.leftPos + 254, this.topPos + -25, 32, 32,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonred.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/buttonredhighlight.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AltarOfTheAlchemistBookGUIButtonMessage(0, x, y, z));
						AltarOfTheAlchemistBookGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_buttonred", imagebutton_buttonred);
		this.addRenderableWidget(imagebutton_buttonred);
		imagebutton_aotabookmark = new ImageButton(this.leftPos + 27, this.topPos + 152, 75, 50,
				new WidgetSprites(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/aotabookmark.png"), ResourceLocation.parse("arcanum_of_wisdom:textures/screens/aotabookmarkhighlighted.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AltarOfTheAlchemistBookGUIButtonMessage(1, x, y, z));
						AltarOfTheAlchemistBookGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_aotabookmark", imagebutton_aotabookmark);
		this.addRenderableWidget(imagebutton_aotabookmark);
	}
}
