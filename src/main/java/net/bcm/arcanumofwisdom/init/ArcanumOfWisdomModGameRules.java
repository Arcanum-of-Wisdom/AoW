
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArcanumOfWisdomModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> AOW_AUTOMATIC_COUNTDOWN_RESETS;
	public static GameRules.Key<GameRules.BooleanValue> AOW_NO_COOLDOWNS;
	public static GameRules.Key<GameRules.BooleanValue> AOW_ARCANA_DIMENSION;
	public static GameRules.Key<GameRules.BooleanValue> AOW_LEVEL_EFFECTS;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		AOW_AUTOMATIC_COUNTDOWN_RESETS = GameRules.register("aOWAutomaticCountdownResets", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
		AOW_NO_COOLDOWNS = GameRules.register("noCooldowns", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
		AOW_ARCANA_DIMENSION = GameRules.register("arcanaDimension", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
		AOW_LEVEL_EFFECTS = GameRules.register("aOWLevelEffects", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	}
}
