package net.minecraft.world.item.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class BindingCurseEnchantment extends Enchantment {
    public BindingCurseEnchantment(Enchantment.Rarity p_44612_, EquipmentSlot... p_44613_) {
        super(p_44612_, EnchantmentCategory.WEARABLE, p_44613_);
    }

    @Override
    public int getMinCost(int p_44616_) {
        return 25;
    }

    @Override
    public int getMaxCost(int p_44619_) {
        return 50;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public boolean canEnchant(ItemStack p_270577_) {
        return !p_270577_.is(Items.SHIELD) && super.canEnchant(p_270577_);
    }
}
