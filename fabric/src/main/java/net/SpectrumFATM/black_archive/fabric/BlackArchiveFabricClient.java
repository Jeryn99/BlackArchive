package net.SpectrumFATM.black_archive.fabric;

import net.SpectrumFATM.black_archive.BlackArchiveClient;
import net.fabricmc.api.ClientModInitializer;

public class BlackArchiveFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlackArchiveClient.onInitializeClient();
    }
}
