package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

public class ShadowPowerKeyBeiTastendruckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ArcanumOfWisdomModMobEffects.SHADOW_WARRIOR.get())) {
			if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).shadowwarrior_active == true) {
				if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).shadowpower_cooldown <= 0) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(ArcanumOfWisdomModMobEffects.SHADOW_POWER.get(), 120, 1, true, true));
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Shadow Power activated!"), true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("item.firecharge.use")), SoundSource.PLAYERS, 1, 2);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("item.firecharge.use")), SoundSource.PLAYERS, 1, 2, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("particle.soul_escape")), SoundSource.PLAYERS, 2, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("particle.soul_escape")), SoundSource.PLAYERS, 2, 1, false);
						}
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("The countdown hasn\u00B4t ended yet! Time left:" + Math.round(Math.abs(entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).shadowpower_cooldown)))), true);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Shadow Warrior Abilities disabled!"), true);
			}
		} else if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).wisdom < 50) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Shadow Warrior Abilities available at LVL 50!"), true);
		} else if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).shadowwarrior_active == false) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Shadow Warrior Abilities disabled!"), true);
		}
	}
}
