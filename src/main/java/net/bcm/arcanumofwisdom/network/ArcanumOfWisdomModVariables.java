package net.bcm.arcanumofwisdom.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.Minecraft;

import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArcanumOfWisdomModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, ArcanumOfWisdomMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ArcanumOfWisdomMod.addNetworkMessage(PlayerVariablesSyncMessage.ID, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handleData);
	}

	@Mod.EventBusSubscriber
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
			if (!event.isWasDeath()) {
				clone.holybranch_secattack_cooldown = original.holybranch_secattack_cooldown;
				clone.holybranch_ultattack_cooldown = original.holybranch_ultattack_cooldown;
				clone.holybranch_ability_1 = original.holybranch_ability_1;
				clone.holybranch_ability_ult = original.holybranch_ability_ult;
				clone.shadowpower_active = original.shadowpower_active;
				clone.shadowpower_cooldown = original.shadowpower_cooldown;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
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

		@Override
		public CompoundTag serializeNBT() {
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
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
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
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.PLAYER.with(serverPlayer).send(new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final ResourceLocation ID = new ResourceLocation(ArcanumOfWisdomMod.MODID, "player_variables_sync");

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this(new PlayerVariables());
			this.data.deserializeNBT(buffer.readNbt());
		}

		@Override
		public void write(final FriendlyByteBuf buffer) {
			buffer.writeNbt(data.serializeNBT());
		}

		@Override
		public ResourceLocation id() {
			return ID;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final PlayPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.workHandler().submitAsync(() -> Minecraft.getInstance().player.getData(PLAYER_VARIABLES).deserializeNBT(message.data.serializeNBT())).exceptionally(e -> {
					context.packetHandler().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
