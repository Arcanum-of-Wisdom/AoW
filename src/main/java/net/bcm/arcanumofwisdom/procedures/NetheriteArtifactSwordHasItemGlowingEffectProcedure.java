package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModItems;

public class NetheriteArtifactSwordHasItemGlowingEffectProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.isShiftKeyDown() && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_SWORD.get()
				&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArcanumOfWisdomModItems.ARTIFACT_OF_MATERIALS.get()
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArcanumOfWisdomModItems.ARTIFACT_OF_FLUIDS.get()
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArcanumOfWisdomModItems.ARTIFACT_OF_MAGIC.get()
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArcanumOfWisdomModItems.ARTIFACT_OF_DIMENSIONS.get()
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ArcanumOfWisdomModItems.ARTIFACT_OF_LIFE.get());
	}
}
