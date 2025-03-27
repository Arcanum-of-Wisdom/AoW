
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.bcm.arcanumofwisdom.world.inventory.SkillTreeMenu;
import net.bcm.arcanumofwisdom.world.inventory.LVLEffectsGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.ButtonsGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIWisdomMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIWisdom2Menu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIModSupportMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIMenuMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUILabTableMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUILabTable2Menu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIItemsMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIItems5Menu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIItems4Menu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIItems3Menu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIItems2Menu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUICreditsMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIBlocksMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIArtifactsMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIArtifactsHTGAMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIArtifacts5Menu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIArtifacts4Menu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIArtifacts3Menu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIArtifacts2Menu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIArcanaMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIArcanaHowToEnterTheADMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIAotaMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIAota3Menu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIAota2Menu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIACTMenu;
import net.bcm.arcanumofwisdom.world.inventory.BAWGUIACT2Menu;
import net.bcm.arcanumofwisdom.world.inventory.ArtifactlaboratorytableguiMenu;
import net.bcm.arcanumofwisdom.world.inventory.ArtifactcraftingtableGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.ArtifactOfDimensionsGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.ArtifactOfDeformationGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.AotaDecryptingGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.AltarOfTheAlchemistPotionsGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.AltarOfTheAlchemistGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.AltarOfTheAlchemistBookGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.AdjustableBottleOfEnchantingGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.AOWSettingsGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.ALTResearchGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.ALTExtractGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.ALTDestroyGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.ALTCombineGUIMenu;
import net.bcm.arcanumofwisdom.world.inventory.ACTExtendedResearchGUIMenu;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class ArcanumOfWisdomModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, ArcanumOfWisdomMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<SkillTreeMenu>> SKILL_TREE = REGISTRY.register("skill_tree", () -> IMenuTypeExtension.create(SkillTreeMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AOWSettingsGUIMenu>> AOW_SETTINGS_GUI = REGISTRY.register("aow_settings_gui", () -> IMenuTypeExtension.create(AOWSettingsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LVLEffectsGUIMenu>> LVL_EFFECTS_GUI = REGISTRY.register("lvl_effects_gui", () -> IMenuTypeExtension.create(LVLEffectsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ButtonsGUIMenu>> BUTTONS_GUI = REGISTRY.register("buttons_gui", () -> IMenuTypeExtension.create(ButtonsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ArtifactlaboratorytableguiMenu>> ARTIFACTLABORATORYTABLEGUI = REGISTRY.register("artifactlaboratorytablegui", () -> IMenuTypeExtension.create(ArtifactlaboratorytableguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ALTResearchGUIMenu>> ALT_RESEARCH_GUI = REGISTRY.register("alt_research_gui", () -> IMenuTypeExtension.create(ALTResearchGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ALTCombineGUIMenu>> ALT_COMBINE_GUI = REGISTRY.register("alt_combine_gui", () -> IMenuTypeExtension.create(ALTCombineGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ArtifactOfDimensionsGUIMenu>> ARTIFACT_OF_DIMENSIONS_GUI = REGISTRY.register("artifact_of_dimensions_gui", () -> IMenuTypeExtension.create(ArtifactOfDimensionsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ALTExtractGUIMenu>> ALT_EXTRACT_GUI = REGISTRY.register("alt_extract_gui", () -> IMenuTypeExtension.create(ALTExtractGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ALTDestroyGUIMenu>> ALT_DESTROY_GUI = REGISTRY.register("alt_destroy_gui", () -> IMenuTypeExtension.create(ALTDestroyGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIMenuMenu>> BAWGUI_MENU = REGISTRY.register("bawgui_menu", () -> IMenuTypeExtension.create(BAWGUIMenuMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIArcanaMenu>> BAWGUI_ARCANA = REGISTRY.register("bawgui_arcana", () -> IMenuTypeExtension.create(BAWGUIArcanaMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIArcanaHowToEnterTheADMenu>> BAWGUI_ARCANA_HOW_TO_ENTER_THE_AD = REGISTRY.register("bawgui_arcana_how_to_enter_the_ad",
			() -> IMenuTypeExtension.create(BAWGUIArcanaHowToEnterTheADMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUILabTableMenu>> BAWGUI_LAB_TABLE = REGISTRY.register("bawgui_lab_table", () -> IMenuTypeExtension.create(BAWGUILabTableMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUILabTable2Menu>> BAWGUI_LAB_TABLE_2 = REGISTRY.register("bawgui_lab_table_2", () -> IMenuTypeExtension.create(BAWGUILabTable2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIWisdomMenu>> BAWGUI_WISDOM = REGISTRY.register("bawgui_wisdom", () -> IMenuTypeExtension.create(BAWGUIWisdomMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIArtifactsMenu>> BAWGUI_ARTIFACTS = REGISTRY.register("bawgui_artifacts", () -> IMenuTypeExtension.create(BAWGUIArtifactsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIWisdom2Menu>> BAWGUI_WISDOM_2 = REGISTRY.register("bawgui_wisdom_2", () -> IMenuTypeExtension.create(BAWGUIWisdom2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIItemsMenu>> BAWGUI_ITEMS = REGISTRY.register("bawgui_items", () -> IMenuTypeExtension.create(BAWGUIItemsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIArtifacts2Menu>> BAWGUI_ARTIFACTS_2 = REGISTRY.register("bawgui_artifacts_2", () -> IMenuTypeExtension.create(BAWGUIArtifacts2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIArtifacts3Menu>> BAWGUI_ARTIFACTS_3 = REGISTRY.register("bawgui_artifacts_3", () -> IMenuTypeExtension.create(BAWGUIArtifacts3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIArtifacts4Menu>> BAWGUI_ARTIFACTS_4 = REGISTRY.register("bawgui_artifacts_4", () -> IMenuTypeExtension.create(BAWGUIArtifacts4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIArtifactsHTGAMenu>> BAWGUI_ARTIFACTS_HTGA = REGISTRY.register("bawgui_artifacts_htga", () -> IMenuTypeExtension.create(BAWGUIArtifactsHTGAMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIItems2Menu>> BAWGUI_ITEMS_2 = REGISTRY.register("bawgui_items_2", () -> IMenuTypeExtension.create(BAWGUIItems2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIItems3Menu>> BAWGUI_ITEMS_3 = REGISTRY.register("bawgui_items_3", () -> IMenuTypeExtension.create(BAWGUIItems3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIItems4Menu>> BAWGUI_ITEMS_4 = REGISTRY.register("bawgui_items_4", () -> IMenuTypeExtension.create(BAWGUIItems4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ArtifactcraftingtableGUIMenu>> ARTIFACTCRAFTINGTABLE_GUI = REGISTRY.register("artifactcraftingtable_gui", () -> IMenuTypeExtension.create(ArtifactcraftingtableGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ACTExtendedResearchGUIMenu>> ACT_EXTENDED_RESEARCH_GUI = REGISTRY.register("act_extended_research_gui", () -> IMenuTypeExtension.create(ACTExtendedResearchGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIACTMenu>> BAWGUIACT = REGISTRY.register("bawguiact", () -> IMenuTypeExtension.create(BAWGUIACTMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIACT2Menu>> BAWGUIACT_2 = REGISTRY.register("bawguiact_2", () -> IMenuTypeExtension.create(BAWGUIACT2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AltarOfTheAlchemistGUIMenu>> ALTAR_OF_THE_ALCHEMIST_GUI = REGISTRY.register("altar_of_the_alchemist_gui", () -> IMenuTypeExtension.create(AltarOfTheAlchemistGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AltarOfTheAlchemistBookGUIMenu>> ALTAR_OF_THE_ALCHEMIST_BOOK_GUI = REGISTRY.register("altar_of_the_alchemist_book_gui",
			() -> IMenuTypeExtension.create(AltarOfTheAlchemistBookGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AltarOfTheAlchemistPotionsGUIMenu>> ALTAR_OF_THE_ALCHEMIST_POTIONS_GUI = REGISTRY.register("altar_of_the_alchemist_potions_gui",
			() -> IMenuTypeExtension.create(AltarOfTheAlchemistPotionsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ArtifactOfDeformationGUIMenu>> ARTIFACT_OF_DEFORMATION_GUI = REGISTRY.register("artifact_of_deformation_gui", () -> IMenuTypeExtension.create(ArtifactOfDeformationGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIArtifacts5Menu>> BAWGUI_ARTIFACTS_5 = REGISTRY.register("bawgui_artifacts_5", () -> IMenuTypeExtension.create(BAWGUIArtifacts5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIAotaMenu>> BAWGUI_AOTA = REGISTRY.register("bawgui_aota", () -> IMenuTypeExtension.create(BAWGUIAotaMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIBlocksMenu>> BAWGUI_BLOCKS = REGISTRY.register("bawgui_blocks", () -> IMenuTypeExtension.create(BAWGUIBlocksMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIAota2Menu>> BAWGUI_AOTA_2 = REGISTRY.register("bawgui_aota_2", () -> IMenuTypeExtension.create(BAWGUIAota2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIAota3Menu>> BAWGUI_AOTA_3 = REGISTRY.register("bawgui_aota_3", () -> IMenuTypeExtension.create(BAWGUIAota3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIModSupportMenu>> BAWGUI_MOD_SUPPORT = REGISTRY.register("bawgui_mod_support", () -> IMenuTypeExtension.create(BAWGUIModSupportMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUICreditsMenu>> BAWGUI_CREDITS = REGISTRY.register("bawgui_credits", () -> IMenuTypeExtension.create(BAWGUICreditsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdjustableBottleOfEnchantingGUIMenu>> ADJUSTABLE_BOTTLE_OF_ENCHANTING_GUI = REGISTRY.register("adjustable_bottle_of_enchanting_gui",
			() -> IMenuTypeExtension.create(AdjustableBottleOfEnchantingGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AotaDecryptingGUIMenu>> AOTA_DECRYPTING_GUI = REGISTRY.register("aota_decrypting_gui", () -> IMenuTypeExtension.create(AotaDecryptingGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BAWGUIItems5Menu>> BAWGUI_ITEMS_5 = REGISTRY.register("bawgui_items_5", () -> IMenuTypeExtension.create(BAWGUIItems5Menu::new));
}
