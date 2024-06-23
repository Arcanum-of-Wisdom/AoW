package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModGameRules;

public class LVLEffectsOffDisplayConditionProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).lvleffects == true && world.getLevelData().getGameRules().getBoolean(ArcanumOfWisdomModGameRules.AOW_LEVEL_EFFECTS) == true;
	}
}
