package net.SpectrumFATM.black_archive;

import net.SpectrumFATM.black_archive.config.BlackArchiveConfig;
import net.SpectrumFATM.black_archive.effects.DalekNanocloudEffect;
import net.SpectrumFATM.black_archive.entity.ModEntityRegistry;
import net.SpectrumFATM.black_archive.entity.custom.*;
import net.SpectrumFATM.black_archive.item.ModItemGroups;
import net.SpectrumFATM.black_archive.item.ModItems;
import net.SpectrumFATM.black_archive.network.NetworkPackets;
import net.SpectrumFATM.black_archive.sound.ModSounds;
import net.SpectrumFATM.black_archive.tardis.control.ModControls;
import net.SpectrumFATM.black_archive.tardis.upgrades.ModUpgrades;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlackArchive {

    public static final String MOD_ID = "black_archive";
    public static final Logger LOGGER = LoggerFactory.getLogger("black_archive");

    public static final StatusEffect DALEK_NANOCLOUD = new DalekNanocloudEffect();
    public static final StatusEffect CYBER_CONVERSION = new DalekNanocloudEffect();

    public static void onInitialize() {
        // Initialize the configuration
        BlackArchiveConfig.register();

        // Register the effect with the game
        Registry.register(Registries.STATUS_EFFECT, new Identifier(BlackArchive.MOD_ID, "dalek_nanocloud"), DALEK_NANOCLOUD);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(BlackArchive.MOD_ID, "cyber_conversion"), CYBER_CONVERSION);

        ModItemGroups.registerItemGroups();
        ModItemGroups.registerToVanillaItemGroups();
        NetworkPackets.registerPackets();

        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            NetworkPackets.registerClientSidePackets();
        }

        ModUpgrades.register();
        ModControls.register();
        ModSounds.SOUNDS.registerToModBus();
        ModItems.ITEMS.registerToModBus();
        ModEntityRegistry.ENTITY_TYPES.registerToModBus();

        FabricDefaultAttributeRegistry.register(ModEntityRegistry.DALEK.get(), DalekEntity.createDalekAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityRegistry.DALEK_PUPPET.get(), DalekPuppetEntity.createDalekSlaveAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityRegistry.CYBERMAN.get(), CybermanEntity.createCyberAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityRegistry.CYBERMAT.get(), CybermatEntity.createCyberAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityRegistry.TIME_FISSURE.get(), TimeFissureEntity.createTimeFissureAttributes());
    }
}