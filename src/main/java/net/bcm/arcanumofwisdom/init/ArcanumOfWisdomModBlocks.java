
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.bcm.arcanumofwisdom.block.FakeWaterBlock;
import net.bcm.arcanumofwisdom.block.FakeLavaBlock;
import net.bcm.arcanumofwisdom.block.ArtifactlaboratorytableBlock;
import net.bcm.arcanumofwisdom.block.ArtifactcraftingtableBlock;
import net.bcm.arcanumofwisdom.block.AltarOfTheAlchemistBlock;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class ArcanumOfWisdomModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(ArcanumOfWisdomMod.MODID);
	public static final DeferredBlock<Block> FAKE_WATER = REGISTRY.register("fake_water", FakeWaterBlock::new);
	public static final DeferredBlock<Block> FAKE_LAVA = REGISTRY.register("fake_lava", FakeLavaBlock::new);
	public static final DeferredBlock<Block> ARTIFACTLABORATORYTABLE = REGISTRY.register("artifactlaboratorytable", ArtifactlaboratorytableBlock::new);
	public static final DeferredBlock<Block> ARTIFACTCRAFTINGTABLE = REGISTRY.register("artifactcraftingtable", ArtifactcraftingtableBlock::new);
	public static final DeferredBlock<Block> ALTAR_OF_THE_ALCHEMIST = REGISTRY.register("altar_of_the_alchemist", AltarOfTheAlchemistBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			FakeWaterBlock.blockColorLoad(event);
		}
	}
}
