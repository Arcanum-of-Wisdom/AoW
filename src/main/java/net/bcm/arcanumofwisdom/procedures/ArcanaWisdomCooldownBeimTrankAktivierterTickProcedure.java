package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

public class ArcanaWisdomCooldownBeimTrankAktivierterTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM.get());
	}
}
