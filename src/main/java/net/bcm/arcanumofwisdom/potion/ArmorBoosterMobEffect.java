
package net.bcm.arcanumofwisdom.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class ArmorBoosterMobEffect extends MobEffect {
	public ArmorBoosterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -9276814);
		this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.armor_booster_0"), 3, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.armor_booster_1"), 0, AttributeModifier.Operation.ADD_VALUE);
	}
}
