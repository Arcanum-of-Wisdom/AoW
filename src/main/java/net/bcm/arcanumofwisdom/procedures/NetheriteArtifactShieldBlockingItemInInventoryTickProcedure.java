package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModItems;

public class NetheriteArtifactShieldBlockingItemInInventoryTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double sheildDamage = 0;
		double localShieldTimer = 0;
		if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).NAS_Shield_Timer == 0 && itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()) {
			sheildDamage = itemstack.getDamageValue();
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_SHIELD.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).setDamageValue((int) sheildDamage);
		} else {
			localShieldTimer = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).NAS_Shield_Timer - 1;
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.NAS_Shield_Timer = localShieldTimer;
				_vars.syncPlayerVariables(entity);
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_SHIELD_BLOCKING.get()) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_SHIELD.get()).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
	}
}
