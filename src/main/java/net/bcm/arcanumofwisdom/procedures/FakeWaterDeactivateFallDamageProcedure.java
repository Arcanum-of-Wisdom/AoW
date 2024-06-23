package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FakeWaterDeactivateFallDamageProcedure {
	@SubscribeEvent
	public static void onEntityFall(LivingFallEvent event) {
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
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ArcanumOfWisdomModBlocks.FAKE_WATER.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ArcanumOfWisdomModBlocks.FAKE_LAVA.get()) {
			entity.fallDistance = 0;
		}
	}
}
