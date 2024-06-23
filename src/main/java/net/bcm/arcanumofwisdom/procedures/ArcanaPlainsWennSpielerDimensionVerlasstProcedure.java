package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

public class ArcanaPlainsWennSpielerDimensionVerlasstProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.NIGHT_VISION)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.NIGHT_VISION);
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(ArcanumOfWisdomModMobEffects.GRACE_OF_THE_ARCANA.get(), 60, 1, true, true));
	}
}
