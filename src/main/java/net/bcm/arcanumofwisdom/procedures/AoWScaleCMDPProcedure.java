package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class AoWScaleCMDPProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (DoubleArgumentType.getDouble(arguments, "scale") == 1) {
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
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Scale LVL (AoW algorithm with minecraft attributes) reset (1 is standard)"), false);
		} else {
			if (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.STEP_HEIGHT))
				_livingEntity14.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(0.6);
			if (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.SCALE))
				_livingEntity16.getAttribute(Attributes.SCALE).setBaseValue((DoubleArgumentType.getDouble(arguments, "scale")));
			if (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
				_livingEntity18.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((DoubleArgumentType.getDouble(arguments, "scale") / 2 + 2));
			if (entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.ATTACK_SPEED))
				_livingEntity20.getAttribute(Attributes.ATTACK_SPEED).setBaseValue((DoubleArgumentType.getDouble(arguments, "scale") / 2 + 4));
			if (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.BLOCK_BREAK_SPEED))
				_livingEntity22.getAttribute(Attributes.BLOCK_BREAK_SPEED).setBaseValue((DoubleArgumentType.getDouble(arguments, "scale")));
			if (entity instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE))
				_livingEntity24.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).setBaseValue(Math.abs(DoubleArgumentType.getDouble(arguments, "scale") + 4.5));
			if (entity instanceof LivingEntity _livingEntity26 && _livingEntity26.getAttributes().hasAttribute(Attributes.ENTITY_INTERACTION_RANGE))
				_livingEntity26.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).setBaseValue(Math.abs(DoubleArgumentType.getDouble(arguments, "scale") + 3));
			if (entity instanceof LivingEntity _livingEntity28 && _livingEntity28.getAttributes().hasAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE))
				_livingEntity28.getAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).setBaseValue((DoubleArgumentType.getDouble(arguments, "scale") / 4 + 4));
			if (entity instanceof LivingEntity _livingEntity30 && _livingEntity30.getAttributes().hasAttribute(Attributes.FALL_DAMAGE_MULTIPLIER))
				_livingEntity30.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).setBaseValue((DoubleArgumentType.getDouble(arguments, "scale") / 2 + 4));
			if (entity instanceof LivingEntity _livingEntity32 && _livingEntity32.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
				_livingEntity32.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue((DoubleArgumentType.getDouble(arguments, "scale") / 4 + 4));
			if (entity instanceof LivingEntity _livingEntity34 && _livingEntity34.getAttributes().hasAttribute(Attributes.OXYGEN_BONUS))
				_livingEntity34.getAttribute(Attributes.OXYGEN_BONUS).setBaseValue((DoubleArgumentType.getDouble(arguments, "scale")));
			if (entity instanceof LivingEntity _livingEntity36 && _livingEntity36.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
				_livingEntity36.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue((DoubleArgumentType.getDouble(arguments, "scale")));
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Scale LVL (AoW algorithm with minecraft attributes) set to " + DoubleArgumentType.getDouble(arguments, "scale"))), false);
		}
	}
}
