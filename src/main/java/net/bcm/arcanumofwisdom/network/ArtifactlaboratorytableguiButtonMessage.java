
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

import net.bcm.arcanumofwisdom.world.inventory.ArtifactlaboratorytableguiMenu;
import net.bcm.arcanumofwisdom.procedures.OpenALTExtractGUIProcedure;
import net.bcm.arcanumofwisdom.procedures.OpenALTDestroyGUIProcedure;
import net.bcm.arcanumofwisdom.procedures.CloseGUIsProcedure;
import net.bcm.arcanumofwisdom.procedures.ALTCombineGUIPProcedure;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record ArtifactlaboratorytableguiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<ArtifactlaboratorytableguiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "artifactlaboratorytablegui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ArtifactlaboratorytableguiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ArtifactlaboratorytableguiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ArtifactlaboratorytableguiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<ArtifactlaboratorytableguiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ArtifactlaboratorytableguiButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = ArtifactlaboratorytableguiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CloseGUIsProcedure.execute(entity);
		}
		if (buttonID == 1) {

			ALTCombineGUIPProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenALTDestroyGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenALTExtractGUIProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ArcanumOfWisdomMod.addNetworkMessage(ArtifactlaboratorytableguiButtonMessage.TYPE, ArtifactlaboratorytableguiButtonMessage.STREAM_CODEC, ArtifactlaboratorytableguiButtonMessage::handleData);
	}
}
