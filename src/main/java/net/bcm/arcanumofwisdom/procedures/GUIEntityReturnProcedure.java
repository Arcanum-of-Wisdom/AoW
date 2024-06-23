package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.Entity;

public class GUIEntityReturnProcedure {
	public static Entity execute(Entity entity) {
		if (entity == null)
			return null;
		return entity;
	}
}
