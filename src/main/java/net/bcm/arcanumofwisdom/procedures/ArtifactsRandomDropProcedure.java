package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ArtifactsRandomDropProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player || entity instanceof ServerPlayer) && getEntityGameType(entity) == GameType.SURVIVAL && Mth.nextInt(RandomSource.create(), 1, 16) == 1) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DIAMOND_ORE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.ANCIENT_DEBRIS
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE_EMERALD_ORE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE_DIAMOND_ORE
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.EMERALD_ORE) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal.spawn")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal.spawn")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_FLUIDS.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_LIFE.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_MAGIC.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_DEFORMATION.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_DIMENSIONS.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				} else {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_MATERIALS.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.GOLD_ORE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE_GOLD_ORE)
					&& Mth.nextInt(RandomSource.create(), 1, 16) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal.spawn")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal.spawn")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_FLUIDS.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_LIFE.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_MAGIC.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_DEFORMATION.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_DIMENSIONS.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				} else {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ArcanumOfWisdomModItems.ARTIFACT_OF_MATERIALS.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}
