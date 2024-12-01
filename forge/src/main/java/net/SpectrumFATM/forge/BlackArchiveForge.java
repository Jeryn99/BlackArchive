package net.SpectrumFATM.forge;

import net.SpectrumFATM.black_archive.BlackArchive;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import static net.SpectrumFATM.black_archive.config.BlackArchiveConfig.CLIENT_SPEC;
import static net.SpectrumFATM.black_archive.config.BlackArchiveConfig.COMMON_SPEC;

@Mod(BlackArchive.MOD_ID)
public final class BlackArchiveForge {

    public BlackArchiveForge() {
        BlackArchive.onInitialize();
        registerConfig();
    }

    public static void registerConfig() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_SPEC);

    }
}
