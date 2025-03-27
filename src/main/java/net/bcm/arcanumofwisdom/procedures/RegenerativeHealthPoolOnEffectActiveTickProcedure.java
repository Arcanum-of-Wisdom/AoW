package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

public class RegenerativeHealthPoolOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 10
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_HEALTH_POOL) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_HEALTH_POOL).getAmplifier() : 0) <= 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 255, true, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_HEALTH_POOL) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_HEALTH_POOL).getDuration() : 0, 1, false,
						false));
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 15
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_HEALTH_POOL) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_HEALTH_POOL).getAmplifier() : 0) == 2) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 255, true, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_HEALTH_POOL) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_HEALTH_POOL).getDuration() : 0, 2, false,
						false));
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 20
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_HEALTH_POOL) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_HEALTH_POOL).getAmplifier() : 0) >= 3) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 255, true, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_HEALTH_POOL) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_HEALTH_POOL).getDuration() : 0, 3, false,
						false));
		}
	}
}
