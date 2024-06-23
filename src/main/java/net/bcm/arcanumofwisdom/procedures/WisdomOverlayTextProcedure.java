package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class WisdomOverlayTextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + Math.round(entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).wisdom);
	}
}
