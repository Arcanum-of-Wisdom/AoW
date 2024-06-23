package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class DeactivateAllButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("All powers deactivated!"), true);
		{
			ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
			_vars.waterracer_active = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
			_vars.lavaracer_active = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
			_vars.shadowwarrior_active = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
			_vars.arcana_active = false;
			_vars.syncPlayerVariables(entity);
		}
	}
}
