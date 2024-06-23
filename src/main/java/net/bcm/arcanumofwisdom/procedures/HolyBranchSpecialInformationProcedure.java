package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class HolyBranchSpecialInformationProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "This branch has been canonized in the name of wisdom and magic and is therefore very powerful. It grants you magical powers depending on your whiteness as long as you keep it in your inventory."
				+ ("Your exact wisdom level:" + entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).wisdom);
	}
}
