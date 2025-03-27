package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class ShadowPowerWennEffektStartetangewendetWirdProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
			_vars.shadowpower_cooldown = 800;
			_vars.syncPlayerVariables(entity);
		}
		world.addParticle(ParticleTypes.CLOUD, x, y, z, 0, 1, 0);
		if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.DAMAGE_RESISTANCE) || entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.MOVEMENT_SPEED)
				|| entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.INVISIBILITY) || entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.SLOW_FALLING)) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("The Shadow Power ability won\u00B4t override your active resistance, slow falling, speed or invisibility effect!"), false);
		}
	}
}
