
package net.bcm.arcanumofwisdom.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.bcm.arcanumofwisdom.procedures.GraceoftheArcanaWennEffektStartetangewendetWirdProcedure;
import net.bcm.arcanumofwisdom.procedures.GraceoftheArcanaBeimTrankAktivierterTickProcedure;

public class GraceoftheArcanaMobEffect extends MobEffect {
	public GraceoftheArcanaMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -996502);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		GraceoftheArcanaWennEffektStartetangewendetWirdProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		GraceoftheArcanaBeimTrankAktivierterTickProcedure.execute(entity);
	}
}
