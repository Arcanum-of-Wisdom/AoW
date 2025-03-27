
package net.bcm.arcanumofwisdom.potion;

import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

import java.util.Set;

public class ElytraEnhancerMobEffect extends MobEffect {
	public ElytraEnhancerMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -12149249);
		this.addAttributeModifier(Attributes.FLYING_SPEED, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.elytra_enhancer_0"), 0.5, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.GRAVITY, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.elytra_enhancer_1"), -0.02, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.FALL_DAMAGE_MULTIPLIER, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.elytra_enhancer_2"), -0.04, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
		cures.add(EffectCures.MILK);
		cures.add(EffectCures.PROTECTED_BY_TOTEM);
		cures.add(EffectCures.HONEY);
	}
}
