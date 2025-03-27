
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.bcm.arcanumofwisdom.block.entity.ArtifactlaboratorytableBlockEntity;
import net.bcm.arcanumofwisdom.block.entity.ArtifactcraftingtableBlockEntity;
import net.bcm.arcanumofwisdom.block.entity.AltarOfTheAlchemistBlockEntity;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ArcanumOfWisdomModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ArcanumOfWisdomMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ARTIFACTLABORATORYTABLE = register("artifactlaboratorytable", ArcanumOfWisdomModBlocks.ARTIFACTLABORATORYTABLE, ArtifactlaboratorytableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ARTIFACTCRAFTINGTABLE = register("artifactcraftingtable", ArcanumOfWisdomModBlocks.ARTIFACTCRAFTINGTABLE, ArtifactcraftingtableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ALTAR_OF_THE_ALCHEMIST = register("altar_of_the_alchemist", ArcanumOfWisdomModBlocks.ALTAR_OF_THE_ALCHEMIST, AltarOfTheAlchemistBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ARTIFACTLABORATORYTABLE.get(), (blockEntity, side) -> ((ArtifactlaboratorytableBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ARTIFACTCRAFTINGTABLE.get(), (blockEntity, side) -> ((ArtifactcraftingtableBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ALTAR_OF_THE_ALCHEMIST.get(), (blockEntity, side) -> ((AltarOfTheAlchemistBlockEntity) blockEntity).getItemHandler());
	}
}
