package net.SpectrumFATM.forge;

import net.SpectrumFATM.black_archive.BlackArchive;
import net.minecraftforge.fml.common.Mod;

@Mod(BlackArchive.MOD_ID)
public final class BlackArchiveForge {

    public BlackArchiveForge() {
        BlackArchive.onInitialize();
    }
}
