
package net.bcm.arcanumofwisdom.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class MiningBoosterMobEffect extends MobEffect {
	public MiningBoosterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10277587);
		this.addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.mining_booster_0"), 5, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.LUCK, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.mining_booster_1"), 2, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.MINING_EFFICIENCY, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.mining_booster_2"), 0.8, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.SUBMERGED_MINING_SPEED, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.mining_booster_3"), 0.8, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.mining_booster_4"), 1.5, AttributeModifier.Operation.ADD_VALUE);
	}
}
