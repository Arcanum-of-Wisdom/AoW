
package net.bcm.arcanumofwisdom.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.bcm.arcanumofwisdom.procedures.ShadowPowerWennEffektStartetangewendetWirdProcedure;
import net.bcm.arcanumofwisdom.procedures.ShadowPowerBeimTrankAktivierterTickProcedure;

public class ShadowPowerMobEffect extends MobEffect {
	public ShadowPowerMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -14803426);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		ShadowPowerWennEffektStartetangewendetWirdProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		ShadowPowerBeimTrankAktivierterTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
