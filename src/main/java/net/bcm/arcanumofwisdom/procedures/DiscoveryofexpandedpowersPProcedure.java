package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DiscoveryofexpandedpowersPProcedure {
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
		if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
				&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().get(new ResourceLocation("arcanum_of_wisdom:discoveryofexpandedpowers"))).isDone())
				&& entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_ability_1 == true) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("arcanum_of_wisdom:discoveryofexpandedpowers"));
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
