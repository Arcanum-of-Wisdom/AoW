package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.Entity;

public class GraceoftheArcanaBeimTrankAktivierterTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.fallDistance = 0;
	}
}
