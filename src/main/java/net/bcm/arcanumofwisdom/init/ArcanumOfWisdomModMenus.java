
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
import net.bcm.arcanumofwisdom.world.inventory.AOWSettingsGUIMenu;
import net.bcm.arcanumofwisdom.ArcanumOfWisdomMod;

public class ArcanumOfWisdomModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, ArcanumOfWisdomMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<SkillTreeMenu>> SKILL_TREE = REGISTRY.register("skill_tree", () -> IMenuTypeExtension.create(SkillTreeMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AOWSettingsGUIMenu>> AOW_SETTINGS_GUI = REGISTRY.register("aow_settings_gui", () -> IMenuTypeExtension.create(AOWSettingsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LVLEffectsGUIMenu>> LVL_EFFECTS_GUI = REGISTRY.register("lvl_effects_gui", () -> IMenuTypeExtension.create(LVLEffectsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ButtonsGUIMenu>> BUTTONS_GUI = REGISTRY.register("buttons_gui", () -> IMenuTypeExtension.create(ButtonsGUIMenu::new));
}
