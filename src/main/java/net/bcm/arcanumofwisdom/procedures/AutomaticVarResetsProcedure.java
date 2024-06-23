package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AutomaticVarResetsProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(ArcanumOfWisdomModGameRules.AOW_AUTOMATIC_COUNTDOWN_RESETS) == true) {
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
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.shadowpower_active = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
