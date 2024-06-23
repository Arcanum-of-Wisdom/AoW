package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

public class ActivateAllButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("All powers activated!"), true);
		{
			ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
			_vars.waterracer_active = true;
			_vars.syncPlayerVariables(entity);
		}
		{
			ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
			_vars.lavaracer_active = true;
			_vars.syncPlayerVariables(entity);
		}
		{
			ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
			_vars.shadowwarrior_active = true;
			_vars.syncPlayerVariables(entity);
		}
		{
			ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
			_vars.arcana_active = true;
			_vars.syncPlayerVariables(entity);
		}
		if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM.get()))) {
			if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM_COOLDOWN.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(ArcanumOfWisdomModMobEffects.ARCANA_WISDOM.get(), (int) Double.POSITIVE_INFINITY, 1, false, false));
			}
		}
		if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(ArcanumOfWisdomModMobEffects.LAVA_RACER.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ArcanumOfWisdomModMobEffects.LAVA_RACER.get(), (int) Double.POSITIVE_INFINITY, 1, false, false));
		}
		if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(ArcanumOfWisdomModMobEffects.WATER_RACER.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ArcanumOfWisdomModMobEffects.WATER_RACER.get(), (int) Double.POSITIVE_INFINITY, 1, false, false));
		}
		if (!(entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(ArcanumOfWisdomModMobEffects.SHADOW_WARRIOR.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ArcanumOfWisdomModMobEffects.SHADOW_WARRIOR.get(), (int) Double.POSITIVE_INFINITY, 1, false, false));
		}
	}
}
