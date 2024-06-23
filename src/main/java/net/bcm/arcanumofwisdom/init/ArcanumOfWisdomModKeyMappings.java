
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.bcm.arcanumofwisdom.network.TalentUebersichtMessage;
import net.bcm.arcanumofwisdom.network.ShadowPowerKeyMessage;
import net.bcm.arcanumofwisdom.network.HolyBranchUltAbilityMessage;
import net.bcm.arcanumofwisdom.network.HolyBranchSecAbilityMessage;
import net.bcm.arcanumofwisdom.network.EinstellungenMessage;
import net.bcm.arcanumofwisdom.network.ArcanaDimensionEnterMessage;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ArcanumOfWisdomModKeyMappings {
	public static final KeyMapping TALENT_UEBERSICHT = new KeyMapping("key.arcanum_of_wisdom.talent_uebersicht", GLFW.GLFW_KEY_X, "key.categories.aow") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.SERVER.noArg().send(new TalentUebersichtMessage(0, 0));
				TalentUebersichtMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping EINSTELLUNGEN = new KeyMapping("key.arcanum_of_wisdom.einstellungen", GLFW.GLFW_KEY_G, "key.categories.aow") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.SERVER.noArg().send(new EinstellungenMessage(0, 0));
				EinstellungenMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping HOLY_BRANCH_SEC_ABILITY = new KeyMapping("key.arcanum_of_wisdom.holy_branch_sec_ability", GLFW.GLFW_KEY_C, "key.categories.aow") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.SERVER.noArg().send(new HolyBranchSecAbilityMessage(0, 0));
				HolyBranchSecAbilityMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping HOLY_BRANCH_ULT_ABILITY = new KeyMapping("key.arcanum_of_wisdom.holy_branch_ult_ability", GLFW.GLFW_KEY_V, "key.categories.aow") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.SERVER.noArg().send(new HolyBranchUltAbilityMessage(0, 0));
				HolyBranchUltAbilityMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SHADOW_POWER_KEY = new KeyMapping("key.arcanum_of_wisdom.shadow_power_key", GLFW.GLFW_KEY_B, "key.categories.aow") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.SERVER.noArg().send(new ShadowPowerKeyMessage(0, 0));
				ShadowPowerKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ARCANA_DIMENSION_ENTER = new KeyMapping("key.arcanum_of_wisdom.arcana_dimension_enter", GLFW.GLFW_KEY_N, "key.categories.aow") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.SERVER.noArg().send(new ArcanaDimensionEnterMessage(0, 0));
				ArcanaDimensionEnterMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(TALENT_UEBERSICHT);
		event.register(EINSTELLUNGEN);
		event.register(HOLY_BRANCH_SEC_ABILITY);
		event.register(HOLY_BRANCH_ULT_ABILITY);
		event.register(SHADOW_POWER_KEY);
		event.register(ARCANA_DIMENSION_ENTER);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				TALENT_UEBERSICHT.consumeClick();
				EINSTELLUNGEN.consumeClick();
				HOLY_BRANCH_SEC_ABILITY.consumeClick();
				HOLY_BRANCH_ULT_ABILITY.consumeClick();
				SHADOW_POWER_KEY.consumeClick();
				ARCANA_DIMENSION_ENTER.consumeClick();
			}
		}
	}
}
