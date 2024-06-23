package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MasterofWisdomPProcedure {
	@SubscribeEvent
	public static void onPickupXP(PlayerXpEvent.PickupXp event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 100 && !(entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
				&& _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().get(new ResourceLocation("arcanum_of_wisdom:masterof_wisdom"))).isDone())) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("arcanum_of_wisdom:masterof_wisdom"));
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
