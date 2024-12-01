package net.SpectrumFATM.black_archive.fabric;

import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.SpectrumFATM.black_archive.BlackArchive;
import net.fabricmc.api.ModInitializer;
import net.minecraftforge.fml.config.ModConfig;

import static net.SpectrumFATM.black_archive.config.BlackArchiveConfig.CLIENT_SPEC;
import static net.SpectrumFATM.black_archive.config.BlackArchiveConfig.COMMON_SPEC;

public class BlackArchiveFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BlackArchive.onInitialize();
        registerConfig();
    }

    public static void registerConfig() {
        ForgeConfigRegistry.INSTANCE.register("black_archive", ModConfig.Type.COMMON, COMMON_SPEC);
        ForgeConfigRegistry.INSTANCE.register("black_archive", ModConfig.Type.CLIENT, CLIENT_SPEC);
    }
}
