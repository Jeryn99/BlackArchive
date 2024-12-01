package net.SpectrumFATM.black_archive;

import net.SpectrumFATM.black_archive.config.BlackArchiveConfig;
import net.SpectrumFATM.black_archive.entity.RegisterEntityRenderers;
import net.SpectrumFATM.black_archive.entity.features.BraceletFeatureRenderer;
import net.SpectrumFATM.black_archive.network.NetworkPackets;
import net.SpectrumFATM.black_archive.renderer.TardisWarningRenderer;
import net.SpectrumFATM.black_archive.renderer.VortexSkyRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class BlackArchiveClient {


    public static void onInitializeClient() {
        NetworkPackets.registerClientSidePackets();
        TardisWarningRenderer.register();
        RegisterEntityRenderers.registerRenderers();
        if (BlackArchiveConfig.CLIENT.shouldTimeVortexRender.get()) {
            DimensionRenderingRegistry.registerSkyRenderer(RegistryKey.of(RegistryKey.ofRegistry(new Identifier("minecraft", "dimension")), new Identifier(BlackArchive.MOD_ID, "time_vortex")), new VortexSkyRenderer());
        }

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer instanceof PlayerEntityRenderer) {
                registrationHelper.register(new BraceletFeatureRenderer((FeatureRendererContext<PlayerEntity, PlayerEntityModel<PlayerEntity>>) entityRenderer));
            }
        });
    }

}