package net.SpectrumFATM.black_archive.network;

import net.SpectrumFATM.black_archive.screen.VortexScreen;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;
import net.SpectrumFATM.black_archive.BlackArchive;

import java.util.ArrayList;
import java.util.List;

public class AllowedDimensionsResponsePacket {
    public static final Identifier ID = new Identifier(BlackArchive.MOD_ID, "allowed_dimensions_response");

    public static void registerClient() {
        ClientPlayNetworking.registerGlobalReceiver(ID, (client, handler, buf, responseSender) -> {
            int size = buf.readInt();
            List<String> allowedDimensions = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                allowedDimensions.add(buf.readString(32767));
            }

            client.execute(() -> {
                BlackArchive.LOGGER.info("Allowed dimensions: " + allowedDimensions);
                if (client.currentScreen instanceof VortexScreen vortexScreen)  {
                    vortexScreen.setDimensions(allowedDimensions);
                }
            });
        });
    }
}