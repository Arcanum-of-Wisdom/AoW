package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class UpdateEffectsAfterDeathProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			LVL5PProcedure.execute(world, x, y, z, entity);
			LVL10PProcedure.execute(world, x, y, z, entity);
			LVL30Procedure.execute(world, x, y, z, entity);
			LVL50Procedure.execute(world, x, y, z, entity);
			LVL80Procedure.execute(world, x, y, z, entity);
			LVL100Procedure.execute(world, x, y, z, entity);
		}
	}
}
