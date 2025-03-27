package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.ThrownExperienceBottle;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;

public class AdjustableXPBottleOnDispenseAttemptWithResultProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction) {
		if (direction == null)
			return;
		double fromZ = 0;
		double fromX = 0;
		double fromY = 0;
		fromX = x + 0.5 + direction.getStepX() * 0.6;
		fromY = y + 0.5 + direction.getStepY() * 0.6;
		fromZ = z + 0.5 + direction.getStepZ() * 0.6;
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new ThrownExperienceBottle(EntityType.EXPERIENCE_BOTTLE, projectileLevel);
			_entityToSpawn.setPos(fromX, fromY, fromZ);
			_entityToSpawn.shoot((direction.getStepX()), (direction.getStepY()), (direction.getStepZ()), 2, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
	}
}
