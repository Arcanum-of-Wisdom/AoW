package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NoCooldownsPProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(ArcanumOfWisdomModGameRules.AOW_NO_COOLDOWNS) == true) {
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.holybranch_secattack_cooldown = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.holybranch_ultattack_cooldown = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.shadowpower_cooldown = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
