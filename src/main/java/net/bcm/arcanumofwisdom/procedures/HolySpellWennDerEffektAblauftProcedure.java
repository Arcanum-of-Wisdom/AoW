package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class HolySpellWennDerEffektAblauftProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 1, 0, 0, 0, 1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 20, 0, 0, 0, 0.5);
		if (entity instanceof Mob _mob) {
			_mob.setNoAi(false);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.bubble_column.bubble_pop")), SoundSource.PLAYERS, 2, (float) 0.8);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.bubble_column.bubble_pop")), SoundSource.PLAYERS, 2, (float) 0.8, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.deactivate")), SoundSource.PLAYERS, 2, (float) 0.4);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.deactivate")), SoundSource.PLAYERS, 2, (float) 0.4, false);
			}
		}
	}
}
