
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.bcm.arcanumofwisdom.block.FakeWaterBlock;
import net.bcm.arcanumofwisdom.block.FakeLavaBlock;
import net.bcm.arcanumofwisdom.block.ArtifactlaboratorytableBlock;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class ArcanumOfWisdomModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK, ArcanumOfWisdomMod.MODID);
	public static final DeferredHolder<Block, Block> FAKE_WATER = REGISTRY.register("fake_water", () -> new FakeWaterBlock());
	public static final DeferredHolder<Block, Block> FAKE_LAVA = REGISTRY.register("fake_lava", () -> new FakeLavaBlock());
	public static final DeferredHolder<Block, Block> ARTIFACTLABORATORYTABLE = REGISTRY.register("artifactlaboratorytable", () -> new ArtifactlaboratorytableBlock());

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			FakeWaterBlock.blockColorLoad(event);
		}
	}
}
