
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.bcm.arcanumofwisdom.init;

import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ArcanumOfWisdomModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()),

					new ItemStack(Items.DIAMOND_CHESTPLATE), 2, 8, 0.1f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()), new ItemStack(Items.NETHERITE_INGOT), new ItemStack(Items.NETHERITE_CHESTPLATE), 1, 10, 0.2f));
		}
		if (event.getType() == VillagerProfession.FISHERMAN) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()),

					new ItemStack(Items.NAUTILUS_SHELL, 2), 10, 5, 0.08f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()),

					new ItemStack(Items.HEART_OF_THE_SEA), 10, 6, 0.06f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()),

					new ItemStack(Items.PRISMARINE_SHARD, 25), 10, 5, 0.06f));
		}
		if (event.getType() == VillagerProfession.CLERIC) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()),

					new ItemStack(Items.BLAZE_ROD, 3), 8, 6, 0.07f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()),

					new ItemStack(Blocks.BREWING_STAND), 1, 8, 0.1f));
		}
		if (event.getType() == VillagerProfession.LIBRARIAN) {
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()),

					new ItemStack(Blocks.ENCHANTING_TABLE), 1, 8, 0.06f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()),

					new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 2), 8, 8, 0.07f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()),

					new ItemStack(Items.EXPERIENCE_BOTTLE, 10), 15, 5, 0.06f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()),

					new ItemStack(Items.BURN_POTTERY_SHERD), 8, 7, 0.06f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get()),

					new ItemStack(Items.HEART_POTTERY_SHERD), 8, 7, 0.06f));
		}
		if (event.getType() == VillagerProfession.WEAPONSMITH) {
			event.getTrades().get(5)
					.add(new BasicItemListing(new ItemStack(ArcanumOfWisdomModItems.COMBINED_ARTIFACT.get(), 2), new ItemStack(Items.NETHERITE_SWORD), new ItemStack(ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_SWORD.get()), 1, 5, 0.3f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),

					new ItemStack(ArcanumOfWisdomModItems.NETHERITE_ARTIFACT_SWORD.get()), 10, 5, 0.05f));
		}
	}
}
