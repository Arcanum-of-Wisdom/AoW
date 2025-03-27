package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FistOfDoomnotdiscoveredPProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static boolean execute(Entity entity) {
		return execute(null, entity);
	}

	private static boolean execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ArcanumOfWisdomModMobEffects.FIST_OF_DOOM) && entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).PD_FistOfDoom == false) {
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.PD_FistOfDoom = true;
				_vars.syncPlayerVariables(entity);
			}
		}
		return entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).PD_FistOfDoom;
	}
}
