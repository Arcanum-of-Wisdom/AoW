package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class ToggleOverlayProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).overlay == true) {
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.overlay = false;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).overlay == false) {
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.overlay = true;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
