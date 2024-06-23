package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

public class ResetWisdomButtonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
			_vars.wisdom = 0;
			_vars.syncPlayerVariables(entity);
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
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"attribute @p minecraft:generic.attack_speed base set 4.0");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"attribute @p minecraft:generic.attack_damage base set 2.0");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"attribute @p minecraft:generic.max_health base set 20");
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(ArcanumOfWisdomModMobEffects.WISDOM.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(ArcanumOfWisdomModMobEffects.HOLY_SPELL.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(ArcanumOfWisdomModMobEffects.SHADOW_POWER.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(ArcanumOfWisdomModMobEffects.STUNNED.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(ArcanumOfWisdomModMobEffects.WATER_RACER.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM_COOLDOWN.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(ArcanumOfWisdomModMobEffects.GRACE_OF_THE_ARCANA.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(ArcanumOfWisdomModMobEffects.SHADOW_WARRIOR.get());
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, (float) 0.5, (float) 0.5);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, (float) 0.5, (float) 0.5, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLAME, x, y, z, 15, 0, 0, 0, 0.2);
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
