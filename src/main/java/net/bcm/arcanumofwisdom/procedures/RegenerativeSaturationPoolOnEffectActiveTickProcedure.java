package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

public class RegenerativeSaturationPoolOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) <= 10
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_SATURATION_POOL) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_SATURATION_POOL).getAmplifier() : 0) <= 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 40, 255, true, false));
		} else if ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) <= 15
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_SATURATION_POOL) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_SATURATION_POOL).getAmplifier() : 0) == 2) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 40, 255, true, false));
		} else if ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) <= 20
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_SATURATION_POOL) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.REGENERATIVE_SATURATION_POOL).getAmplifier() : 0) >= 3) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 40, 255, true, false));
		}
	}
}
