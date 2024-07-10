
package net.bcm.arcanumofwisdom.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.bcm.arcanumofwisdom.procedures.NetheriteArtifactSwordHasItemGlowingEffectProcedure;
import net.bcm.arcanumofwisdom.procedures.NetheriteArtifactSwordEntitySwingsItemProcedure;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModItems;
import net.minecraft.world.item.Rarity;

import java.util.List;

public class NetheriteArtifactSwordItem extends SwordItem {
	public NetheriteArtifactSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 2100;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 4.5f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 22;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()), new ItemStack(Items.NETHERITE_INGOT));
			}
		}, 3, -2f, new Item.Properties().fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("A Netherite sword forged together with artifacts that now has the power to detect artifacts in the offhand and can make use of their their hidden power."));
		list.add(Component.literal("To use these abilities, you must be at Wisdom LVL 20, holding an artifact in your offhand and swinging the sword in your mainhand."));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		NetheriteArtifactSwordEntitySwingsItemProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		Entity entity = Minecraft.getInstance().player;
		return NetheriteArtifactSwordHasItemGlowingEffectProcedure.execute(entity);
	}
}
