
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.bcm.arcanumofwisdom.item.inventory.TheBookOfArcanaWisdomInventoryCapability;
import net.bcm.arcanumofwisdom.item.inventory.AdjustableBottleOfEnchantingInventoryCapability;
import net.bcm.arcanumofwisdom.item.UnlimitedBottleOfEnchantingItem;
import net.bcm.arcanumofwisdom.item.TheBookOfArcanaWisdomItem;
import net.bcm.arcanumofwisdom.item.Netherite_ArtifactArmorItem;
import net.bcm.arcanumofwisdom.item.NetheriteArtifactSwordItem;
import net.bcm.arcanumofwisdom.item.NetheriteArtifactShieldItem;
import net.bcm.arcanumofwisdom.item.NetheriteArtifactShieldBlockingItem;
import net.bcm.arcanumofwisdom.item.HolyBranchItem;
import net.bcm.arcanumofwisdom.item.EncryptedAlchemyBookItem;
import net.bcm.arcanumofwisdom.item.CombinedArtifactItem;
import net.bcm.arcanumofwisdom.item.BottleOfTotemItem;
import net.bcm.arcanumofwisdom.item.BottleOfRegenerativeSaturationPoolItem;
import net.bcm.arcanumofwisdom.item.BottleOfRegenerativeHealthPoolItem;
import net.bcm.arcanumofwisdom.item.BottleOfRaidersElixirItem;
import net.bcm.arcanumofwisdom.item.BottleOfMiningBoosterItem;
import net.bcm.arcanumofwisdom.item.BottleOfInstantSaturationItem;
import net.bcm.arcanumofwisdom.item.BottleOfInstantComebackItem;
import net.bcm.arcanumofwisdom.item.BottleOfFistboosterItem;
import net.bcm.arcanumofwisdom.item.BottleOfFistOfDoomItem;
import net.bcm.arcanumofwisdom.item.BottleOfElytraEnhancerItem;
import net.bcm.arcanumofwisdom.item.BottleOfArmorBoosterItem;
import net.bcm.arcanumofwisdom.item.ArtifactOfMaterialsItem;
import net.bcm.arcanumofwisdom.item.ArtifactOfMagicItem;
import net.bcm.arcanumofwisdom.item.ArtifactOfLifeItem;
import net.bcm.arcanumofwisdom.item.ArtifactOfFluidsItem;
import net.bcm.arcanumofwisdom.item.ArtifactOfDimensionsItem;
import net.bcm.arcanumofwisdom.item.ArtifactOfDeformationItem;
import net.bcm.arcanumofwisdom.item.AdjustableBottleOfEnchantingItem;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ArcanumOfWisdomModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ArcanumOfWisdomMod.MODID);
	public static final DeferredItem<Item> FAKE_WATER = block(ArcanumOfWisdomModBlocks.FAKE_WATER);
	public static final DeferredItem<Item> FAKE_LAVA = block(ArcanumOfWisdomModBlocks.FAKE_LAVA);
	public static final DeferredItem<Item> HOLY_BRANCH = REGISTRY.register("holy_branch", HolyBranchItem::new);
	public static final DeferredItem<Item> ARTIFACT_OF_LIFE = REGISTRY.register("artifact_of_life", ArtifactOfLifeItem::new);
	public static final DeferredItem<Item> ARTIFACT_OF_MATERIALS = REGISTRY.register("artifact_of_materials", ArtifactOfMaterialsItem::new);
	public static final DeferredItem<Item> ARTIFACT_OF_FLUIDS = REGISTRY.register("artifact_of_fluids", ArtifactOfFluidsItem::new);
	public static final DeferredItem<Item> ARTIFACT_OF_MAGIC = REGISTRY.register("artifact_of_magic", ArtifactOfMagicItem::new);
	public static final DeferredItem<Item> ARTIFACT_OF_DIMENSIONS = REGISTRY.register("artifact_of_dimensions", ArtifactOfDimensionsItem::new);
	public static final DeferredItem<Item> ARTIFACTLABORATORYTABLE = block(ArcanumOfWisdomModBlocks.ARTIFACTLABORATORYTABLE);
	public static final DeferredItem<Item> COMBINED_ARTIFACT = REGISTRY.register("combined_artifact", CombinedArtifactItem::new);
	public static final DeferredItem<Item> NETHERITE_ARTIFACT_SWORD = REGISTRY.register("netherite_artifact_sword", NetheriteArtifactSwordItem::new);
	public static final DeferredItem<Item> NETHERITE_ARTIFACT_SHIELD = REGISTRY.register("netherite_artifact_shield", NetheriteArtifactShieldItem::new);
	public static final DeferredItem<Item> NETHERITE_ARTIFACT_SHIELD_BLOCKING = REGISTRY.register("netherite_artifact_shield_blocking", NetheriteArtifactShieldBlockingItem::new);
	public static final DeferredItem<Item> THE_BOOK_OF_ARCANA_WISDOM = REGISTRY.register("the_book_of_arcana_wisdom", TheBookOfArcanaWisdomItem::new);
	public static final DeferredItem<Item> NETHERITE_ARTIFACT_ARMOR_HELMET = REGISTRY.register("netherite_artifact_armor_helmet", Netherite_ArtifactArmorItem.Helmet::new);
	public static final DeferredItem<Item> NETHERITE_ARTIFACT_ARMOR_CHESTPLATE = REGISTRY.register("netherite_artifact_armor_chestplate", Netherite_ArtifactArmorItem.Chestplate::new);
	public static final DeferredItem<Item> NETHERITE_ARTIFACT_ARMOR_LEGGINGS = REGISTRY.register("netherite_artifact_armor_leggings", Netherite_ArtifactArmorItem.Leggings::new);
	public static final DeferredItem<Item> NETHERITE_ARTIFACT_ARMOR_BOOTS = REGISTRY.register("netherite_artifact_armor_boots", Netherite_ArtifactArmorItem.Boots::new);
	public static final DeferredItem<Item> ARTIFACTCRAFTINGTABLE = block(ArcanumOfWisdomModBlocks.ARTIFACTCRAFTINGTABLE);
	public static final DeferredItem<Item> ALTAR_OF_THE_ALCHEMIST = block(ArcanumOfWisdomModBlocks.ALTAR_OF_THE_ALCHEMIST);
	public static final DeferredItem<Item> BOTTLE_OF_ELYTRA_ENHANCER = REGISTRY.register("bottle_of_elytra_enhancer", BottleOfElytraEnhancerItem::new);
	public static final DeferredItem<Item> BOTTLE_OF_TOTEM = REGISTRY.register("bottle_of_totem", BottleOfTotemItem::new);
	public static final DeferredItem<Item> BOTTLE_OF_REGENERATIVE_HEALTH_POOL = REGISTRY.register("bottle_of_regenerative_health_pool", BottleOfRegenerativeHealthPoolItem::new);
	public static final DeferredItem<Item> BOTTLE_OF_INSTANT_SATURATION = REGISTRY.register("bottle_of_instant_saturation", BottleOfInstantSaturationItem::new);
	public static final DeferredItem<Item> BOTTLE_OF_REGENERATIVE_SATURATION_POOL = REGISTRY.register("bottle_of_regenerative_saturation_pool", BottleOfRegenerativeSaturationPoolItem::new);
	public static final DeferredItem<Item> BOTTLE_OF_INSTANT_COMEBACK = REGISTRY.register("bottle_of_instant_comeback", BottleOfInstantComebackItem::new);
	public static final DeferredItem<Item> BOTTLE_OF_ARMOR_BOOSTER = REGISTRY.register("bottle_of_armor_booster", BottleOfArmorBoosterItem::new);
	public static final DeferredItem<Item> ARTIFACT_OF_DEFORMATION = REGISTRY.register("artifact_of_deformation", ArtifactOfDeformationItem::new);
	public static final DeferredItem<Item> BOTTLE_OF_MINING_BOOSTER = REGISTRY.register("bottle_of_mining_booster", BottleOfMiningBoosterItem::new);
	public static final DeferredItem<Item> BOTTLE_OF_FISTBOOSTER = REGISTRY.register("bottle_of_fistbooster", BottleOfFistboosterItem::new);
	public static final DeferredItem<Item> ENCRYPTED_ALCHEMY_BOOK = REGISTRY.register("encrypted_alchemy_book", EncryptedAlchemyBookItem::new);
	public static final DeferredItem<Item> BOTTLE_OF_FIST_OF_DOOM = REGISTRY.register("bottle_of_fist_of_doom", BottleOfFistOfDoomItem::new);
	public static final DeferredItem<Item> BOTTLE_OF_RAIDERS_ELIXIR = REGISTRY.register("bottle_of_raiders_elixir", BottleOfRaidersElixirItem::new);
	public static final DeferredItem<Item> ADJUSTABLE_BOTTLE_OF_ENCHANTING = REGISTRY.register("adjustable_bottle_of_enchanting", AdjustableBottleOfEnchantingItem::new);
	public static final DeferredItem<Item> UNLIMITED_BOTTLE_OF_ENCHANTING = REGISTRY.register("unlimited_bottle_of_enchanting", UnlimitedBottleOfEnchantingItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new TheBookOfArcanaWisdomInventoryCapability(stack), THE_BOOK_OF_ARCANA_WISDOM.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new AdjustableBottleOfEnchantingInventoryCapability(stack), ADJUSTABLE_BOTTLE_OF_ENCHANTING.get());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
