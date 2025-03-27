
package net.bcm.arcanumofwisdom.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.Minecraft;

import net.bcm.arcanumofwisdom.procedures.StartupInfoMessageTeaserDisplayOverlayIngameProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber({Dist.CLIENT})
public class StartupInfoMessageTeaserOverlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		if (event.getScreen() instanceof PauseScreen) {
			int w = event.getGuiGraphics().guiWidth();
			int h = event.getGuiGraphics().guiHeight();
			Level world = null;
			double x = 0;
			double y = 0;
			double z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				world = entity.level();
				x = entity.getX();
				y = entity.getY();
				z = entity.getZ();
			}
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);
			if (StartupInfoMessageTeaserDisplayOverlayIngameProcedure.execute()) {
				event.getGuiGraphics().blit(ResourceLocation.parse("arcanum_of_wisdom:textures/screens/book_of_wisdom_small.png"), 18, 4, 0, 0, 25, 25, 25, 25);

				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.arcanum_of_wisdom.startup_info_message_teaser.label_aow_message"), w / 2 + -191, h / 2 + -124, -3407770, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.arcanum_of_wisdom.startup_info_message_teaser.label_aow_uses_minecrafts_attribute_f"), w / 2 + -191, h / 2 + -116, -9728, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.arcanum_of_wisdom.startup_info_message_teaser.label_more_information_in_the_startup"), w / 2 + -191, h / 2 + -108, -9728, false);
			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
