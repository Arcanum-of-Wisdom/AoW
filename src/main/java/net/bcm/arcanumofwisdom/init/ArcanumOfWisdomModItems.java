
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

import net.bcm.arcanumofwisdom.item.HolyBranchItem;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class ArcanumOfWisdomModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, ArcanumOfWisdomMod.MODID);
	public static final DeferredHolder<Item, Item> FAKE_WATER = block(ArcanumOfWisdomModBlocks.FAKE_WATER);
	public static final DeferredHolder<Item, Item> FAKE_LAVA = block(ArcanumOfWisdomModBlocks.FAKE_LAVA);
	public static final DeferredHolder<Item, Item> HOLY_BRANCH = REGISTRY.register("holy_branch", () -> new HolyBranchItem());

	// Start of user code block custom items
	// End of user code block custom items
	public static void register(IEventBus bus) {
		REGISTRY.register(bus);
	}

	private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
