
package net.bcm.arcanumofwisdom.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class FistOfDoomMobEffect extends MobEffect {
	public FistOfDoomMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10066330);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.fist_of_doom_0"), -2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.ATTACK_KNOCKBACK, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.fist_of_doom_1"), 1, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.fist_of_doom_2"), 2, AttributeModifier.Operation.ADD_VALUE);
	}
}
