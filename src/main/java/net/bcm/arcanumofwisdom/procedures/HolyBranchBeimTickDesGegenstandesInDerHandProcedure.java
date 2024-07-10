package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModItems;

public class HolyBranchBeimTickDesGegenstandesInDerHandProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArcanumOfWisdomModItems.HOLY_BRANCH.get()) {
			if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_ability_1 == true) {
				{
					ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
					_vars.holybranch_ability_1 = false;
					_vars.syncPlayerVariables(entity);
				}
				if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).wisdom >= 20 && entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_secattack_cooldown == 0) {
					{
						ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
						_vars.holybranch_secattack_cooldown = 100;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 100);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 50, 3, 0.5, 3, 0.1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.activate")), SoundSource.PLAYERS, 1, (float) 1.2);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.activate")), SoundSource.PLAYERS, 1, (float) 1.2, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.activate")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.activate")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"effect give @e[distance=..5] arcanum_of_wisdom:stunned 2 1 true");
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(ArcanumOfWisdomModMobEffects.STUNNED.get());
				} else if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).wisdom < 20) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Second Ability available at LVL 20!"), true);
				} else if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_secattack_cooldown > 0) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("The countdown hasn't ended yet!"), true);
				}
			}
			if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_ability_ult == true) {
				{
					ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
					_vars.holybranch_ability_ult = false;
					_vars.syncPlayerVariables(entity);
				}
				if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).wisdom >= 80 && entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_ultattack_cooldown == 0
						&& entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_secattack_cooldown == 0 && entity.isShiftKeyDown()) {
					if (world.isClientSide())
						Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.end_portal.spawn")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.end_portal.spawn")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.portal.trigger")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.portal.trigger")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.power_select")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.power_select")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					{
						ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
						_vars.holybranch_secattack_cooldown = 1000;
						_vars.syncPlayerVariables(entity);
					}
					{
						ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
						_vars.holybranch_ultattack_cooldown = 1000;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 1000);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 10, 1, 0.5, 1, 0.5);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ENCHANT, x, y, z, 20, 1, 0.5, 1, 0.5);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 10, 1, 0.5, 1, 0.5);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.CLOUD, x, y, z, 10, 1, 0, 1, 0.5);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"effect give @e[distance=..5] arcanum_of_wisdom:holy_spell 1 1 false");
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(ArcanumOfWisdomModMobEffects.HOLY_SPELL.get());
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(ArcanumOfWisdomModMobEffects.STUNNED.get());
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.BLINDNESS);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.DARKNESS);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 60, 1, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 1, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 80, 1, false, false));
				} else if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).wisdom < 80 && entity.isShiftKeyDown()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Ultimate ability is available at LVL 80!"), true);
				} else if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_ultattack_cooldown > 0 && entity.isShiftKeyDown()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("The countdown hasn't ended yet! Time left: " + entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_ultattack_cooldown)), true);
				}
			}
		}
	}
}
