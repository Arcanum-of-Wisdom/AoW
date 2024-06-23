package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class ResetHolyBranchCountdownsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
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
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Countdown reset performed! Info: The visual cooldown on the Holy Branch has not been changed."), false);
	}
}
