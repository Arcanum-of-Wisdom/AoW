package net.minecraft.world.item.enchantment;

import net.minecraft.world.entity.EquipmentSlot;

public class TridentChannelingEnchantment extends Enchantment {
    public TridentChannelingEnchantment(Enchantment.Rarity p_45219_, EquipmentSlot... p_45220_) {
        super(p_45219_, EnchantmentCategory.TRIDENT, p_45220_);
    }

    @Override
    public int getMinCost(int p_45223_) {
        return 25;
    }

    @Override
    public int getMaxCost(int p_45227_) {
        return 50;
    }
}
