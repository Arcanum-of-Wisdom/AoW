package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class ShowOverlayRightProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).overlay == true;
	}
}
