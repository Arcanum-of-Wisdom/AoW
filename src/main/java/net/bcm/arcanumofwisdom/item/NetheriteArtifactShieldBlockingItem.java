
package net.bcm.arcanumofwisdom.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.bcm.arcanumofwisdom.procedures.NetheriteArtifactShieldBlockingItemInInventoryTickProcedure;

import java.util.List;

public class NetheriteArtifactShieldBlockingItem extends Item {
	public NetheriteArtifactShieldBlockingItem() {
		super(new Item.Properties().durability(200).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public int getEnchantmentValue() {
		return 15;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.arcanum_of_wisdom.netherite_artifact_shield_blocking.description_0"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		NetheriteArtifactShieldBlockingItemInInventoryTickProcedure.execute(entity, itemstack);
	}
}
