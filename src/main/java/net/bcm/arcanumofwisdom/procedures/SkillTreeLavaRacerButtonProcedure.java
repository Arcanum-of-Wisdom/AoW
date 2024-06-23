package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class SkillTreeLavaRacerButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).wisdom >= 20) {
			if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).lavaracer_active == true) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Lava Racer Ability deactivated!"), true);
				{
					ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
					_vars.lavaracer_active = false;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Lava Racer Ability activated!"), true);
				{
					ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
					_vars.lavaracer_active = true;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Lava Racer Ability available at LVL 20!"), true);
		}
	}
}
