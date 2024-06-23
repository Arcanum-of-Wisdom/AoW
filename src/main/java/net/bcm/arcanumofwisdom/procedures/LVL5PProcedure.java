package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LVL5PProcedure {
	@SubscribeEvent
	public static void onPickupXP(PlayerXpEvent.PickupXp event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean lvl5active = false;
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) == 5 && entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).wisdom < 5) {
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.wisdom = 5;
				_vars.syncPlayerVariables(entity);
			}
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.WHITE_ASH, x, y, z, 20, 0, 1, 0, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CLOUD, x, y, z, 10, 0, 0.5, 0, 0.5);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ArcanumOfWisdomModMobEffects.WISDOM.get(), (int) Double.POSITIVE_INFINITY, 5, false, false));
		}
	}
}
