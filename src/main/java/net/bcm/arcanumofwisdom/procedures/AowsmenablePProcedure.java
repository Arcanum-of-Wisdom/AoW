package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class AowsmenablePProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
			_vars.startup_message = false;
			_vars.syncPlayerVariables(entity);
		}
		ArcanumOfWisdomModVariables.startup_message_teaser = true;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("The startup teaser is visible now and the startup message will appear once the next time you enter this world!"), false);
	}
}
