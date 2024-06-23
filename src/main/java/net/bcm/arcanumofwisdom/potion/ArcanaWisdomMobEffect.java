
package net.bcm.arcanumofwisdom.potion;

import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.bcm.arcanumofwisdom.procedures.ArcanaWisdomBeimTrankAktivierterTickProcedure;

import java.util.function.Consumer;

public class ArcanaWisdomMobEffect extends MobEffect {
	public ArcanaWisdomMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10016022);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ArcanaWisdomBeimTrankAktivierterTickProcedure.execute(entity);
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
