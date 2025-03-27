
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

import net.bcm.arcanumofwisdom.world.inventory.BAWGUIBlocksMenu;
import net.bcm.arcanumofwisdom.procedures.OpenBAWGUILabTableProcedure;
import net.bcm.arcanumofwisdom.procedures.OpenBAWGUIAotaProcedure;
import net.bcm.arcanumofwisdom.procedures.OpenBAWGUIACTProcedure;
import net.bcm.arcanumofwisdom.procedures.CloseBAWGUIProcedure;
import net.bcm.arcanumofwisdom.procedures.BAWBackToMenuPProcedure;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record BAWGUIBlocksButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<BAWGUIBlocksButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "bawgui_blocks_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, BAWGUIBlocksButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, BAWGUIBlocksButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new BAWGUIBlocksButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<BAWGUIBlocksButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final BAWGUIBlocksButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = BAWGUIBlocksMenu.guistate;
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

			OpenBAWGUILabTableProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenBAWGUIACTProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenBAWGUIAotaProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ArcanumOfWisdomMod.addNetworkMessage(BAWGUIBlocksButtonMessage.TYPE, BAWGUIBlocksButtonMessage.STREAM_CODEC, BAWGUIBlocksButtonMessage::handleData);
	}
}
