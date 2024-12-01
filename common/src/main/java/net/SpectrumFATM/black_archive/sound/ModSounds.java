package net.SpectrumFATM.black_archive.sound;

import net.SpectrumFATM.black_archive.BlackArchive;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

public class ModSounds {

    public static final DeferredRegistry<SoundEvent> SOUNDS = DeferredRegistry.create(BlackArchive.MOD_ID, net.minecraft.registry.Registries.SOUND_EVENT.getKey());

    // SoundEvent definitions using RegistrySupplier
    public static final RegistrySupplier<SoundEvent> VORTEX_TP = setUpSound("vortex_teleport");
    public static final RegistrySupplier<SoundEvent> DALEK_LASER = setUpSound("dalek_laser");
    public static final RegistrySupplier<SoundEvent> DALEK_MALFUNCTION = setUpSound("dalek_laser_malfunction");
    public static final RegistrySupplier<SoundEvent> DALEK_MOVE = setUpSound("dalek_move");
    public static final RegistrySupplier<SoundEvent> CYBERMAN_STEP = setUpSound("cyberman_step");
    public static final RegistrySupplier<SoundEvent> CYBERMAN_GUN = setUpSound("cyberman_gun");
    public static final RegistrySupplier<SoundEvent> CYBERMAN_MALFUNCTION = setUpSound("cyberman_malfunction");
    public static final RegistrySupplier<SoundEvent> TARDIS_GROAN = setUpSound("tardis_groan");
    public static final RegistrySupplier<SoundEvent> TCE = setUpSound("tce");

    // This is similar to the structure in TRSoundRegistry
    private static RegistrySupplier<SoundEvent> setUpSound(String soundName) {
        SoundEvent sound = SoundEvent.of(new Identifier(BlackArchive.MOD_ID, soundName));
        return SOUNDS.register(soundName, () -> sound);
    }

    public static void registerSounds() {
        BlackArchive.LOGGER.info("Registering Sounds for " + BlackArchive.MOD_ID);
    }
}
