package net.bcm.arcanumofwisdom.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class HolySpellWennEffektStartetangewendetWirdProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Mob _entity) {
			_entity.setTarget(null);
		}
		if (entity instanceof Mob _mob) {
			_mob.setNoAi(true);
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 5, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40, 5, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 5, false, false));
		if (entity instanceof LivingEntity _entity) {
			DamageSource _dmgsource = new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRAGON_BREATH));
			_entity.hurt(new DamageSource(_dmgsource.typeHolder(), _dmgsource.getEntity(), _dmgsource.getDirectEntity()) {
				@Override
				public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
					String _translatekey = "death.attack.holy_branch_ult";
					if (this.getEntity() == null && this.getDirectEntity() == null) {
						return _msgEntity.getKillCredit() != null
								? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
								: Component.translatable(_translatekey, _msgEntity.getDisplayName());
					} else {
						Component _component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
						ItemStack _itemstack = ItemStack.EMPTY;
						if (this.getEntity() instanceof LivingEntity _livingentity)
							_itemstack = _livingentity.getMainHandItem();
						return !_itemstack.isEmpty() && _itemstack.hasCustomHoverName()
								? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
								: Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
					}
				}
			}, 2);
		}
		ArcanumOfWisdomMod.queueServerWork(20, () -> {
			if (entity instanceof LivingEntity _entity) {
				DamageSource _dmgsource = new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRAGON_BREATH));
				_entity.hurt(new DamageSource(_dmgsource.typeHolder(), _dmgsource.getEntity(), _dmgsource.getDirectEntity()) {
					@Override
					public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
						String _translatekey = "death.attack.holy_branch_ult";
						if (this.getEntity() == null && this.getDirectEntity() == null) {
							return _msgEntity.getKillCredit() != null
									? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
									: Component.translatable(_translatekey, _msgEntity.getDisplayName());
						} else {
							Component _component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
							ItemStack _itemstack = ItemStack.EMPTY;
							if (this.getEntity() instanceof LivingEntity _livingentity)
								_itemstack = _livingentity.getMainHandItem();
							return !_itemstack.isEmpty() && _itemstack.hasCustomHoverName()
									? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
									: Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
						}
					}
				}, 2);
			}
			ArcanumOfWisdomMod.queueServerWork(20, () -> {
				if (entity instanceof LivingEntity _entity) {
					DamageSource _dmgsource = new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRAGON_BREATH));
					_entity.hurt(new DamageSource(_dmgsource.typeHolder(), _dmgsource.getEntity(), _dmgsource.getDirectEntity()) {
						@Override
						public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
							String _translatekey = "death.attack.holy_branch_ult";
							if (this.getEntity() == null && this.getDirectEntity() == null) {
								return _msgEntity.getKillCredit() != null
										? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
										: Component.translatable(_translatekey, _msgEntity.getDisplayName());
							} else {
								Component _component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
								ItemStack _itemstack = ItemStack.EMPTY;
								if (this.getEntity() instanceof LivingEntity _livingentity)
									_itemstack = _livingentity.getMainHandItem();
								return !_itemstack.isEmpty() && _itemstack.hasCustomHoverName()
										? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
										: Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
							}
						}
					}, 2);
				}
				ArcanumOfWisdomMod.queueServerWork(20, () -> {
					if (entity instanceof LivingEntity _entity) {
						DamageSource _dmgsource = new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRAGON_BREATH));
						_entity.hurt(new DamageSource(_dmgsource.typeHolder(), _dmgsource.getEntity(), _dmgsource.getDirectEntity()) {
							@Override
							public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
								String _translatekey = "death.attack.holy_branch_ult";
								if (this.getEntity() == null && this.getDirectEntity() == null) {
									return _msgEntity.getKillCredit() != null
											? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
											: Component.translatable(_translatekey, _msgEntity.getDisplayName());
								} else {
									Component _component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
									ItemStack _itemstack = ItemStack.EMPTY;
									if (this.getEntity() instanceof LivingEntity _livingentity)
										_itemstack = _livingentity.getMainHandItem();
									return !_itemstack.isEmpty() && _itemstack.hasCustomHoverName()
											? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
											: Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
								}
							}
						}, 2);
					}
				});
			});
		});
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("ambient.cave")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("ambient.cave")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.activate")), SoundSource.PLAYERS, 2, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.activate")), SoundSource.PLAYERS, 2, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.activate")), SoundSource.PLAYERS, 2, (float) 0.4);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.activate")), SoundSource.PLAYERS, 2, (float) 0.4, false);
			}
		}
	}
}
