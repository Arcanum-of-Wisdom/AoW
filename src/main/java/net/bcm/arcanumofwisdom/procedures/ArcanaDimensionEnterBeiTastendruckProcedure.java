package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModGameRules;

public class ArcanaDimensionEnterBeiTastendruckProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(ArcanumOfWisdomModGameRules.AOW_ARCANA_DIMENSION) == true) {
			if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).arcana_active == true) {
				if ((entity.level().dimension()) == Level.OVERWORLD) {
					if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM.get())) {
						if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arcanum_of_wisdom:arcana_plains"));
							if (_player.level().dimension() == destinationType)
								return;
							ServerLevel nextLevel = _player.server.getLevel(destinationType);
							if (nextLevel != null) {
								_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
								_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
								for (MobEffectInstance _effectinstance : _player.getActiveEffects())
									_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
								_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM_COOLDOWN.get(), 1000, 1, false, false));
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM.get());
					} else if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM_COOLDOWN.get())) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("The countdown hasn't ended yet! Time left: " + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM_COOLDOWN.get())
									? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM_COOLDOWN.get()).getDuration()
									: 0))), true);
					} else if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).wisdom < 100) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("The Arcana Dimension is available at LVL 100!"), true);
					}
				} else if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("arcanum_of_wisdom:arcana_plains"))) {
					if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
						ResourceKey<Level> destinationType = Level.OVERWORLD;
						if (_player.level().dimension() == destinationType)
							return;
						ServerLevel nextLevel = _player.server.getLevel(destinationType);
						if (nextLevel != null) {
							_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
							_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
							_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
							for (MobEffectInstance _effectinstance : _player.getActiveEffects())
								_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
							_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("Cooldown:" + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM_COOLDOWN.get())
								? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM_COOLDOWN.get()).getDuration()
								: 0))), true);
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You have to be in the Overworld to use the Arcana Dimension Ability!"), true);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Arcana Dimension disabled!"), true);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("The Arcana Dimension is not enabled in this world! Ask your Admin for help or change the \"arcanaDimension\" game rule to enter this dimension."), false);
		}
	}
}
