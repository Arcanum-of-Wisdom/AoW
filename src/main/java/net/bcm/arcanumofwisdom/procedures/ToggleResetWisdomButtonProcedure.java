package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class ToggleResetWisdomButtonProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof Player _plr ? _plr.getAbilities().instabuild : false;
	}
}
