
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.bcm.arcanumofwisdom.client.gui.SkillTreeScreen;
import net.bcm.arcanumofwisdom.client.gui.LVLEffectsGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.ButtonsGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.AOWSettingsGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ArcanumOfWisdomModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(ArcanumOfWisdomModMenus.SKILL_TREE.get(), SkillTreeScreen::new);
		event.register(ArcanumOfWisdomModMenus.AOW_SETTINGS_GUI.get(), AOWSettingsGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.LVL_EFFECTS_GUI.get(), LVLEffectsGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.BUTTONS_GUI.get(), ButtonsGUIScreen::new);
	}
}
