package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class HolyBranchUltAbilityPProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
			_vars.holybranch_ability_ult = true;
			_vars.syncPlayerVariables(entity);
		}
	}
}
