package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

public class ArcanaPlainsWennSpielerDimensionBetrittProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.NIGHT_VISION))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 60, 1, false, false));
		}
		if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(ArcanumOfWisdomModMobEffects.STUNNED.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(ArcanumOfWisdomModMobEffects.STUNNED.get());
		}
		if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(ArcanumOfWisdomModMobEffects.HOLY_SPELL.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(ArcanumOfWisdomModMobEffects.HOLY_SPELL.get());
		}
		if (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.BAD_OMEN)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.BAD_OMEN);
		}
		if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.UNLUCK)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.UNLUCK);
		}
	}
}
