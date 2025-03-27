
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

import net.bcm.arcanumofwisdom.world.inventory.ArtifactOfDeformationGUIMenu;
import net.bcm.arcanumofwisdom.procedures.ArtifactOfDimensionsGUICloseProcedure;
import net.bcm.arcanumofwisdom.procedures.ArtifactOfDeformationGUIButtonXm12Procedure;
import net.bcm.arcanumofwisdom.procedures.ArtifactOfDeformationGUIButtonX15Procedure;
import net.bcm.arcanumofwisdom.procedures.ArtifactOfDeformationGUIButtonX12Procedure;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record ArtifactOfDeformationGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<ArtifactOfDeformationGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "artifact_of_deformation_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ArtifactOfDeformationGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ArtifactOfDeformationGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ArtifactOfDeformationGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<ArtifactOfDeformationGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ArtifactOfDeformationGUIButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = ArtifactOfDeformationGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ArtifactOfDimensionsGUICloseProcedure.execute(entity);
		}
		if (buttonID == 1) {

			ArtifactOfDeformationGUIButtonX12Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ArtifactOfDeformationGUIButtonXm12Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ArtifactOfDeformationGUIButtonX15Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ArtifactOfDeformationGUIButtonXm12Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ArcanumOfWisdomMod.addNetworkMessage(ArtifactOfDeformationGUIButtonMessage.TYPE, ArtifactOfDeformationGUIButtonMessage.STREAM_CODEC, ArtifactOfDeformationGUIButtonMessage::handleData);
	}
}
