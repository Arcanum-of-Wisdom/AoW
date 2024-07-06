
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.bcm.arcanumofwisdom.procedures.WisdomWennDerEffektAblauftProcedure;
import net.bcm.arcanumofwisdom.procedures.ShadowPowerWennEffektAufhoertProcedure;
import net.bcm.arcanumofwisdom.procedures.HolySpellWennDerEffektAblauftProcedure;
import net.bcm.arcanumofwisdom.procedures.GraceoftheArcanaWennDerEffektAblauftProcedure;
import net.bcm.arcanumofwisdom.procedures.ArcanaWisdomCooldownWennDerEffektAblauftProcedure;
import net.bcm.arcanumofwisdom.potion.WisdomMobEffect;
import net.bcm.arcanumofwisdom.potion.WaterRacerMobEffect;
import net.bcm.arcanumofwisdom.potion.StunnedMobEffect;
import net.bcm.arcanumofwisdom.potion.ShadowWarriorMobEffect;
import net.bcm.arcanumofwisdom.potion.ShadowPowerMobEffect;
import net.bcm.arcanumofwisdom.potion.NightHunterMobEffect;
import net.bcm.arcanumofwisdom.potion.LavaRacerMobEffect;
import net.bcm.arcanumofwisdom.potion.HolySpellMobEffect;
import net.bcm.arcanumofwisdom.potion.GraceoftheArcanaMobEffect;
import net.bcm.arcanumofwisdom.potion.ArcanaWisdomMobEffect;
import net.bcm.arcanumofwisdom.potion.ArcanaWisdomCooldownMobEffect;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

@Mod.EventBusSubscriber
public class ArcanumOfWisdomModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, ArcanumOfWisdomMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> WATER_RACER = REGISTRY.register("water_racer", () -> new WaterRacerMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LAVA_RACER = REGISTRY.register("lava_racer", () -> new LavaRacerMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> WISDOM = REGISTRY.register("wisdom", () -> new WisdomMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> STUNNED = REGISTRY.register("stunned", () -> new StunnedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> HOLY_SPELL = REGISTRY.register("holy_spell", () -> new HolySpellMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SHADOW_POWER = REGISTRY.register("shadow_power", () -> new ShadowPowerMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SHADOW_WARRIOR = REGISTRY.register("shadow_warrior", () -> new ShadowWarriorMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> GRACE_OF_THE_ARCANA = REGISTRY.register("grace_of_the_arcana", () -> new GraceoftheArcanaMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ARCANA_WISDOM = REGISTRY.register("arcana_wisdom", () -> new ArcanaWisdomMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ARCANA_WISDOM_COOLDOWN = REGISTRY.register("arcana_wisdom_cooldown", () -> new ArcanaWisdomCooldownMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> NIGHT_HUNTER = REGISTRY.register("night_hunter", () -> new NightHunterMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		MobEffect effect = effectInstance.getEffect();
		if (effect == WISDOM.get()) {
			WisdomWennDerEffektAblauftProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		} else if (effect == HOLY_SPELL.get()) {
			HolySpellWennDerEffektAblauftProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effect == SHADOW_POWER.get()) {
			ShadowPowerWennEffektAufhoertProcedure.execute(entity.level(), entity);
		} else if (effect == GRACE_OF_THE_ARCANA.get()) {
			GraceoftheArcanaWennDerEffektAblauftProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effect == ARCANA_WISDOM_COOLDOWN.get()) {
			ArcanaWisdomCooldownWennDerEffektAblauftProcedure.execute(entity);
		}
	}
}
