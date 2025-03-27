package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class LoadSecModsCMDPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		if (ModList.get().isLoaded("arcanum_of_dimensions")) {
			if (BoolArgumentType.getBool(arguments, "toggle") == true) {
				ArcanumOfWisdomModVariables.WorldVariables.get(world).connect_mods = true;
				ArcanumOfWisdomModVariables.WorldVariables.get(world).syncData(world);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @a [\"\",{\"text\":\"Attention! (important server- and client-side message)\",\"bold\":true,\"underlined\":true,\"color\":\"red\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"text\":\"This message was sent by AoW! (mod)\",\"italic\":true,\"color\":\"dark_blue\"}]}},\"\\n\",\"An operator has executed /aow_loadSecMods! Shared functions are now carried out between the installed mods AoW and AoD.\"]");
			} else if (BoolArgumentType.getBool(arguments, "toggle") == false) {
				ArcanumOfWisdomModVariables.WorldVariables.get(world).connect_mods = false;
				ArcanumOfWisdomModVariables.WorldVariables.get(world).syncData(world);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @a [\"\",{\"text\":\"Attention! (important server- and client-side message)\",\"bold\":true,\"underlined\":true,\"color\":\"red\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"text\":\"This message was sent by AoW! (mod)\",\"italic\":true,\"color\":\"dark_blue\"}]}},\"\\n\",\"An operator executed /aow_loadSecMods! Common functions between the installed mods AoW and AoD are now disabled.\"]");
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @p [\"\",{\"text\":\"Error cm01:\",\"bold\":true,\"color\":\"red\"},\"\\n\",\"Could not load/unload related mod functions! Do not forget to put true or false behind /aow_loadSecMods. Try again or restart Minecraft.\"]");
			}
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @p [\"\",{\"text\":\"Error cm02:\",\"bold\":true,\"color\":\"red\"},\"\\n\",\"Could not recognize any AoW related mods such as AoD! Make sure that the mod is installed and the version is correct.\"]");
		}
	}
}
