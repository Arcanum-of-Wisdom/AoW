
package net.bcm.arcanumofwisdom.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class FistboosterMobEffect extends MobEffect {
	public FistboosterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -11119018);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.fistbooster_0"), 1, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_KNOCKBACK, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.fistbooster_1"), 0.5, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.fistbooster_2"), 2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}
