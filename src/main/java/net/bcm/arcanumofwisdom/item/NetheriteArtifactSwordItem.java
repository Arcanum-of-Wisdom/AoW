
package net.bcm.arcanumofwisdom.item;
import net.minecraft.world.item.Rarity;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.bcm.arcanumofwisdom.procedures.NetheriteArtifactSwordHasItemGlowingEffectProcedure;
import net.bcm.arcanumofwisdom.procedures.NetheriteArtifactSwordEntitySwingsItemProcedure;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModItems;

import java.util.List;

public class NetheriteArtifactSwordItem extends SwordItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 2100;
		}

		@Override
		public float getSpeed() {
			return 4f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_STONE_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 22;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()), new ItemStack(Items.NETHERITE_INGOT));
		}
	};

	public NetheriteArtifactSwordItem() {
		super(TOOL_TIER, new Item.Properties().attributes(SwordItem.createAttributes(TOOL_TIER, 7.5f, -2f)).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("A Netherite sword forged together with artifacts that now has the power to detect artifacts in the offhand and can make use of their their hidden power."));
		list.add(Component.literal("To use these abilities, you must be at Wisdom LVL 20, holding an artifact in your offhand and swinging the sword in your mainhand."));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
		boolean retval = super.onEntitySwing(itemstack, entity, hand);
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
