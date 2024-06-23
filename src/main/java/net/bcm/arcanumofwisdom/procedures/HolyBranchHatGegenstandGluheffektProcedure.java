package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModItems;

public class HolyBranchHatGegenstandGluheffektProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).wisdom >= 100 && entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).holybranch_ultattack_cooldown == 0 && entity.isShiftKeyDown()
				&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArcanumOfWisdomModItems.HOLY_BRANCH.get()
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArcanumOfWisdomModItems.HOLY_BRANCH.get());
	}
}
