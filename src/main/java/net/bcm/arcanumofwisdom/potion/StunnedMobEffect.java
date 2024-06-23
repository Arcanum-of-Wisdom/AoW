
package net.bcm.arcanumofwisdom.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.bcm.arcanumofwisdom.procedures.StunnedEffektBeimTrankAktivierterTickProcedure;

public class StunnedMobEffect extends MobEffect {
	public StunnedMobEffect() {
		super(MobEffectCategory.HARMFUL, -6710887);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		StunnedEffektBeimTrankAktivierterTickProcedure.execute(entity);
	}
}
