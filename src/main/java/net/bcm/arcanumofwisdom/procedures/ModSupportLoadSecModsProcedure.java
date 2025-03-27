package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import java.util.HashMap;
import java.util.UUID;

public class ModSupportLoadSecModsProcedure {
    private static final HashMap<UUID, Boolean> playerToggleMap = new HashMap<>();

    public static void execute(Entity entity) {
        if (entity == null)
            return;

        if (getEntityGameType(entity) == GameType.CREATIVE) {
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("CMD executed!"), false);

            Entity _ent = entity;
            if (!_ent.level().isClientSide() && _ent.getServer() != null) {

                UUID playerUUID = _ent.getUUID();
                boolean currentState = playerToggleMap.getOrDefault(playerUUID, false);


                boolean newState = !currentState;
                playerToggleMap.put(playerUUID, newState);

                String logicParam = newState ? "true" : "false";
                _ent.getServer().getCommands().performPrefixedCommand(
                    new CommandSourceStack(
                        CommandSource.NULL,
                        _ent.position(),
                        _ent.getRotationVector(),
                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                        4,
                        _ent.getName().getString(),
                        _ent.getDisplayName(),
                        _ent.level().getServer(),
                        _ent
                    ),
                    "aow_loadSecMods " + logicParam
                );
            }
        } else {
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("CMD not executed! Client needs to be in creative mode. Please change your game mode."), false);
        }
    }

    private static GameType getEntityGameType(Entity entity) {
        if (entity instanceof ServerPlayer serverPlayer) {
            return serverPlayer.gameMode.getGameModeForPlayer();
        } else if (entity instanceof Player player && player.level().isClientSide()) {
            PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
            if (playerInfo != null)
                return playerInfo.getGameMode();
        }
        return null;
    }
}