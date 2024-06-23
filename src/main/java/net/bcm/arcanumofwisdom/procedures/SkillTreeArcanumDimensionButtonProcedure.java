package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class SkillTreeArcanumDimensionButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).wisdom >= 100) {
			if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).arcana_active == true) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Arcana Dimension deactivated!"), true);
				{
					ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
					_vars.arcana_active = false;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Arcana Dimension activated!"), true);
				{
					ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
					_vars.arcana_active = true;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Arcana Dimension available at LVL 100!"), true);
		}
	}
}
