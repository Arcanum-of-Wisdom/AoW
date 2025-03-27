package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class BAWGUIArcanaBiomeRaritiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p [\"\",{\"text\":\"Arcana Dimension\",\"bold\":true,\"underlined\":true,\"color\":\"gold\"},\"\\n\",{\"text\":\"Biome rarities\",\"bold\":true,\"color\":\"dark_blue\"},\"\\n\",\"Some of the Arcana biomes are relatively rare, legends say there is a sixth, mysterious biome, but it seems to be so rare that no one has managed to find it yet. However, research has now revealed percentages of how rare the biomes would be if they were on the overworld. This allows you to determine how rare these are in the Arcana Dimension.\",\"\\n\",{\"text\":\"5. Place: Plains biome (2,812%)\",\"color\":\"red\"},\"\\n\",{\"text\":\"4. Place: Rivers biome (0,75%)\",\"color\":\"red\"},\"\\n\",{\"text\":\"3. Place: Snowy wasteland biome (0,234%)\",\"color\":\"red\"},\"\\n\",{\"text\":\"2. Place: Cherry grove biome (0,143%)\",\"color\":\"red\"},\"\\n\",{\"text\":\"1. Place: High mountains biome (0,1%)\",\"color\":\"gold\"},\"\\n\"]");
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.in")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.in")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
	}
}
