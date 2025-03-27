
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ArcanumOfWisdomModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> AOWLVLEFFECTS;
	public static GameRules.Key<GameRules.BooleanValue> AOWARCANADIMENSION;
	public static GameRules.Key<GameRules.BooleanValue> AOWNOCOOLDOWNS;
	public static GameRules.Key<GameRules.BooleanValue> AOWAUTOMATICCOOLDOWNRESETS;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		AOWLVLEFFECTS = GameRules.register("aowlvleffects", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
		AOWARCANADIMENSION = GameRules.register("aowarcanadimension", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
		AOWNOCOOLDOWNS = GameRules.register("aownocooldowns", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
		AOWAUTOMATICCOOLDOWNRESETS = GameRules.register("aowautomaticcooldownresets", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	}
}
