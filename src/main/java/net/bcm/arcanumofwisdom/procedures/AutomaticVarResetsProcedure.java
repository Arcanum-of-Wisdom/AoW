package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AutomaticVarResetsProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(ArcanumOfWisdomModGameRules.AOWAUTOMATICCOOLDOWNRESETS) == true) {
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.holybranch_secattack_cooldown = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.holybranch_ultattack_cooldown = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.shadowpower_cooldown = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.shadowpower_active = false;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.SCALE))
				_livingEntity1.getAttribute(Attributes.SCALE).setBaseValue(1);
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
				_livingEntity2.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(2);
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.ATTACK_SPEED))
				_livingEntity3.getAttribute(Attributes.ATTACK_SPEED).setBaseValue(4);
			if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.BLOCK_BREAK_SPEED))
				_livingEntity4.getAttribute(Attributes.BLOCK_BREAK_SPEED).setBaseValue(1);
			if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE))
				_livingEntity5.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).setBaseValue(4.5);
			if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE))
				_livingEntity6.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).setBaseValue(3);
			if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE))
				_livingEntity7.getAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).setBaseValue(0);
			if (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.FALL_DAMAGE_MULTIPLIER))
				_livingEntity8.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).setBaseValue(1);
			if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
				_livingEntity9.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(0);
			if (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.OXYGEN_BONUS))
				_livingEntity10.getAttribute(Attributes.OXYGEN_BONUS).setBaseValue(0);
			if (entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
				_livingEntity11.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(0);
			if (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.STEP_HEIGHT))
				_livingEntity12.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(0.6);
		}
	}
}
