
package net.bcm.arcanumofwisdom.potion;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.bcm.arcanumofwisdom.procedures.LavaRacerBeimTrankAktivierterTickProcedure;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class LavaRacerMobEffect extends MobEffect {
	public LavaRacerMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -65436);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		LavaRacerBeimTrankAktivierterTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, ArcanumOfWisdomModMobEffects.LAVA_RACER.get());
	}
}
