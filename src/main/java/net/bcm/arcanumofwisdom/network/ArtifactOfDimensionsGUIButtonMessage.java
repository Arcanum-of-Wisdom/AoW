
package net.bcm.arcanumofwisdom.network;

import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.bcm.arcanumofwisdom.world.inventory.ArtifactOfDimensionsGUIMenu;
import net.bcm.arcanumofwisdom.procedures.ArtifactOfDimensionsOverworldTravelProcedure;
import net.bcm.arcanumofwisdom.procedures.ArtifactOfDimensionsNetherTravelProcedure;
import net.bcm.arcanumofwisdom.procedures.ArtifactOfDimensionsEndTravelProcedure;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record ArtifactOfDimensionsGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final ResourceLocation ID = new ResourceLocation(ArcanumOfWisdomMod.MODID, "artifact_of_dimensions_gui_buttons");
	public ArtifactOfDimensionsGUIButtonMessage(FriendlyByteBuf buffer) {
		this(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
	}

	@Override
	public void write(final FriendlyByteBuf buffer) {
		buffer.writeInt(buttonID);
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
	}

	@Override
	public ResourceLocation id() {
		return ID;
	}

	public static void handleData(final ArtifactOfDimensionsGUIButtonMessage message, final PlayPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.workHandler().submitAsync(() -> {
				Player entity = context.player().get();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.packetHandler().disconnect(Component.literal(e.getMessage()));
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
		ArcanumOfWisdomMod.addNetworkMessage(ArtifactOfDimensionsGUIButtonMessage.ID, ArtifactOfDimensionsGUIButtonMessage::new, ArtifactOfDimensionsGUIButtonMessage::handleData);
	}
}
