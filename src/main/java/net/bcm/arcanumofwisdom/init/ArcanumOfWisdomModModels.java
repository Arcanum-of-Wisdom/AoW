
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.bcm.arcanumofwisdom.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.bcm.arcanumofwisdom.client.model.Modelarmormodel;
import net.bcm.arcanumofwisdom.client.model.ModelNAA_helmet_model;
import net.bcm.arcanumofwisdom.client.model.ModelNAA_chestplate_model;
import net.bcm.arcanumofwisdom.client.model.ModelNAALeggingsModel;
import net.bcm.arcanumofwisdom.client.model.ModelNAABootsModel;
import net.bcm.arcanumofwisdom.client.model.ModelCustomModel;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ArcanumOfWisdomModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelNAA_chestplate_model.LAYER_LOCATION, ModelNAA_chestplate_model::createBodyLayer);
		event.registerLayerDefinition(Modelarmormodel.LAYER_LOCATION, Modelarmormodel::createBodyLayer);
		event.registerLayerDefinition(ModelNAABootsModel.LAYER_LOCATION, ModelNAABootsModel::createBodyLayer);
		event.registerLayerDefinition(ModelCustomModel.LAYER_LOCATION, ModelCustomModel::createBodyLayer);
		event.registerLayerDefinition(ModelNAA_helmet_model.LAYER_LOCATION, ModelNAA_helmet_model::createBodyLayer);
		event.registerLayerDefinition(ModelNAALeggingsModel.LAYER_LOCATION, ModelNAALeggingsModel::createBodyLayer);
	}
}
