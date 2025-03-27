
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

import net.bcm.arcanumofwisdom.world.inventory.BAWGUIItems2Menu;
import net.bcm.arcanumofwisdom.procedures.OpenBAWGUIItemsProcedure;
import net.bcm.arcanumofwisdom.procedures.CloseBAWGUIProcedure;
import net.bcm.arcanumofwisdom.procedures.BAWBackToMenuPProcedure;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record BAWGUIItems2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<BAWGUIItems2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "bawgui_items_2_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, BAWGUIItems2ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, BAWGUIItems2ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new BAWGUIItems2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<BAWGUIItems2ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final BAWGUIItems2ButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = BAWGUIItems2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CloseBAWGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			BAWBackToMenuPProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenBAWGUIItemsProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ArcanumOfWisdomMod.addNetworkMessage(BAWGUIItems2ButtonMessage.TYPE, BAWGUIItems2ButtonMessage.STREAM_CODEC, BAWGUIItems2ButtonMessage::handleData);
	}
}
