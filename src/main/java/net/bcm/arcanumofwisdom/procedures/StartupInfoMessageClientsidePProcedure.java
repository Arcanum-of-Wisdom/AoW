package net.bcm.arcanumofwisdom.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StartupInfoMessageClientsidePProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level)
			_level.getScoreboard().addPlayerTeam("aow_raider_elixir");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"team modify aow_raider_elixir color dark_red");
		if (entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES).startup_message == false) {
			{
				ArcanumOfWisdomModVariables.PlayerVariables _vars = entity.getData(ArcanumOfWisdomModVariables.PLAYER_VARIABLES);
				_vars.startup_message = true;
				_vars.syncPlayerVariables(entity);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.in")), SoundSource.PLAYERS, 5, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.in")), SoundSource.PLAYERS, 5, (float) 0.8, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @a [\"\",{\"text\":\"Arcanum of Wisdom: Startup information\",\"bold\":true,\"underlined\":true,\"color\":\"#D50000\"},\"\\n\",{\"text\":\"Client-side warning: AoW uses Minecraft's attribute function for LVL effects. Even though changing these attributes using /attribute does not destroy the mod, some functions can only be activated after repeated attempts. It is recommended not to use /attribute.\",\"color\":\"red\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"text\":\"This message will no longer be displayed after the next world start. (You can enable it again with /aow_sm_enable)\",\"italic\":true,\"color\":\"gold\"}]}},\"\\n\"]");
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You can toggle the AoW Options Teaser by executing /aow_sm_disable or /aow_sm_enable!"), false);
			if (ModList.get().isLoaded("arcanum_of_dimensions")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"It was detected that the AoW and AoD mods were installed! AoW and AoD now share various functions. You can turn these functions off or on using this command: /aowLoadSecMods true/false. These functions must be set individually for each world. The default is: ON! These message was sent by client-side-AoW."),
							false);
			}
		}
	}
}
