package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ControloverliquidsPProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		boolean waterracer_used = false;
		boolean lavaracer_used = false;
		if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().get(new ResourceLocation("arcanum_of_wisdom:controloverliquids"))).isDone())) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(ArcanumOfWisdomModMobEffects.WATER_RACER.get()))) {
				waterracer_used = false;
			} else {
				waterracer_used = true;
			}
			if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(ArcanumOfWisdomModMobEffects.LAVA_RACER.get()))) {
				lavaracer_used = false;
			} else {
				lavaracer_used = true;
			}
		}
		if (!(entity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel && _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().get(new ResourceLocation("arcanum_of_wisdom:controloverliquids"))).isDone())
				&& waterracer_used == true && lavaracer_used == true) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("arcanum_of_wisdom:controloverliquids"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
	}
}
