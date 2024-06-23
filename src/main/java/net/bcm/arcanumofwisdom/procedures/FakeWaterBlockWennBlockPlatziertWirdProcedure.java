package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class FakeWaterBlockWennBlockPlatziertWirdProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _booleanProp)
				world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
		}
		ArcanumOfWisdomMod.queueServerWork(20, () -> {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y, z), Blocks.WATER.defaultBlockState(), 3);
		});
	}
}
