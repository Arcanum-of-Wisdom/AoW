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

public class BAWGUIArcanaArcanaWisdomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p [\"\",{\"text\":\"Arcana Dimension\",\"bold\":true,\"underlined\":true,\"color\":\"gold\"},\"\\n\",{\"text\":\"Arcana wisdom\",\"bold\":true,\"color\":\"dark_blue\"},\"\\n\",\"If one has the wisdom to enter the Arcana Dimension, one is able to live in a peaceful world, without contact with the outside world, without day and night cycles and therefore without monsters. But that's not all there is to this dimension. Nobody knows why, but it seems as if some danger factors are not working here. There is no falling damage here, no damage from drowning, your health usually remains full and you seem to develop a kind of resistance. Some of these effects even stay with you outside the dimension for a while, so you are protected for a while when you leave it. The phenomenon even occurred that people could fly for a short time, but then fell from the sky.\",\"\\n\"]");
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.in")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.in")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
	}
}
