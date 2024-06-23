package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class WisdomCMDPProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
				if (entityiterator instanceof Player _player)
					_player.giveExperienceLevels(-(entityiterator instanceof Player _plr ? _plr.experienceLevel : 0));
				if (entityiterator instanceof Player _player)
					_player.giveExperienceLevels((int) DoubleArgumentType.getDouble(arguments, "wisdom"));
				{
					ArcanumOfWisdomModVariables.PlayerVariables _vars = entityiterator.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
					_vars.wisdom = DoubleArgumentType.getDouble(arguments, "wisdom");
					_vars.syncPlayerVariables(entityiterator);
				}
				if (world instanceof ServerLevel _level)
					_level.addFreshEntity(new ExperienceOrb(_level, (entityiterator.getX()), (entityiterator.getZ()), (entityiterator.getY()), 1));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
