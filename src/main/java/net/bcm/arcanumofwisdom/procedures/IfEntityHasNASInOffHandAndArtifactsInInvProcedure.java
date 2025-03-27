package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.particles.ParticleTypes;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class IfEntityHasNASInOffHandAndArtifactsInInvProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_SHIELD.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_SHIELD_BLOCKING.get())
				&& ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_LIFE.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_MATERIALS.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_FLUIDS.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_MAGIC.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_DIMENSIONS.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get())) : false))) {
			if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MobEffects.DAMAGE_RESISTANCE))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2, 2, true, false));
			}
			if (!(entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(MobEffects.SLOW_FALLING))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 2, 1, true, false));
				world.addParticle(ParticleTypes.CLOUD, x, y, z, 0, 0, 0);
			}
		}
	}
}
