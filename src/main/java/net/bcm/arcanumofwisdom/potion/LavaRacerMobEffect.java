
package net.bcm.arcanumofwisdom.potion;

import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.bcm.arcanumofwisdom.procedures.LavaRacerBeimTrankAktivierterTickProcedure;

import java.util.function.Consumer;

public class LavaRacerMobEffect extends MobEffect {
	public LavaRacerMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -65436);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		LavaRacerBeimTrankAktivierterTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void initializeClient(Consumer<IClientMobEffectExtensions> consumer) {
		consumer.accept(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		});
	}
}
