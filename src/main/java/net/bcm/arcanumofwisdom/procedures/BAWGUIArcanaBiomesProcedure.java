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

public class BAWGUIArcanaBiomesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p [\"\",{\"text\":\"Arcana Dimension\",\"bold\":true,\"underlined\":true,\"color\":\"gold\"},\"\\n\",{\"text\":\"Biomes\",\"bold\":true,\"color\":\"dark_blue\"},\"\\n\",\"The Arcana Dimension seems peaceful so far, but it hasn't been explored enough to know what's really behind it. Legends say there are areas that were literally eaten away. Nobody really knows what was meant by that. In any case, there are around 5 biomes in the Arcana Dimension: The Arcana Plains Biome, the Arcana Rivers Biome, the Arcana Cherry Grove Biome, the Arcana High Mountains Biome and finally the Arcana Snowy Wasteland Biome. They are filled with peaceful, plant-rich scenes and small culinary delights, such as the bright berries on these hanging sprinkles. It's rare to even see a few of these in the overworld.\",\"\\n\"]");
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.in")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.in")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
	}
}
