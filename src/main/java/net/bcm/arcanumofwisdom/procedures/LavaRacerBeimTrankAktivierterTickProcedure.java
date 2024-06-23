package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;
import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModBlocks;

import java.util.Map;

public class LavaRacerBeimTrankAktivierterTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).lavaracer_active == true) {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.LAVA && (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AIR) {
				if (entity.isShiftKeyDown()) {
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ArcanumOfWisdomModBlocks.FAKE_LAVA.get()) {
						{
							BlockPos _bp = BlockPos.containing(x, y - 1, z);
							BlockState _bs = Blocks.LAVA.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
								if (_property != null && _bs.getValue(_property) != null)
									try {
										_bs = _bs.setValue(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							BlockEntity _be = world.getBlockEntity(_bp);
							CompoundTag _bnbt = null;
							if (_be != null) {
								_bnbt = _be.saveWithFullMetadata();
								_be.setRemoved();
							}
							world.setBlock(_bp, _bs, 3);
							if (_bnbt != null) {
								_be = world.getBlockEntity(_bp);
								if (_be != null) {
									try {
										_be.load(_bnbt);
									} catch (Exception ignored) {
									}
								}
							}
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ArcanumOfWisdomModBlocks.FAKE_LAVA.get()) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = Blocks.LAVA.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
								if (_property != null && _bs.getValue(_property) != null)
									try {
										_bs = _bs.setValue(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							BlockEntity _be = world.getBlockEntity(_bp);
							CompoundTag _bnbt = null;
							if (_be != null) {
								_bnbt = _be.saveWithFullMetadata();
								_be.setRemoved();
							}
							world.setBlock(_bp, _bs, 3);
							if (_bnbt != null) {
								_be = world.getBlockEntity(_bp);
								if (_be != null) {
									try {
										_be.load(_bnbt);
									} catch (Exception ignored) {
									}
								}
							}
						}
					}
				} else {
					world.setBlock(BlockPos.containing(x, y - 1, z), ArcanumOfWisdomModBlocks.FAKE_LAVA.get().defaultBlockState(), 3);
				}
			}
		}
	}
}
