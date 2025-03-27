
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
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
import net.bcm.arcanumofwisdom.potion.TotemMobEffect;
import net.bcm.arcanumofwisdom.potion.StunnedMobEffect;
import net.bcm.arcanumofwisdom.potion.ShadowWarriorMobEffect;
import net.bcm.arcanumofwisdom.potion.ShadowPowerMobEffect;
import net.bcm.arcanumofwisdom.potion.RegenerativeSaturationPoolMobEffect;
import net.bcm.arcanumofwisdom.potion.RegenerativeHealthPoolMobEffect;
import net.bcm.arcanumofwisdom.potion.RaidersElixirMobEffect;
import net.bcm.arcanumofwisdom.potion.NightHunterMobEffect;
import net.bcm.arcanumofwisdom.potion.MiningBoosterMobEffect;
import net.bcm.arcanumofwisdom.potion.LavaRacerMobEffect;
import net.bcm.arcanumofwisdom.potion.InstantSaturationMobEffect;
import net.bcm.arcanumofwisdom.potion.InstantComebackMobEffect;
import net.bcm.arcanumofwisdom.potion.HolySpellMobEffect;
import net.bcm.arcanumofwisdom.potion.GraceoftheArcanaMobEffect;
import net.bcm.arcanumofwisdom.potion.FistboosterMobEffect;
import net.bcm.arcanumofwisdom.potion.FistOfDoomMobEffect;
import net.bcm.arcanumofwisdom.potion.ElytraEnhancerMobEffect;
import net.bcm.arcanumofwisdom.potion.ArmorBoosterMobEffect;
import net.bcm.arcanumofwisdom.potion.ArcanaWisdomMobEffect;
import net.bcm.arcanumofwisdom.potion.ArcanaWisdomCooldownMobEffect;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

@EventBusSubscriber
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
	public static final DeferredHolder<MobEffect, MobEffect> ELYTRA_ENHANCER = REGISTRY.register("elytra_enhancer", () -> new ElytraEnhancerMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> REGENERATIVE_HEALTH_POOL = REGISTRY.register("regenerative_health_pool", () -> new RegenerativeHealthPoolMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TOTEM = REGISTRY.register("totem", () -> new TotemMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> INSTANT_SATURATION = REGISTRY.register("instant_saturation", () -> new InstantSaturationMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> REGENERATIVE_SATURATION_POOL = REGISTRY.register("regenerative_saturation_pool", () -> new RegenerativeSaturationPoolMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> INSTANT_COMEBACK = REGISTRY.register("instant_comeback", () -> new InstantComebackMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ARMOR_BOOSTER = REGISTRY.register("armor_booster", () -> new ArmorBoosterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MINING_BOOSTER = REGISTRY.register("mining_booster", () -> new MiningBoosterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FISTBOOSTER = REGISTRY.register("fistbooster", () -> new FistboosterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FIST_OF_DOOM = REGISTRY.register("fist_of_doom", () -> new FistOfDoomMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> RAIDERS_ELIXIR = REGISTRY.register("raiders_elixir", () -> new RaidersElixirMobEffect());

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
		if (effectInstance.getEffect().is(WISDOM)) {
			WisdomWennDerEffektAblauftProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		} else if (effectInstance.getEffect().is(HOLY_SPELL)) {
			HolySpellWennDerEffektAblauftProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		} else if (effectInstance.getEffect().is(SHADOW_POWER)) {
			ShadowPowerWennEffektAufhoertProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(GRACE_OF_THE_ARCANA)) {
			GraceoftheArcanaWennDerEffektAblauftProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(ARCANA_WISDOM_COOLDOWN)) {
			ArcanaWisdomCooldownWennDerEffektAblauftProcedure.execute(entity);
		}
	}
}
