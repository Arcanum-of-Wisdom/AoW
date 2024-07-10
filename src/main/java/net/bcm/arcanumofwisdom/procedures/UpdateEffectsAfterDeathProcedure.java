package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class UpdateEffectsAfterDeathProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			LVL5PProcedure.execute(world, x, y, z, entity);
			LVL10PProcedure.execute(world, x, y, z, entity);
			LVL30Procedure.execute(world, x, y, z, entity);
			LVL50Procedure.execute(world, x, y, z, entity);
			LVL80Procedure.execute(world, x, y, z, entity);
			LVL100Procedure.execute(world, x, y, z, entity);
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(ArcanumOfWisdomModMobEffects.WISDOM.get(), (int) Double.POSITIVE_INFINITY, 1, false, false));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5, false);
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()).getAmplifier() : 0) <= 1
					|| entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).lvleffects == false
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()).getAmplifier() : 0) <= 1
							&& entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).lvleffects == false) {
				ArcanumOfWisdomMod.queueServerWork(5, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"attribute @p minecraft:generic.luck base set 0");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"attribute @p minecraft:generic.knockback_resistance base set 0");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"attribute @p minecraft:generic.movement_speed base set 0.1");
				});
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()).getAmplifier() : 0) == 5) {
				if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).lvleffects == true) {
					ArcanumOfWisdomMod.queueServerWork(5, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.luck base set 500");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.knockback_resistance base set 0.5");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.movement_speed base set 0.13");
					});
				}
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()).getAmplifier() : 0) == 10) {
				if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).lvleffects == true) {
					ArcanumOfWisdomMod.queueServerWork(5, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.luck base set 600");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.knockback_resistance base set 0.2");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.movement_speed base set 0.14");
					});
				}
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()).getAmplifier() : 0) == 20) {
				if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).lvleffects == true) {
					ArcanumOfWisdomMod.queueServerWork(5, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.luck base set 700");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.knockback_resistance base set 0.25");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.movement_speed base set 0.14");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.attack_speed base set 5.0");
					});
				}
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()).getAmplifier() : 0) == 50) {
				if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).lvleffects == true) {
					ArcanumOfWisdomMod.queueServerWork(5, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.luck base set 850");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.knockback_resistance base set 0.3");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.movement_speed base set 0.15");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.attack_speed base set 5.5");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.attack_damage base set 2.5");
						if (!(entity instanceof LivingEntity _livEnt38 && _livEnt38.hasEffect(MobEffects.HEALTH_BOOST))) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"attribute @p minecraft:generic.max_health base set 25");
						}
					});
				}
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()).getAmplifier() : 0) == 80) {
				if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).lvleffects == true) {
					ArcanumOfWisdomMod.queueServerWork(5, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.luck base set 900");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.knockback_resistance base set 0.5");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.movement_speed base set 0.16");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.attack_speed base set 6.0");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.attack_damage base set 4.0");
						if (!(entity instanceof LivingEntity _livEnt48 && _livEnt48.hasEffect(MobEffects.HEALTH_BOOST))) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"attribute @p minecraft:generic.max_health base set 30");
						}
					});
				}
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()) ? _livEnt.getEffect(ArcanumOfWisdomModMobEffects.WISDOM.get()).getAmplifier() : 0) >= 100) {
				if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).lvleffects == true) {
					ArcanumOfWisdomMod.queueServerWork(5, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, (float) 1.5, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.luck base set 1000");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.knockback_resistance base set 1");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.movement_speed base set 0.18");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.attack_speed base set 8.0");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"attribute @p minecraft:generic.attack_damage base set 5.0");
						if (!(entity instanceof LivingEntity _livEnt58 && _livEnt58.hasEffect(MobEffects.HEALTH_BOOST))) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"attribute @p minecraft:generic.max_health base set 40");
						}
					});
				}
			}
		}
	}
}
