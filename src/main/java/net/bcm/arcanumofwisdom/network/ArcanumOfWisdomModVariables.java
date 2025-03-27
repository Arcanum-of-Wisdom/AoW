package net.bcm.arcanumofwisdom.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ArcanumOfWisdomModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, ArcanumOfWisdomMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());
	public static boolean startup_message_teaser = false;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ArcanumOfWisdomMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		ArcanumOfWisdomMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.wisdom = original.wisdom;
			clone.overlay = original.overlay;
			clone.waterracer_active = original.waterracer_active;
			clone.lavaracer_active = original.lavaracer_active;
			clone.shadowwarrior_active = original.shadowwarrior_active;
			clone.arcana_active = original.arcana_active;
			clone.lvleffects = original.lvleffects;
			clone.nighthunter_active = original.nighthunter_active;
			clone.startup_message = original.startup_message;
			clone.ALTCombineWork = original.ALTCombineWork;
			clone.PD_ElytraEnhancer = original.PD_ElytraEnhancer;
			clone.PD_RegenHP = original.PD_RegenHP;
			clone.PD_Totem = original.PD_Totem;
			clone.PD_InstantSat = original.PD_InstantSat;
			clone.PD_RegenSat = original.PD_RegenSat;
			clone.PD_InstantComeback = original.PD_InstantComeback;
			clone.PD_Armorbooster = original.PD_Armorbooster;
			clone.PD_MiningBooster = original.PD_MiningBooster;
			clone.PD_Fistbooster = original.PD_Fistbooster;
			clone.EncryptedAlchemyBookDecrypted = original.EncryptedAlchemyBookDecrypted;
			clone.PD_FistOfDoom = original.PD_FistOfDoom;
			if (!event.isWasDeath()) {
				clone.holybranch_secattack_cooldown = original.holybranch_secattack_cooldown;
				clone.holybranch_ultattack_cooldown = original.holybranch_ultattack_cooldown;
				clone.holybranch_ability_1 = original.holybranch_ability_1;
				clone.holybranch_ability_ult = original.holybranch_ability_ult;
				clone.shadowpower_active = original.shadowpower_active;
				clone.shadowpower_cooldown = original.shadowpower_cooldown;
				clone.NAS_Shield_Timer = original.NAS_Shield_Timer;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "arcanum_of_wisdom_worldvars";
		public boolean connect_mods = false;

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			connect_mods = nbt.getBoolean("connect_mods");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putBoolean("connect_mods", connect_mods);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof ServerLevel level)
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "arcanum_of_wisdom_mapvars";

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public double wisdom = 0.0;
		public boolean overlay = true;
		public double holybranch_secattack_cooldown = 0;
		public double holybranch_ultattack_cooldown = 0.0;
		public boolean holybranch_ability_1 = false;
		public boolean holybranch_ability_ult = false;
		public boolean shadowpower_active = false;
		public double shadowpower_cooldown = 0;
		public boolean waterracer_active = false;
		public boolean lavaracer_active = false;
		public boolean shadowwarrior_active = false;
		public boolean arcana_active = false;
		public boolean lvleffects = false;
		public boolean nighthunter_active = false;
		public boolean startup_message = false;
		public boolean ALTCombineWork = false;
		public double NAS_Shield_Timer = 0;
		public boolean PD_ElytraEnhancer = false;
		public boolean PD_RegenHP = false;
		public boolean PD_Totem = false;
		public boolean PD_InstantSat = false;
		public boolean PD_RegenSat = false;
		public boolean PD_InstantComeback = false;
		public boolean PD_Armorbooster = false;
		public boolean PD_MiningBooster = false;
		public boolean PD_Fistbooster = false;
		public boolean EncryptedAlchemyBookDecrypted = false;
		public boolean PD_FistOfDoom = false;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("wisdom", wisdom);
			nbt.putBoolean("overlay", overlay);
			nbt.putDouble("holybranch_secattack_cooldown", holybranch_secattack_cooldown);
			nbt.putDouble("holybranch_ultattack_cooldown", holybranch_ultattack_cooldown);
			nbt.putBoolean("holybranch_ability_1", holybranch_ability_1);
			nbt.putBoolean("holybranch_ability_ult", holybranch_ability_ult);
			nbt.putBoolean("shadowpower_active", shadowpower_active);
			nbt.putDouble("shadowpower_cooldown", shadowpower_cooldown);
			nbt.putBoolean("waterracer_active", waterracer_active);
			nbt.putBoolean("lavaracer_active", lavaracer_active);
			nbt.putBoolean("shadowwarrior_active", shadowwarrior_active);
			nbt.putBoolean("arcana_active", arcana_active);
			nbt.putBoolean("lvleffects", lvleffects);
			nbt.putBoolean("nighthunter_active", nighthunter_active);
			nbt.putBoolean("startup_message", startup_message);
			nbt.putBoolean("ALTCombineWork", ALTCombineWork);
			nbt.putDouble("NAS_Shield_Timer", NAS_Shield_Timer);
			nbt.putBoolean("PD_ElytraEnhancer", PD_ElytraEnhancer);
			nbt.putBoolean("PD_RegenHP", PD_RegenHP);
			nbt.putBoolean("PD_Totem", PD_Totem);
			nbt.putBoolean("PD_InstantSat", PD_InstantSat);
			nbt.putBoolean("PD_RegenSat", PD_RegenSat);
			nbt.putBoolean("PD_InstantComeback", PD_InstantComeback);
			nbt.putBoolean("PD_Armorbooster", PD_Armorbooster);
			nbt.putBoolean("PD_MiningBooster", PD_MiningBooster);
			nbt.putBoolean("PD_Fistbooster", PD_Fistbooster);
			nbt.putBoolean("EncryptedAlchemyBookDecrypted", EncryptedAlchemyBookDecrypted);
			nbt.putBoolean("PD_FistOfDoom", PD_FistOfDoom);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			wisdom = nbt.getDouble("wisdom");
			overlay = nbt.getBoolean("overlay");
			holybranch_secattack_cooldown = nbt.getDouble("holybranch_secattack_cooldown");
			holybranch_ultattack_cooldown = nbt.getDouble("holybranch_ultattack_cooldown");
			holybranch_ability_1 = nbt.getBoolean("holybranch_ability_1");
			holybranch_ability_ult = nbt.getBoolean("holybranch_ability_ult");
			shadowpower_active = nbt.getBoolean("shadowpower_active");
			shadowpower_cooldown = nbt.getDouble("shadowpower_cooldown");
			waterracer_active = nbt.getBoolean("waterracer_active");
			lavaracer_active = nbt.getBoolean("lavaracer_active");
			shadowwarrior_active = nbt.getBoolean("shadowwarrior_active");
			arcana_active = nbt.getBoolean("arcana_active");
			lvleffects = nbt.getBoolean("lvleffects");
			nighthunter_active = nbt.getBoolean("nighthunter_active");
			startup_message = nbt.getBoolean("startup_message");
			ALTCombineWork = nbt.getBoolean("ALTCombineWork");
			NAS_Shield_Timer = nbt.getDouble("NAS_Shield_Timer");
			PD_ElytraEnhancer = nbt.getBoolean("PD_ElytraEnhancer");
			PD_RegenHP = nbt.getBoolean("PD_RegenHP");
			PD_Totem = nbt.getBoolean("PD_Totem");
			PD_InstantSat = nbt.getBoolean("PD_InstantSat");
			PD_RegenSat = nbt.getBoolean("PD_RegenSat");
			PD_InstantComeback = nbt.getBoolean("PD_InstantComeback");
			PD_Armorbooster = nbt.getBoolean("PD_Armorbooster");
			PD_MiningBooster = nbt.getBoolean("PD_MiningBooster");
			PD_Fistbooster = nbt.getBoolean("PD_Fistbooster");
			EncryptedAlchemyBookDecrypted = nbt.getBoolean("EncryptedAlchemyBookDecrypted");
			PD_FistOfDoom = nbt.getBoolean("PD_FistOfDoom");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
