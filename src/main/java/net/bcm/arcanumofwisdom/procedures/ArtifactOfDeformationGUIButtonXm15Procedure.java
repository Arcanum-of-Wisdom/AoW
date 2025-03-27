package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModGameRules;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class ArtifactOfDeformationGUIButtonXm15Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.isClientSide())
			Minecraft.getInstance().gameRenderer.displayItemActivation((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
		if (world.getLevelData().getGameRules().getBoolean(ArcanumOfWisdomModGameRules.AOWNOCOOLDOWNS) == false) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 1000);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.PLAYERS, 2, (float) 0.8);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.PLAYERS, 2, (float) 0.8, false);
			}
		}
		if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.SCALE))
			_livingEntity6.getAttribute(Attributes.SCALE).setBaseValue(0.5);
		if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE))
			_livingEntity7.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).setBaseValue(0.5);
		if (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE))
			_livingEntity8.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).setBaseValue(0.2);
		if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.FALL_DAMAGE_MULTIPLIER))
			_livingEntity9.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).setBaseValue(0.2);
		if (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.STEP_HEIGHT))
			_livingEntity10.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(0.25);
		if (entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.BLOCK_BREAK_SPEED))
			_livingEntity11.getAttribute(Attributes.BLOCK_BREAK_SPEED).setBaseValue(0.6);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 2, false, false));
		ArcanumOfWisdomMod.queueServerWork(300, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.PLAYERS, 1, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.PLAYERS, 1, (float) 0.8, false);
				}
			}
			if (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.SCALE))
				_livingEntity14.getAttribute(Attributes.SCALE).setBaseValue(1);
			if (entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.FALL_DAMAGE_MULTIPLIER))
				_livingEntity15.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).setBaseValue(1);
			if (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE))
				_livingEntity16.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).setBaseValue(3);
			if (entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE))
				_livingEntity17.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).setBaseValue(4.5);
			if (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.STEP_HEIGHT))
				_livingEntity18.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(0.6);
			if (entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.BLOCK_BREAK_SPEED))
				_livingEntity19.getAttribute(Attributes.BLOCK_BREAK_SPEED).setBaseValue(1);
		});
	}
}
