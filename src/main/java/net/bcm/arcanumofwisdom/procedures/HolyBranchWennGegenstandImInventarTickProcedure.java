package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class HolyBranchWennGegenstandImInventarTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_secattack_cooldown > 0) {
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.holybranch_secattack_cooldown = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_secattack_cooldown - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_ultattack_cooldown > 0) {
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.holybranch_ultattack_cooldown = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_ultattack_cooldown - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
