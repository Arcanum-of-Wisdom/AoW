package net.minecraft.data.advancements.packs;

import com.mojang.datafixers.util.Pair;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ChanneledLightningTrigger;
import net.minecraft.advancements.critereon.DamagePredicate;
import net.minecraft.advancements.critereon.DamageSourcePredicate;
import net.minecraft.advancements.critereon.DistancePredicate;
import net.minecraft.advancements.critereon.DistanceTrigger;
import net.minecraft.advancements.critereon.EntityEquipmentPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;
import net.minecraft.advancements.critereon.KilledByCrossbowTrigger;
import net.minecraft.advancements.critereon.KilledTrigger;
import net.minecraft.advancements.critereon.LightningBoltPredicate;
import net.minecraft.advancements.critereon.LightningStrikeTrigger;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.LootTableTrigger;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.PlayerHurtEntityTrigger;
import net.minecraft.advancements.critereon.PlayerPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.advancements.critereon.RecipeCraftedTrigger;
import net.minecraft.advancements.critereon.ShotCrossbowTrigger;
import net.minecraft.advancements.critereon.SlideDownBlockTrigger;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.advancements.critereon.SummonedEntityTrigger;
import net.minecraft.advancements.critereon.TagPredicate;
import net.minecraft.advancements.critereon.TargetBlockTrigger;
import net.minecraft.advancements.critereon.TradeTrigger;
import net.minecraft.advancements.critereon.UsedTotemTrigger;
import net.minecraft.advancements.critereon.UsingItemTrigger;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComparatorBlock;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.AllOfCondition;
import net.minecraft.world.level.storage.loot.predicates.AnyOfCondition;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class VanillaAdventureAdvancements implements AdvancementSubProvider {
    private static final int DISTANCE_FROM_BOTTOM_TO_TOP = 384;
    private static final int Y_COORDINATE_AT_TOP = 320;
    private static final int Y_COORDINATE_AT_BOTTOM = -64;
    private static final int BEDROCK_THICKNESS = 5;
    protected static final List<EntityType<?>> MOBS_TO_KILL = Arrays.asList(
        EntityType.BLAZE,
        EntityType.CAVE_SPIDER,
        EntityType.CREEPER,
        EntityType.DROWNED,
        EntityType.ELDER_GUARDIAN,
        EntityType.ENDER_DRAGON,
        EntityType.ENDERMAN,
        EntityType.ENDERMITE,
        EntityType.EVOKER,
        EntityType.GHAST,
        EntityType.GUARDIAN,
        EntityType.HOGLIN,
        EntityType.HUSK,
        EntityType.MAGMA_CUBE,
        EntityType.PHANTOM,
        EntityType.PIGLIN,
        EntityType.PIGLIN_BRUTE,
        EntityType.PILLAGER,
        EntityType.RAVAGER,
        EntityType.SHULKER,
        EntityType.SILVERFISH,
        EntityType.SKELETON,
        EntityType.SLIME,
        EntityType.SPIDER,
        EntityType.STRAY,
        EntityType.VEX,
        EntityType.VINDICATOR,
        EntityType.WITCH,
        EntityType.WITHER_SKELETON,
        EntityType.WITHER,
        EntityType.ZOGLIN,
        EntityType.ZOMBIE_VILLAGER,
        EntityType.ZOMBIE,
        EntityType.ZOMBIFIED_PIGLIN
    );

    private static Criterion<LightningStrikeTrigger.TriggerInstance> fireCountAndBystander(MinMaxBounds.Ints p_252298_, Optional<EntityPredicate> p_299106_) {
        return LightningStrikeTrigger.TriggerInstance.lightningStrike(
            Optional.of(
                EntityPredicate.Builder.entity()
                    .distance(DistancePredicate.absolute(MinMaxBounds.Doubles.atMost(30.0)))
                    .subPredicate(LightningBoltPredicate.blockSetOnFire(p_252298_))
                    .build()
            ),
            p_299106_
        );
    }

    private static Criterion<UsingItemTrigger.TriggerInstance> lookAtThroughItem(EntityType<?> p_249703_, Item p_250746_) {
        return UsingItemTrigger.TriggerInstance.lookingAt(
            EntityPredicate.Builder.entity()
                .subPredicate(PlayerPredicate.Builder.player().setLookingAt(EntityPredicate.Builder.entity().of(p_249703_)).build()),
            ItemPredicate.Builder.item().of(p_250746_)
        );
    }

    @Override
    public void generate(HolderLookup.Provider p_255887_, Consumer<AdvancementHolder> p_256428_) {
        AdvancementHolder advancementholder = Advancement.Builder.advancement()
            .display(
                Items.MAP,
                Component.translatable("advancements.adventure.root.title"),
                Component.translatable("advancements.adventure.root.description"),
                new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"),
                AdvancementType.TASK,
                false,
                false,
                false
            )
            .requirements(AdvancementRequirements.Strategy.OR)
            .addCriterion("killed_something", KilledTrigger.TriggerInstance.playerKilledEntity())
            .addCriterion("killed_by_something", KilledTrigger.TriggerInstance.entityKilledPlayer())
            .save(p_256428_, "adventure/root");
        AdvancementHolder advancementholder1 = Advancement.Builder.advancement()
            .parent(advancementholder)
            .display(
                Blocks.RED_BED,
                Component.translatable("advancements.adventure.sleep_in_bed.title"),
                Component.translatable("advancements.adventure.sleep_in_bed.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion("slept_in_bed", PlayerTrigger.TriggerInstance.sleptInBed())
            .save(p_256428_, "adventure/sleep_in_bed");
        createAdventuringTime(p_256428_, advancementholder1, MultiNoiseBiomeSourceParameterList.Preset.OVERWORLD);
        AdvancementHolder advancementholder2 = Advancement.Builder.advancement()
            .parent(advancementholder)
            .display(
                Items.EMERALD,
                Component.translatable("advancements.adventure.trade.title"),
                Component.translatable("advancements.adventure.trade.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion("traded", TradeTrigger.TriggerInstance.tradedWithVillager())
            .save(p_256428_, "adventure/trade");
        Advancement.Builder.advancement()
            .parent(advancementholder2)
            .display(
                Items.EMERALD,
                Component.translatable("advancements.adventure.trade_at_world_height.title"),
                Component.translatable("advancements.adventure.trade_at_world_height.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion(
                "trade_at_world_height",
                TradeTrigger.TriggerInstance.tradedWithVillager(
                    EntityPredicate.Builder.entity().located(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atLeast(319.0)))
                )
            )
            .save(p_256428_, "adventure/trade_at_world_height");
        AdvancementHolder advancementholder3 = createMonsterHunterAdvancement(advancementholder, p_256428_, MOBS_TO_KILL);
        AdvancementHolder advancementholder4 = Advancement.Builder.advancement()
            .parent(advancementholder3)
            .display(
                Items.BOW,
                Component.translatable("advancements.adventure.shoot_arrow.title"),
                Component.translatable("advancements.adventure.shoot_arrow.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion(
                "shot_arrow",
                PlayerHurtEntityTrigger.TriggerInstance.playerHurtEntityWithDamage(
                    DamagePredicate.Builder.damageInstance()
                        .type(
                            DamageSourcePredicate.Builder.damageType()
                                .tag(TagPredicate.is(DamageTypeTags.IS_PROJECTILE))
                                .direct(EntityPredicate.Builder.entity().of(EntityTypeTags.ARROWS))
                        )
                )
            )
            .save(p_256428_, "adventure/shoot_arrow");
        AdvancementHolder advancementholder5 = Advancement.Builder.advancement()
            .parent(advancementholder3)
            .display(
                Items.TRIDENT,
                Component.translatable("advancements.adventure.throw_trident.title"),
                Component.translatable("advancements.adventure.throw_trident.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion(
                "shot_trident",
                PlayerHurtEntityTrigger.TriggerInstance.playerHurtEntityWithDamage(
                    DamagePredicate.Builder.damageInstance()
                        .type(
                            DamageSourcePredicate.Builder.damageType()
                                .tag(TagPredicate.is(DamageTypeTags.IS_PROJECTILE))
                                .direct(EntityPredicate.Builder.entity().of(EntityType.TRIDENT))
                        )
                )
            )
            .save(p_256428_, "adventure/throw_trident");
        Advancement.Builder.advancement()
            .parent(advancementholder5)
            .display(
                Items.TRIDENT,
                Component.translatable("advancements.adventure.very_very_frightening.title"),
                Component.translatable("advancements.adventure.very_very_frightening.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion(
                "struck_villager", ChanneledLightningTrigger.TriggerInstance.channeledLightning(EntityPredicate.Builder.entity().of(EntityType.VILLAGER))
            )
            .save(p_256428_, "adventure/very_very_frightening");
        Advancement.Builder.advancement()
            .parent(advancementholder2)
            .display(
                Blocks.CARVED_PUMPKIN,
                Component.translatable("advancements.adventure.summon_iron_golem.title"),
                Component.translatable("advancements.adventure.summon_iron_golem.description"),
                null,
                AdvancementType.GOAL,
                true,
                true,
                false
            )
            .addCriterion("summoned_golem", SummonedEntityTrigger.TriggerInstance.summonedEntity(EntityPredicate.Builder.entity().of(EntityType.IRON_GOLEM)))
            .save(p_256428_, "adventure/summon_iron_golem");
        Advancement.Builder.advancement()
            .parent(advancementholder4)
            .display(
                Items.ARROW,
                Component.translatable("advancements.adventure.sniper_duel.title"),
                Component.translatable("advancements.adventure.sniper_duel.description"),
                null,
                AdvancementType.CHALLENGE,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(50))
            .addCriterion(
                "killed_skeleton",
                KilledTrigger.TriggerInstance.playerKilledEntity(
                    EntityPredicate.Builder.entity().of(EntityType.SKELETON).distance(DistancePredicate.horizontal(MinMaxBounds.Doubles.atLeast(50.0))),
                    DamageSourcePredicate.Builder.damageType().tag(TagPredicate.is(DamageTypeTags.IS_PROJECTILE))
                )
            )
            .save(p_256428_, "adventure/sniper_duel");
        Advancement.Builder.advancement()
            .parent(advancementholder3)
            .display(
                Items.TOTEM_OF_UNDYING,
                Component.translatable("advancements.adventure.totem_of_undying.title"),
                Component.translatable("advancements.adventure.totem_of_undying.description"),
                null,
                AdvancementType.GOAL,
                true,
                true,
                false
            )
            .addCriterion("used_totem", UsedTotemTrigger.TriggerInstance.usedTotem(Items.TOTEM_OF_UNDYING))
            .save(p_256428_, "adventure/totem_of_undying");
        AdvancementHolder advancementholder6 = Advancement.Builder.advancement()
            .parent(advancementholder)
            .display(
                Items.CROSSBOW,
                Component.translatable("advancements.adventure.ol_betsy.title"),
                Component.translatable("advancements.adventure.ol_betsy.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion("shot_crossbow", ShotCrossbowTrigger.TriggerInstance.shotCrossbow(Items.CROSSBOW))
            .save(p_256428_, "adventure/ol_betsy");
        Advancement.Builder.advancement()
            .parent(advancementholder6)
            .display(
                Items.CROSSBOW,
                Component.translatable("advancements.adventure.whos_the_pillager_now.title"),
                Component.translatable("advancements.adventure.whos_the_pillager_now.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion("kill_pillager", KilledByCrossbowTrigger.TriggerInstance.crossbowKilled(EntityPredicate.Builder.entity().of(EntityType.PILLAGER)))
            .save(p_256428_, "adventure/whos_the_pillager_now");
        Advancement.Builder.advancement()
            .parent(advancementholder6)
            .display(
                Items.CROSSBOW,
                Component.translatable("advancements.adventure.two_birds_one_arrow.title"),
                Component.translatable("advancements.adventure.two_birds_one_arrow.description"),
                null,
                AdvancementType.CHALLENGE,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(65))
            .addCriterion(
                "two_birds",
                KilledByCrossbowTrigger.TriggerInstance.crossbowKilled(
                    EntityPredicate.Builder.entity().of(EntityType.PHANTOM), EntityPredicate.Builder.entity().of(EntityType.PHANTOM)
                )
            )
            .save(p_256428_, "adventure/two_birds_one_arrow");
        Advancement.Builder.advancement()
            .parent(advancementholder6)
            .display(
                Items.CROSSBOW,
                Component.translatable("advancements.adventure.arbalistic.title"),
                Component.translatable("advancements.adventure.arbalistic.description"),
                null,
                AdvancementType.CHALLENGE,
                true,
                true,
                true
            )
            .rewards(AdvancementRewards.Builder.experience(85))
            .addCriterion("arbalistic", KilledByCrossbowTrigger.TriggerInstance.crossbowKilled(MinMaxBounds.Ints.exactly(5)))
            .save(p_256428_, "adventure/arbalistic");
        AdvancementHolder advancementholder7 = Advancement.Builder.advancement()
            .parent(advancementholder)
            .display(
                Raid.getLeaderBannerInstance(),
                Component.translatable("advancements.adventure.voluntary_exile.title"),
                Component.translatable("advancements.adventure.voluntary_exile.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                true
            )
            .addCriterion(
                "voluntary_exile",
                KilledTrigger.TriggerInstance.playerKilledEntity(
                    EntityPredicate.Builder.entity().of(EntityTypeTags.RAIDERS).equipment(EntityEquipmentPredicate.CAPTAIN)
                )
            )
            .save(p_256428_, "adventure/voluntary_exile");
        Advancement.Builder.advancement()
            .parent(advancementholder7)
            .display(
                Raid.getLeaderBannerInstance(),
                Component.translatable("advancements.adventure.hero_of_the_village.title"),
                Component.translatable("advancements.adventure.hero_of_the_village.description"),
                null,
                AdvancementType.CHALLENGE,
                true,
                true,
                true
            )
            .rewards(AdvancementRewards.Builder.experience(100))
            .addCriterion("hero_of_the_village", PlayerTrigger.TriggerInstance.raidWon())
            .save(p_256428_, "adventure/hero_of_the_village");
        Advancement.Builder.advancement()
            .parent(advancementholder)
            .display(
                Blocks.HONEY_BLOCK.asItem(),
                Component.translatable("advancements.adventure.honey_block_slide.title"),
                Component.translatable("advancements.adventure.honey_block_slide.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion("honey_block_slide", SlideDownBlockTrigger.TriggerInstance.slidesDownBlock(Blocks.HONEY_BLOCK))
            .save(p_256428_, "adventure/honey_block_slide");
        Advancement.Builder.advancement()
            .parent(advancementholder4)
            .display(
                Blocks.TARGET.asItem(),
                Component.translatable("advancements.adventure.bullseye.title"),
                Component.translatable("advancements.adventure.bullseye.description"),
                null,
                AdvancementType.CHALLENGE,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(50))
            .addCriterion(
                "bullseye",
                TargetBlockTrigger.TriggerInstance.targetHit(
                    MinMaxBounds.Ints.exactly(15),
                    Optional.of(
                        EntityPredicate.wrap(EntityPredicate.Builder.entity().distance(DistancePredicate.horizontal(MinMaxBounds.Doubles.atLeast(30.0))))
                    )
                )
            )
            .save(p_256428_, "adventure/bullseye");
        Advancement.Builder.advancement()
            .parent(advancementholder1)
            .display(
                Items.LEATHER_BOOTS,
                Component.translatable("advancements.adventure.walk_on_powder_snow_with_leather_boots.title"),
                Component.translatable("advancements.adventure.walk_on_powder_snow_with_leather_boots.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion(
                "walk_on_powder_snow_with_leather_boots", PlayerTrigger.TriggerInstance.walkOnBlockWithEquipment(Blocks.POWDER_SNOW, Items.LEATHER_BOOTS)
            )
            .save(p_256428_, "adventure/walk_on_powder_snow_with_leather_boots");
        Advancement.Builder.advancement()
            .parent(advancementholder)
            .display(
                Items.LIGHTNING_ROD,
                Component.translatable("advancements.adventure.lightning_rod_with_villager_no_fire.title"),
                Component.translatable("advancements.adventure.lightning_rod_with_villager_no_fire.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion(
                "lightning_rod_with_villager_no_fire",
                fireCountAndBystander(MinMaxBounds.Ints.exactly(0), Optional.of(EntityPredicate.Builder.entity().of(EntityType.VILLAGER).build()))
            )
            .save(p_256428_, "adventure/lightning_rod_with_villager_no_fire");
        AdvancementHolder advancementholder8 = Advancement.Builder.advancement()
            .parent(advancementholder)
            .display(
                Items.SPYGLASS,
                Component.translatable("advancements.adventure.spyglass_at_parrot.title"),
                Component.translatable("advancements.adventure.spyglass_at_parrot.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion("spyglass_at_parrot", lookAtThroughItem(EntityType.PARROT, Items.SPYGLASS))
            .save(p_256428_, "adventure/spyglass_at_parrot");
        AdvancementHolder advancementholder9 = Advancement.Builder.advancement()
            .parent(advancementholder8)
            .display(
                Items.SPYGLASS,
                Component.translatable("advancements.adventure.spyglass_at_ghast.title"),
                Component.translatable("advancements.adventure.spyglass_at_ghast.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion("spyglass_at_ghast", lookAtThroughItem(EntityType.GHAST, Items.SPYGLASS))
            .save(p_256428_, "adventure/spyglass_at_ghast");
        Advancement.Builder.advancement()
            .parent(advancementholder1)
            .display(
                Items.JUKEBOX,
                Component.translatable("advancements.adventure.play_jukebox_in_meadows.title"),
                Component.translatable("advancements.adventure.play_jukebox_in_meadows.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion(
                "play_jukebox_in_meadows",
                ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                    LocationPredicate.Builder.location().setBiome(Biomes.MEADOW).setBlock(BlockPredicate.Builder.block().of(Blocks.JUKEBOX)),
                    ItemPredicate.Builder.item().of(ItemTags.MUSIC_DISCS)
                )
            )
            .save(p_256428_, "adventure/play_jukebox_in_meadows");
        Advancement.Builder.advancement()
            .parent(advancementholder9)
            .display(
                Items.SPYGLASS,
                Component.translatable("advancements.adventure.spyglass_at_dragon.title"),
                Component.translatable("advancements.adventure.spyglass_at_dragon.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion("spyglass_at_dragon", lookAtThroughItem(EntityType.ENDER_DRAGON, Items.SPYGLASS))
            .save(p_256428_, "adventure/spyglass_at_dragon");
        Advancement.Builder.advancement()
            .parent(advancementholder)
            .display(
                Items.WATER_BUCKET,
                Component.translatable("advancements.adventure.fall_from_world_height.title"),
                Component.translatable("advancements.adventure.fall_from_world_height.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion(
                "fall_from_world_height",
                DistanceTrigger.TriggerInstance.fallFromHeight(
                    EntityPredicate.Builder.entity().located(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atMost(-59.0))),
                    DistancePredicate.vertical(MinMaxBounds.Doubles.atLeast(379.0)),
                    LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atLeast(319.0))
                )
            )
            .save(p_256428_, "adventure/fall_from_world_height");
        Advancement.Builder.advancement()
            .parent(advancementholder3)
            .display(
                Blocks.SCULK_CATALYST,
                Component.translatable("advancements.adventure.kill_mob_near_sculk_catalyst.title"),
                Component.translatable("advancements.adventure.kill_mob_near_sculk_catalyst.description"),
                null,
                AdvancementType.CHALLENGE,
                true,
                true,
                false
            )
            .addCriterion("kill_mob_near_sculk_catalyst", KilledTrigger.TriggerInstance.playerKilledEntityNearSculkCatalyst())
            .save(p_256428_, "adventure/kill_mob_near_sculk_catalyst");
        Advancement.Builder.advancement()
            .parent(advancementholder)
            .display(
                Blocks.SCULK_SENSOR,
                Component.translatable("advancements.adventure.avoid_vibration.title"),
                Component.translatable("advancements.adventure.avoid_vibration.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion("avoid_vibration", PlayerTrigger.TriggerInstance.avoidVibration())
            .save(p_256428_, "adventure/avoid_vibration");
        AdvancementHolder advancementholder10 = respectingTheRemnantsCriterions(Advancement.Builder.advancement())
            .parent(advancementholder)
            .display(
                Items.BRUSH,
                Component.translatable("advancements.adventure.salvage_sherd.title"),
                Component.translatable("advancements.adventure.salvage_sherd.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .save(p_256428_, "adventure/salvage_sherd");
        Advancement.Builder.advancement()
            .parent(advancementholder10)
            .display(
                DecoratedPotBlockEntity.createDecoratedPotItem(
                    new DecoratedPotBlockEntity.Decorations(Items.BRICK, Items.HEART_POTTERY_SHERD, Items.BRICK, Items.EXPLORER_POTTERY_SHERD)
                ),
                Component.translatable("advancements.adventure.craft_decorated_pot_using_only_sherds.title"),
                Component.translatable("advancements.adventure.craft_decorated_pot_using_only_sherds.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .addCriterion(
                "pot_crafted_using_only_sherds",
                RecipeCraftedTrigger.TriggerInstance.craftedItem(
                    new ResourceLocation("minecraft:decorated_pot"),
                    List.of(
                        ItemPredicate.Builder.item().of(ItemTags.DECORATED_POT_SHERDS),
                        ItemPredicate.Builder.item().of(ItemTags.DECORATED_POT_SHERDS),
                        ItemPredicate.Builder.item().of(ItemTags.DECORATED_POT_SHERDS),
                        ItemPredicate.Builder.item().of(ItemTags.DECORATED_POT_SHERDS)
                    )
                )
            )
            .save(p_256428_, "adventure/craft_decorated_pot_using_only_sherds");
        AdvancementHolder advancementholder11 = craftingANewLook(Advancement.Builder.advancement())
            .parent(advancementholder)
            .display(
                new ItemStack(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE),
                Component.translatable("advancements.adventure.trim_with_any_armor_pattern.title"),
                Component.translatable("advancements.adventure.trim_with_any_armor_pattern.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .save(p_256428_, "adventure/trim_with_any_armor_pattern");
        smithingWithStyle(Advancement.Builder.advancement())
            .parent(advancementholder11)
            .display(
                new ItemStack(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE),
                Component.translatable("advancements.adventure.trim_with_all_exclusive_armor_patterns.title"),
                Component.translatable("advancements.adventure.trim_with_all_exclusive_armor_patterns.description"),
                null,
                AdvancementType.CHALLENGE,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(150))
            .save(p_256428_, "adventure/trim_with_all_exclusive_armor_patterns");
        Advancement.Builder.advancement()
            .parent(advancementholder)
            .display(
                Items.CHISELED_BOOKSHELF,
                Component.translatable("advancements.adventure.read_power_from_chiseled_bookshelf.title"),
                Component.translatable("advancements.adventure.read_power_from_chiseled_bookshelf.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .requirements(AdvancementRequirements.Strategy.OR)
            .addCriterion("chiseled_bookshelf", placedBlockReadByComparator(Blocks.CHISELED_BOOKSHELF))
            .addCriterion("comparator", placedComparatorReadingBlock(Blocks.CHISELED_BOOKSHELF))
            .save(p_256428_, "adventure/read_power_of_chiseled_bookshelf");
    }

    public static AdvancementHolder createMonsterHunterAdvancement(
        AdvancementHolder p_314489_, Consumer<AdvancementHolder> p_314532_, List<EntityType<?>> p_314614_
    ) {
        AdvancementHolder advancementholder = addMobsToKill(Advancement.Builder.advancement(), p_314614_)
            .parent(p_314489_)
            .display(
                Items.IRON_SWORD,
                Component.translatable("advancements.adventure.kill_a_mob.title"),
                Component.translatable("advancements.adventure.kill_a_mob.description"),
                null,
                AdvancementType.TASK,
                true,
                true,
                false
            )
            .requirements(AdvancementRequirements.Strategy.OR)
            .save(p_314532_, "adventure/kill_a_mob");
        addMobsToKill(Advancement.Builder.advancement(), p_314614_)
            .parent(advancementholder)
            .display(
                Items.DIAMOND_SWORD,
                Component.translatable("advancements.adventure.kill_all_mobs.title"),
                Component.translatable("advancements.adventure.kill_all_mobs.description"),
                null,
                AdvancementType.CHALLENGE,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(100))
            .save(p_314532_, "adventure/kill_all_mobs");
        return advancementholder;
    }

    private static Criterion<ItemUsedOnLocationTrigger.TriggerInstance> placedBlockReadByComparator(Block p_286401_) {
        LootItemCondition.Builder[] alootitemcondition$builder = ComparatorBlock.FACING
            .getPossibleValues()
            .stream()
            .map(
                p_297934_ -> {
                    StatePropertiesPredicate.Builder statepropertiespredicate$builder = StatePropertiesPredicate.Builder.properties()
                        .hasProperty(ComparatorBlock.FACING, p_297934_);
                    BlockPredicate.Builder blockpredicate$builder = BlockPredicate.Builder.block()
                        .of(Blocks.COMPARATOR)
                        .setProperties(statepropertiespredicate$builder);
                    return LocationCheck.checkLocation(
                        LocationPredicate.Builder.location().setBlock(blockpredicate$builder), new BlockPos(p_297934_.getOpposite().getNormal())
                    );
                }
            )
            .toArray(p_286188_ -> new LootItemCondition.Builder[p_286188_]);
        return ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(
            LootItemBlockStatePropertyCondition.hasBlockStateProperties(p_286401_), AnyOfCondition.anyOf(alootitemcondition$builder)
        );
    }

    private static Criterion<ItemUsedOnLocationTrigger.TriggerInstance> placedComparatorReadingBlock(Block p_286250_) {
        LootItemCondition.Builder[] alootitemcondition$builder = ComparatorBlock.FACING
            .getPossibleValues()
            .stream()
            .map(
                p_286190_ -> {
                    StatePropertiesPredicate.Builder statepropertiespredicate$builder = StatePropertiesPredicate.Builder.properties()
                        .hasProperty(ComparatorBlock.FACING, p_286190_);
                    LootItemBlockStatePropertyCondition.Builder lootitemblockstatepropertycondition$builder = new LootItemBlockStatePropertyCondition.Builder(
                            Blocks.COMPARATOR
                        )
                        .setProperties(statepropertiespredicate$builder);
                    LootItemCondition.Builder lootitemcondition$builder = LocationCheck.checkLocation(
                        LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(p_286250_)), new BlockPos(p_286190_.getNormal())
                    );
                    return AllOfCondition.allOf(lootitemblockstatepropertycondition$builder, lootitemcondition$builder);
                }
            )
            .toArray(p_286191_ -> new LootItemCondition.Builder[p_286191_]);
        return ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(AnyOfCondition.anyOf(alootitemcondition$builder));
    }

    private static Advancement.Builder smithingWithStyle(Advancement.Builder p_285368_) {
        p_285368_.requirements(AdvancementRequirements.Strategy.AND);
        Set<Item> set = Set.of(
            Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE,
            Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE
        );
        VanillaRecipeProvider.smithingTrims()
            .filter(p_307140_ -> set.contains(p_307140_.template()))
            .forEach(p_307144_ -> p_285368_.addCriterion("armor_trimmed_" + p_307144_.id(), RecipeCraftedTrigger.TriggerInstance.craftedItem(p_307144_.id())));
        return p_285368_;
    }

    private static Advancement.Builder craftingANewLook(Advancement.Builder p_285062_) {
        p_285062_.requirements(AdvancementRequirements.Strategy.OR);
        VanillaRecipeProvider.smithingTrims()
            .map(VanillaRecipeProvider.TrimTemplate::id)
            .forEach(p_307146_ -> p_285062_.addCriterion("armor_trimmed_" + p_307146_, RecipeCraftedTrigger.TriggerInstance.craftedItem(p_307146_)));
        return p_285062_;
    }

    private static Advancement.Builder respectingTheRemnantsCriterions(Advancement.Builder p_285170_) {
        List<Pair<String, Criterion<LootTableTrigger.TriggerInstance>>> list = List.of(
            Pair.of("desert_pyramid", LootTableTrigger.TriggerInstance.lootTableUsed(BuiltInLootTables.DESERT_PYRAMID_ARCHAEOLOGY)),
            Pair.of("desert_well", LootTableTrigger.TriggerInstance.lootTableUsed(BuiltInLootTables.DESERT_WELL_ARCHAEOLOGY)),
            Pair.of("ocean_ruin_cold", LootTableTrigger.TriggerInstance.lootTableUsed(BuiltInLootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY)),
            Pair.of("ocean_ruin_warm", LootTableTrigger.TriggerInstance.lootTableUsed(BuiltInLootTables.OCEAN_RUIN_WARM_ARCHAEOLOGY)),
            Pair.of("trail_ruins_rare", LootTableTrigger.TriggerInstance.lootTableUsed(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE)),
            Pair.of("trail_ruins_common", LootTableTrigger.TriggerInstance.lootTableUsed(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON))
        );
        list.forEach(p_307142_ -> p_285170_.addCriterion(p_307142_.getFirst(), p_307142_.getSecond()));
        String s = "has_sherd";
        p_285170_.addCriterion("has_sherd", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTags.DECORATED_POT_SHERDS)));
        p_285170_.requirements(new AdvancementRequirements(List.of(list.stream().map(Pair::getFirst).toList(), List.of("has_sherd"))));
        return p_285170_;
    }

    protected static void createAdventuringTime(
        Consumer<AdvancementHolder> p_275645_, AdvancementHolder p_301274_, MultiNoiseBiomeSourceParameterList.Preset p_275211_
    ) {
        addBiomes(Advancement.Builder.advancement(), p_275211_.usedBiomes().toList())
            .parent(p_301274_)
            .display(
                Items.DIAMOND_BOOTS,
                Component.translatable("advancements.adventure.adventuring_time.title"),
                Component.translatable("advancements.adventure.adventuring_time.description"),
                null,
                AdvancementType.CHALLENGE,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(500))
            .save(p_275645_, "adventure/adventuring_time");
    }

    private static Advancement.Builder addMobsToKill(Advancement.Builder p_248814_, List<EntityType<?>> p_314428_) {
        p_314428_.forEach(
            p_314409_ -> p_248814_.addCriterion(
                    BuiltInRegistries.ENTITY_TYPE.getKey(p_314409_).toString(),
                    KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(p_314409_))
                )
        );
        return p_248814_;
    }

    protected static Advancement.Builder addBiomes(Advancement.Builder p_249250_, List<ResourceKey<Biome>> p_251338_) {
        for(ResourceKey<Biome> resourcekey : p_251338_) {
            p_249250_.addCriterion(resourcekey.location().toString(), PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(resourcekey)));
        }

        return p_249250_;
    }
}
