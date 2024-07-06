package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.DEDICATED_SERVER})
public class StartupInfoMessageServersidePProcedure {
	@SubscribeEvent
	public static void init(FMLDedicatedServerSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		ArcanumOfWisdomMod.LOGGER.warn(
				"Arcanum of Wisdom: Serverside startup information / AoW uses Minecraft's attribute function for LVL effects. Even though changing these attributes using /attribute does not destroy the mod, some functions can only be activated after repeated attempts. It is recommended not to use /attribute. Unlike clientside, this message is not displayed ingame!");
	}
}
