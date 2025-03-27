package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class ConnectModsReturnNegativeProcedure {
	public static boolean execute(LevelAccessor world) {
		return !ArcanumOfWisdomModVariables.WorldVariables.get(world).connect_mods;
	}
}
