
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.registries.BuiltInRegistries;

import net.bcm.arcanumofwisdom.item.NetheriteArtifactSwordItem;
import net.bcm.arcanumofwisdom.item.HolyBranchItem;
import net.bcm.arcanumofwisdom.item.CombinedArtifactItem;
import net.bcm.arcanumofwisdom.item.ArtifactOfMaterialsItem;
import net.bcm.arcanumofwisdom.item.ArtifactOfMagicItem;
import net.bcm.arcanumofwisdom.item.ArtifactOfLifeItem;
import net.bcm.arcanumofwisdom.item.ArtifactOfFluidsItem;
import net.bcm.arcanumofwisdom.item.ArtifactOfDimensionsItem;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class ArcanumOfWisdomModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, ArcanumOfWisdomMod.MODID);
	public static final DeferredHolder<Item, Item> FAKE_WATER = block(ArcanumOfWisdomModBlocks.FAKE_WATER);
	public static final DeferredHolder<Item, Item> FAKE_LAVA = block(ArcanumOfWisdomModBlocks.FAKE_LAVA);
	public static final DeferredHolder<Item, Item> HOLY_BRANCH = REGISTRY.register("holy_branch", () -> new HolyBranchItem());
	public static final DeferredHolder<Item, Item> ARTIFACT_OF_LIFE = REGISTRY.register("artifact_of_life", () -> new ArtifactOfLifeItem());
	public static final DeferredHolder<Item, Item> ARTIFACT_OF_MATERIALS = REGISTRY.register("artifact_of_materials", () -> new ArtifactOfMaterialsItem());
	public static final DeferredHolder<Item, Item> ARTIFACT_OF_FLUIDS = REGISTRY.register("artifact_of_fluids", () -> new ArtifactOfFluidsItem());
	public static final DeferredHolder<Item, Item> ARTIFACT_OF_MAGIC = REGISTRY.register("artifact_of_magic", () -> new ArtifactOfMagicItem());
	public static final DeferredHolder<Item, Item> ARTIFACT_OF_DIMENSIONS = REGISTRY.register("artifact_of_dimensions", () -> new ArtifactOfDimensionsItem());
	public static final DeferredHolder<Item, Item> ARTIFACTLABORATORYTABLE = block(ArcanumOfWisdomModBlocks.ARTIFACTLABORATORYTABLE);
	public static final DeferredHolder<Item, Item> COMBINED_ARTIFACT = REGISTRY.register("combined_artifact", () -> new CombinedArtifactItem());
	public static final DeferredHolder<Item, Item> NETHERITE_ARTIFACT_SWORD = REGISTRY.register("netherite_artifact_sword", () -> new NetheriteArtifactSwordItem());

	// Start of user code block custom items
	// End of user code block custom items
	public static void register(IEventBus bus) {
		REGISTRY.register(bus);
	}

	private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
