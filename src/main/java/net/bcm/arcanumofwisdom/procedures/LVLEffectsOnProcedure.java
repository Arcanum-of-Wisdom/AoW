package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModGameRules;

public class LVLEffectsOnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(ArcanumOfWisdomModGameRules.AOW_LEVEL_EFFECTS) == true) {
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.lvleffects = true;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("LVL effects enabled for level: " + Math.abs(entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).wisdom))), true);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("LVL Effects are deactivated! Ask your Admin for help."), false);
		}
	}
}
