package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class ShadowWarriorOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
			_vars.shadowpower_cooldown = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).shadowpower_cooldown - 1;
			_vars.syncPlayerVariables(entity);
		}
	}
}
