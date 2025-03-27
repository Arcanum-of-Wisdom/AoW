package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.entity.player.AdvancementEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.Advancement;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TheEndAdvancementLoottableProcedure {
	@SubscribeEvent
	public static void onAdvancement(AdvancementEvent.AdvancementEarnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getAdvancement().value());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Advancement advancement) {
		execute(null, world, x, y, z, advancement);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Advancement advancement) {
		if (advancement == null)
			return;
		if (world instanceof Level _lvl0 && _lvl0.getServer() != null && _lvl0.getServer().getAdvancements().get(ResourceLocation.parse("minecraft:end/kill_dragon")).value().equals(advancement)) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_DIMENSIONS.get()));
				entityToSpawn.setPickUpDelay(2);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
