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

public class BAWGUIArcanaTheBeginningProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p [\"\",{\"text\":\"The Story\",\"bold\":true,\"underlined\":true,\"color\":\"gold\"},\"\\n\",{\"text\":\"The Beginning\",\"bold\":true,\"color\":\"dark_blue\"},\"\\n\",\"The Arcanum of Wisdom describes the infinite power, kept secret and explored by the Elders. Through them one realized how a journey through dimensions works, that there is more than what we know. What we call Overworld. It was thought that travel through time and space, however evolutionary, was only possible through portals, but new possibilities were quickly discovered. Old stones carried part of the magic and if you tried to combine them, you would end up in different dimensions. With the power of redstone, the world finally managed to combine all the stones into one stable stone, which allowed one to enter the Arcana dimension and actually leave it again.\",\"\\n\"]");
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.in")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.in")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
	}
}
