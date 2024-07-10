
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
import net.bcm.arcanumofwisdom.client.gui.ArtifactlaboratorytableguiScreen;
import net.bcm.arcanumofwisdom.client.gui.ArtifactOfDimensionsGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.AOWSettingsGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.ALTResearchGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.ALTCombineGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ArcanumOfWisdomModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(ArcanumOfWisdomModMenus.SKILL_TREE.get(), SkillTreeScreen::new);
		event.register(ArcanumOfWisdomModMenus.AOW_SETTINGS_GUI.get(), AOWSettingsGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.LVL_EFFECTS_GUI.get(), LVLEffectsGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.BUTTONS_GUI.get(), ButtonsGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.ARTIFACTLABORATORYTABLEGUI.get(), ArtifactlaboratorytableguiScreen::new);
		event.register(ArcanumOfWisdomModMenus.ALT_RESEARCH_GUI.get(), ALTResearchGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.ALT_COMBINE_GUI.get(), ALTCombineGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.ARTIFACT_OF_DIMENSIONS_GUI.get(), ArtifactOfDimensionsGUIScreen::new);
	}
}
