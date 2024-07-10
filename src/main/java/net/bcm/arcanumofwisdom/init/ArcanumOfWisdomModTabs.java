
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class ArcanumOfWisdomModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArcanumOfWisdomMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> KREATIVTAB_AOW = REGISTRY.register("kreativtab_aow",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.arcanum_of_wisdom.kreativtab_aow")).icon(() -> new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_LIFE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ArcanumOfWisdomModItems.ARTIFACT_OF_LIFE.get());
				tabData.accept(ArcanumOfWisdomModItems.ARTIFACT_OF_MATERIALS.get());
				tabData.accept(ArcanumOfWisdomModItems.ARTIFACT_OF_FLUIDS.get());
				tabData.accept(ArcanumOfWisdomModItems.ARTIFACT_OF_MAGIC.get());
				tabData.accept(ArcanumOfWisdomModItems.ARTIFACT_OF_DIMENSIONS.get());
				tabData.accept(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get());
				tabData.accept(ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_SWORD.get());
				tabData.accept(ArcanumOfWisdomModItems.HOLY_BRANCH.get());
				tabData.accept(ArcanumOfWisdomModBlocks.ARTIFACTLABORATORYTABLE.get().asItem());
			}).withSearchBar().build());
}
