
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

import net.bcm.arcanumofwisdom.world.inventory.AltarOfTheAlchemistGUIMenu;
import net.bcm.arcanumofwisdom.procedures.OpenAltarOfTheAlchemistPotionsGUIProcedure;
import net.bcm.arcanumofwisdom.procedures.OpenAltarOfTheAlchemistBookGUIProcedure;
import net.bcm.arcanumofwisdom.procedures.CloseGUIsProcedure;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record AltarOfTheAlchemistGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<AltarOfTheAlchemistGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ArcanumOfWisdomMod.MODID, "altar_of_the_alchemist_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AltarOfTheAlchemistGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AltarOfTheAlchemistGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new AltarOfTheAlchemistGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<AltarOfTheAlchemistGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final AltarOfTheAlchemistGUIButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = AltarOfTheAlchemistGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenAltarOfTheAlchemistBookGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenAltarOfTheAlchemistPotionsGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			CloseGUIsProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ArcanumOfWisdomMod.addNetworkMessage(AltarOfTheAlchemistGUIButtonMessage.TYPE, AltarOfTheAlchemistGUIButtonMessage.STREAM_CODEC, AltarOfTheAlchemistGUIButtonMessage::handleData);
	}
}
