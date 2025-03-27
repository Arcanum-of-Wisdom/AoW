package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.entity.Entity;

public class RaidersElixirEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _entityTeam = entity;
			PlayerTeam _pt = _entityTeam.level().getScoreboard().getPlayerTeam("aow_raider_elixir");
			if (_pt != null)
				_entityTeam.level().getScoreboard().removePlayerFromTeam(_entityTeam.getStringUUID(), _pt);
		}
	}
}
