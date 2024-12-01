package net.SpectrumFATM.black_archive.network;

import net.SpectrumFATM.black_archive.BlackArchive;
import net.minecraft.util.Identifier;
import whocraft.tardis_refined.common.network.NetworkManager;

public class BlackArchiveNetwork {

    public static final NetworkManager NETWORK = NetworkManager.create(new Identifier(BlackArchive.MOD_ID, "channel"));

    public static void init() {
        
    }
}
