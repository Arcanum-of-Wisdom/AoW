
package net.bcm.arcanumofwisdom.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.bcm.arcanumofwisdom.world.inventory.ArtifactOfDimensionsGUIMenu;
import net.bcm.arcanumofwisdom.procedures.ArtifactOfDimensionsOverworldTravelProcedure;
import net.bcm.arcanumofwisdom.procedures.ArtifactOfDimensionsNetherTravelProcedure;
import net.bcm.arcanumofwisdom.procedures.ArtifactOfDimensionsEndTravelProcedure;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record ArtifactOfDimensionsGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<ArtifactOfDimensionsGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "artifact_of_dimensions_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ArtifactOfDimensionsGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ArtifactOfDimensionsGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ArtifactOfDimensionsGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<ArtifactOfDimensionsGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ArtifactOfDimensionsGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = ArtifactOfDimensionsGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ArtifactOfDimensionsNetherTravelProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ArtifactOfDimensionsEndTravelProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ArtifactOfDimensionsOverworldTravelProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ArcanumOfWisdomMod.addNetworkMessage(ArtifactOfDimensionsGUIButtonMessage.TYPE, ArtifactOfDimensionsGUIButtonMessage.STREAM_CODEC, ArtifactOfDimensionsGUIButtonMessage::handleData);
	}
}
