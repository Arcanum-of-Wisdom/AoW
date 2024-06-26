package net.minecraft.world.item;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;

public class EnchantedBookItem extends Item {
    public static final String TAG_STORED_ENCHANTMENTS = "StoredEnchantments";

    public EnchantedBookItem(Item.Properties p_41149_) {
        super(p_41149_);
    }

    @Override
    public boolean isFoil(ItemStack p_41166_) {
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack p_41168_) {
        return false;
    }

    public static ListTag getEnchantments(ItemStack p_41164_) {
        CompoundTag compoundtag = p_41164_.getTag();
        return compoundtag != null ? compoundtag.getList("StoredEnchantments", 10) : new ListTag();
    }

    @Override
    public void appendHoverText(ItemStack p_41157_, @Nullable Level p_41158_, List<Component> p_41159_, TooltipFlag p_41160_) {
        super.appendHoverText(p_41157_, p_41158_, p_41159_, p_41160_);
        ItemStack.appendEnchantmentNames(p_41159_, getEnchantments(p_41157_));
    }

    public static void addEnchantment(ItemStack p_41154_, EnchantmentInstance p_41155_) {
        ListTag listtag = getEnchantments(p_41154_);
        boolean flag = true;
        ResourceLocation resourcelocation = EnchantmentHelper.getEnchantmentId(p_41155_.enchantment);

        for(int i = 0; i < listtag.size(); ++i) {
            CompoundTag compoundtag = listtag.getCompound(i);
            ResourceLocation resourcelocation1 = EnchantmentHelper.getEnchantmentId(compoundtag);
            if (resourcelocation1 != null && resourcelocation1.equals(resourcelocation)) {
                if (EnchantmentHelper.getEnchantmentLevel(compoundtag) < p_41155_.level) {
                    EnchantmentHelper.setEnchantmentLevel(compoundtag, p_41155_.level);
                }

                flag = false;
                break;
            }
        }

        if (flag) {
            listtag.add(EnchantmentHelper.storeEnchantment(resourcelocation, p_41155_.level));
        }

        p_41154_.getOrCreateTag().put("StoredEnchantments", listtag);
    }

    public static ItemStack createForEnchantment(EnchantmentInstance p_41162_) {
        ItemStack itemstack = new ItemStack(Items.ENCHANTED_BOOK);
        addEnchantment(itemstack, p_41162_);
        return itemstack;
    }
}
