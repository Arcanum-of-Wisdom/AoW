
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.bcm.arcanumofwisdom.client.gui.SkillTreeScreen;
import net.bcm.arcanumofwisdom.client.gui.LVLEffectsGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.ButtonsGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIWisdomScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIWisdom2Screen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIModSupportScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIMenuScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUILabTableScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUILabTable2Screen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIItemsScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIItems5Screen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIItems4Screen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIItems3Screen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIItems2Screen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUICreditsScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIBlocksScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIArtifactsScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIArtifactsHTGAScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIArtifacts5Screen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIArtifacts4Screen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIArtifacts3Screen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIArtifacts2Screen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIArcanaScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIArcanaHowToEnterTheADScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIAotaScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIAota3Screen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIAota2Screen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIACTScreen;
import net.bcm.arcanumofwisdom.client.gui.BAWGUIACT2Screen;
import net.bcm.arcanumofwisdom.client.gui.ArtifactlaboratorytableguiScreen;
import net.bcm.arcanumofwisdom.client.gui.ArtifactcraftingtableGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.ArtifactOfDimensionsGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.ArtifactOfDeformationGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.AotaDecryptingGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.AltarOfTheAlchemistPotionsGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.AltarOfTheAlchemistGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.AltarOfTheAlchemistBookGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.AdjustableBottleOfEnchantingGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.AOWSettingsGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.ALTResearchGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.ALTExtractGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.ALTDestroyGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.ALTCombineGUIScreen;
import net.bcm.arcanumofwisdom.client.gui.ACTExtendedResearchGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
		event.register(ArcanumOfWisdomModMenus.ALT_EXTRACT_GUI.get(), ALTExtractGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.ALT_DESTROY_GUI.get(), ALTDestroyGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_MENU.get(), BAWGUIMenuScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_ARCANA.get(), BAWGUIArcanaScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_ARCANA_HOW_TO_ENTER_THE_AD.get(), BAWGUIArcanaHowToEnterTheADScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_LAB_TABLE.get(), BAWGUILabTableScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_LAB_TABLE_2.get(), BAWGUILabTable2Screen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_WISDOM.get(), BAWGUIWisdomScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_ARTIFACTS.get(), BAWGUIArtifactsScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_WISDOM_2.get(), BAWGUIWisdom2Screen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_ITEMS.get(), BAWGUIItemsScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_ARTIFACTS_2.get(), BAWGUIArtifacts2Screen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_ARTIFACTS_3.get(), BAWGUIArtifacts3Screen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_ARTIFACTS_4.get(), BAWGUIArtifacts4Screen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_ARTIFACTS_HTGA.get(), BAWGUIArtifactsHTGAScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_ITEMS_2.get(), BAWGUIItems2Screen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_ITEMS_3.get(), BAWGUIItems3Screen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_ITEMS_4.get(), BAWGUIItems4Screen::new);
		event.register(ArcanumOfWisdomModMenus.ARTIFACTCRAFTINGTABLE_GUI.get(), ArtifactcraftingtableGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.ACT_EXTENDED_RESEARCH_GUI.get(), ACTExtendedResearchGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUIACT.get(), BAWGUIACTScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUIACT_2.get(), BAWGUIACT2Screen::new);
		event.register(ArcanumOfWisdomModMenus.ALTAR_OF_THE_ALCHEMIST_GUI.get(), AltarOfTheAlchemistGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.ALTAR_OF_THE_ALCHEMIST_BOOK_GUI.get(), AltarOfTheAlchemistBookGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.ALTAR_OF_THE_ALCHEMIST_POTIONS_GUI.get(), AltarOfTheAlchemistPotionsGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.ARTIFACT_OF_DEFORMATION_GUI.get(), ArtifactOfDeformationGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_ARTIFACTS_5.get(), BAWGUIArtifacts5Screen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_AOTA.get(), BAWGUIAotaScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_BLOCKS.get(), BAWGUIBlocksScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_AOTA_2.get(), BAWGUIAota2Screen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_AOTA_3.get(), BAWGUIAota3Screen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_MOD_SUPPORT.get(), BAWGUIModSupportScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_CREDITS.get(), BAWGUICreditsScreen::new);
		event.register(ArcanumOfWisdomModMenus.ADJUSTABLE_BOTTLE_OF_ENCHANTING_GUI.get(), AdjustableBottleOfEnchantingGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.AOTA_DECRYPTING_GUI.get(), AotaDecryptingGUIScreen::new);
		event.register(ArcanumOfWisdomModMenus.BAWGUI_ITEMS_5.get(), BAWGUIItems5Screen::new);
	}
}
