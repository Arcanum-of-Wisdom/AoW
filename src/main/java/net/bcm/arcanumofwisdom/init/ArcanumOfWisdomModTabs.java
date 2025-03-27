
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
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.arcanum_of_wisdom.kreativtab_aow")).icon(() -> new ItemStack(ArcanumOfWisdomModItems.THE_BOOK_OF_ARCANA_WISDOM.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ArcanumOfWisdomModItems.THE_BOOK_OF_ARCANA_WISDOM.get());
				tabData.accept(ArcanumOfWisdomModItems.ADJUSTABLE_BOTTLE_OF_ENCHANTING.get());
				tabData.accept(ArcanumOfWisdomModItems.UNLIMITED_BOTTLE_OF_ENCHANTING.get());
				tabData.accept(ArcanumOfWisdomModItems.ARTIFACT_OF_DEFORMATION.get());
				tabData.accept(ArcanumOfWisdomModItems.ARTIFACT_OF_LIFE.get());
				tabData.accept(ArcanumOfWisdomModItems.ARTIFACT_OF_MATERIALS.get());
				tabData.accept(ArcanumOfWisdomModItems.ARTIFACT_OF_FLUIDS.get());
				tabData.accept(ArcanumOfWisdomModItems.ARTIFACT_OF_MAGIC.get());
				tabData.accept(ArcanumOfWisdomModItems.ARTIFACT_OF_DIMENSIONS.get());
				tabData.accept(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get());
				tabData.accept(ArcanumOfWisdomModItems.ENCRYPTED_ALCHEMY_BOOK.get());
				tabData.accept(ArcanumOfWisdomModBlocks.ARTIFACTLABORATORYTABLE.get().asItem());
				tabData.accept(ArcanumOfWisdomModBlocks.ARTIFACTCRAFTINGTABLE.get().asItem());
				tabData.accept(ArcanumOfWisdomModBlocks.ALTAR_OF_THE_ALCHEMIST.get().asItem());
				tabData.accept(ArcanumOfWisdomModItems.HOLY_BRANCH.get());
				tabData.accept(ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_SWORD.get());
				tabData.accept(ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_SHIELD.get());
				tabData.accept(ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_ARMOR_HELMET.get());
				tabData.accept(ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_ARMOR_CHESTPLATE.get());
				tabData.accept(ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_ARMOR_LEGGINGS.get());
				tabData.accept(ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_ARMOR_BOOTS.get());
				tabData.accept(ArcanumOfWisdomModItems.BOTTLE_OF_ELYTRA_ENHANCER.get());
				tabData.accept(ArcanumOfWisdomModItems.BOTTLE_OF_REGENERATIVE_HEALTH_POOL.get());
				tabData.accept(ArcanumOfWisdomModItems.BOTTLE_OF_TOTEM.get());
				tabData.accept(ArcanumOfWisdomModItems.BOTTLE_OF_INSTANT_SATURATION.get());
				tabData.accept(ArcanumOfWisdomModItems.BOTTLE_OF_REGENERATIVE_SATURATION_POOL.get());
				tabData.accept(ArcanumOfWisdomModItems.BOTTLE_OF_INSTANT_COMEBACK.get());
				tabData.accept(ArcanumOfWisdomModItems.BOTTLE_OF_ARMOR_BOOSTER.get());
				tabData.accept(ArcanumOfWisdomModItems.BOTTLE_OF_MINING_BOOSTER.get());
				tabData.accept(ArcanumOfWisdomModItems.BOTTLE_OF_FISTBOOSTER.get());
				tabData.accept(ArcanumOfWisdomModItems.BOTTLE_OF_FIST_OF_DOOM.get());
				tabData.accept(ArcanumOfWisdomModItems.BOTTLE_OF_RAIDERS_ELIXIR.get());
			}).withSearchBar().build());
}
