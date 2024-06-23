package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

public class ArcanaWisdomCooldownWennDerEffektAblauftProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM.get(), (int) Double.POSITIVE_INFINITY, 1, false, false));
	}
}
