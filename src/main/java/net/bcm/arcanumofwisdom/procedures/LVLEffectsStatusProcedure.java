package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class LVLEffectsStatusProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).lvleffects == true ? "ON" : "OFF";
	}
}
