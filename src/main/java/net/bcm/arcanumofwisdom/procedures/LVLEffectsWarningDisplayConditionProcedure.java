package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModGameRules;

public class LVLEffectsWarningDisplayConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		return world.getLevelData().getGameRules().getBoolean(ArcanumOfWisdomModGameRules.AOW_LEVEL_EFFECTS) == false;
	}
}
