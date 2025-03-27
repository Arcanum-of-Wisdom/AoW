package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.Entity;

public class GUIEntityNameReturnProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getDisplayName().getString();
	}
}
