package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RecruitoftheWisePProcedure {
	@SubscribeEvent
	public static void onPickupXP(PlayerXpEvent.PickupXp event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().get(new ResourceLocation("arcanum_of_wisdom:recruitofthe_wise"))).isDone())
				&& (entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 20) {
			if (!(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ArcanumOfWisdomModItems.HOLY_BRANCH.get())) : false)) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(ArcanumOfWisdomModItems.HOLY_BRANCH.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.item.pickup")), SoundSource.PLAYERS, 2, 0);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.item.pickup")), SoundSource.PLAYERS, 2, 0, false);
					}
				}
			}
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("arcanum_of_wisdom:recruitofthe_wise"));
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
