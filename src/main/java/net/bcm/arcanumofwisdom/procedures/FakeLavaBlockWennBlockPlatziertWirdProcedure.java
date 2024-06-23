package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class FakeLavaBlockWennBlockPlatziertWirdProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ArcanumOfWisdomMod.queueServerWork(25, () -> {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y, z), Blocks.LAVA.defaultBlockState(), 3);
		});
	}
}
