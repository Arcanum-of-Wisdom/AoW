package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.bcm.arcanumofwisdom.init.ArcanumOfWisdomModItems;

import java.util.function.Supplier;
import java.util.Map;

public class AotaDecryptingGUIWorkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randomizer = 0;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Items.PAPER) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == Items.INK_SAC) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Items.FEATHER) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
							.getItem() == ArcanumOfWisdomModItems.ENCRYPTED_ALCHEMY_BOOK.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.tendril_clicks")), SoundSource.PLAYERS, (float) 0.5, 2);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.tendril_clicks")), SoundSource.PLAYERS, (float) 0.5, 2, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.in")), SoundSource.PLAYERS, (float) 0.5, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.in")), SoundSource.PLAYERS, (float) 0.5, 1, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.challenge_complete")), SoundSource.PLAYERS, (float) 0.5, (float) 1.8);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.challenge_complete")), SoundSource.PLAYERS, (float) 0.5, (float) 1.8, false);
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(0)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(1)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(2)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get(3)).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						randomizer = 0;
						randomizer = Mth.nextInt(RandomSource.create(), 1, 10);
						if (randomizer == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(Blocks.COBWEB).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(4)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (randomizer == 2) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(Blocks.TORCHFLOWER).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(4)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (randomizer == 3) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(4)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (randomizer == 4) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(Items.COOKED_BEEF).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(4)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (randomizer == 5) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(Blocks.PITCHER_PLANT).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(4)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (randomizer == 6) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(Items.ENDER_EYE).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(4)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (randomizer == 7) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(Items.IRON_INGOT).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(4)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (randomizer == 8) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(Items.IRON_PICKAXE).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(4)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (randomizer == 9) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(Items.BLAZE_ROD).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(4)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (randomizer == 10) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(Items.LAVA_BUCKET).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(4)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					} else {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.tendril_clicks")), SoundSource.PLAYERS, (float) 0.5, 2);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.tendril_clicks")), SoundSource.PLAYERS, (float) 0.5, 2, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.out")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.out")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You need at least one encrypted alchemy book!"), false);
					}
				} else {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.tendril_clicks")), SoundSource.PLAYERS, (float) 0.5, 2);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.tendril_clicks")), SoundSource.PLAYERS, (float) 0.5, 2, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.out")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.out")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You need at least one feather!"), false);
				}
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.tendril_clicks")), SoundSource.PLAYERS, (float) 0.5, 2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.tendril_clicks")), SoundSource.PLAYERS, (float) 0.5, 2, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.out")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.out")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You need at least one ink sac!"), false);
			}
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.tendril_clicks")), SoundSource.PLAYERS, (float) 0.5, 2);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.tendril_clicks")), SoundSource.PLAYERS, (float) 0.5, 2, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.out")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.out")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5, false);
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You need at least one paper!"), false);
		}
	}
}
