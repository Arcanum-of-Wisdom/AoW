
package net.bcm.arcanumofwisdom.potion;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.bcm.arcanumofwisdom.procedures.ArcanaWisdomBeimTrankAktivierterTickProcedure;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ArcanaWisdomMobEffect extends MobEffect {
	public ArcanaWisdomMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10016022);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		ArcanaWisdomBeimTrankAktivierterTickProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, ArcanumOfWisdomModMobEffects.ARCANA_WISDOM.get());
	}
}
