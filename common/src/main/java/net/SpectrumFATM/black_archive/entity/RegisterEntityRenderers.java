package net.SpectrumFATM.black_archive.entity;

import net.SpectrumFATM.black_archive.entity.client.*;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import static net.SpectrumFATM.black_archive.entity.ModEntityRegistry.*;

public class RegisterEntityRenderers {

    public static void registerRenderers() {
        // Register entity renderers
        EntityRendererRegistry.register(DALEK.get(), DalekRenderer::new);
        EntityRendererRegistry.register(LASER.get(), LaserRenderer::new);
        EntityRendererRegistry.register(DALEK_PUPPET.get(), DalekPuppetRenderer::new);
        EntityRendererRegistry.register(CYBERMAN.get(), CybermanRenderer::new);
        EntityRendererRegistry.register(CYBERMAT.get(), CybermatRenderer::new);
        EntityRendererRegistry.register(TIME_FISSURE.get(), TimeFissureRenderer::new);

        // Register model layers
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DALEK_SLAVE, DalekPuppetModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DALEK, DalekModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CYBERMAN, CybermanModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CYBERMAT, CybermatModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TIME_FISSURE, TimeFissureModel::getTexturedModelData);
    }

}
