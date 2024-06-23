
package net.bcm.arcanumofwisdom.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.bcm.arcanumofwisdom.procedures.HolySpellWennEffektStartetangewendetWirdProcedure;

public class HolySpellMobEffect extends MobEffect {
	public HolySpellMobEffect() {
		super(MobEffectCategory.HARMFUL, -13369345);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		HolySpellWennEffektStartetangewendetWirdProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
