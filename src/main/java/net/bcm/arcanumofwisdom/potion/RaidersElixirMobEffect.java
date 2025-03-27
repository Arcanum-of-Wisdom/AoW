
package net.bcm.arcanumofwisdom.potion;

import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.bcm.arcanumofwisdom.procedures.RaidersElixirEffectStartedappliedProcedure;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class RaidersElixirMobEffect extends MobEffect {
	public RaidersElixirMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13762429);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.raiders_elixir_0"), 1.5, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.raiders_elixir_1"), 1.5, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.JUMP_STRENGTH, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.raiders_elixir_2"), 0.15, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.raiders_elixir_3"), 0.1, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(NeoForgeMod.NAMETAG_DISTANCE, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.raiders_elixir_4"), -0.25, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.SNEAKING_SPEED, ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "effect.raiders_elixir_5"), 0.25, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		RaidersElixirEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		RaidersElixirEffectStartedappliedProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
