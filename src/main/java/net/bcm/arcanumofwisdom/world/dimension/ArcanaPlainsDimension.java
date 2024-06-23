
package net.bcm.arcanumofwisdom.world.dimension;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.renderer.DimensionSpecialEffects;

import net.bcm.arcanumofwisdom.procedures.ArcanaPlainsWennSpielerDimensionVerlasstProcedure;
import net.bcm.arcanumofwisdom.procedures.ArcanaPlainsWennSpielerDimensionBetrittProcedure;

@Mod.EventBusSubscriber
public class ArcanaPlainsDimension {
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class DimensionSpecialEffectsHandler {
		@SubscribeEvent
		public static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
			DimensionSpecialEffects customEffect = new DimensionSpecialEffects(Float.NaN, true, DimensionSpecialEffects.SkyType.NONE, false, false) {
				@Override
				public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
					return new Vec3(0.2392156863, 0.7411764706, 0.9568627451);
				}

				@Override
				public boolean isFoggyAt(int x, int y) {
					return false;
				}
			};
			event.register(new ResourceLocation("arcanum_of_wisdom:arcana_plains"), customEffect);
		}
	}

	@SubscribeEvent
	public static void onPlayerChangedDimensionEvent(PlayerEvent.PlayerChangedDimensionEvent event) {
		Entity entity = event.getEntity();
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		if (event.getFrom() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arcanum_of_wisdom:arcana_plains"))) {
			ArcanaPlainsWennSpielerDimensionVerlasstProcedure.execute(entity);
		}
		if (event.getTo() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arcanum_of_wisdom:arcana_plains"))) {
			ArcanaPlainsWennSpielerDimensionBetrittProcedure.execute(entity);
		}
	}
}
