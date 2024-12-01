package net.SpectrumFATM.black_archive.entity;

import net.SpectrumFATM.black_archive.BlackArchive;
import net.SpectrumFATM.black_archive.entity.custom.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;


public class ModEntityRegistry {

    public static final DeferredRegistry<EntityType<?>> ENTITY_TYPES = DeferredRegistry.create(BlackArchive.MOD_ID, Registries.ENTITY_TYPE.getKey());

    public static final RegistrySupplier<EntityType<DalekEntity>> DALEK = ENTITY_TYPES.register("dalek",
            () -> registerStatic(DalekEntity::new, SpawnGroup.CREATURE, 1f, 1.5f, 64, 3, "dalek"));

    public static final RegistrySupplier<EntityType<LaserEntity>> LASER = ENTITY_TYPES.register("laser",
            () -> registerStatic(LaserEntity::new, SpawnGroup.MISC, 0.5f, 0.5f, 64, 10, "laser"));

    public static final RegistrySupplier<EntityType<DalekPuppetEntity>> DALEK_PUPPET = ENTITY_TYPES.register("dalek_puppet",
            () -> registerStatic(DalekPuppetEntity::new, SpawnGroup.CREATURE, 1f, 1.5f, 64, 3, "dalek_puppet"));

    public static final RegistrySupplier<EntityType<CybermanEntity>> CYBERMAN = ENTITY_TYPES.register("cyberman",
            () -> registerStatic(CybermanEntity::new, SpawnGroup.CREATURE, 1f, 1.5f, 64, 3, "cyberman"));

    public static final RegistrySupplier<EntityType<CybermatEntity>> CYBERMAT = ENTITY_TYPES.register("cybermat",
            () -> registerStatic(CybermatEntity::new, SpawnGroup.CREATURE, 0.5f, 0.5f, 64, 3, "cybermat"));

    public static final RegistrySupplier<EntityType<TimeFissureEntity>> TIME_FISSURE = ENTITY_TYPES.register("time_fissure",
            () -> registerStatic(TimeFissureEntity::new, SpawnGroup.CREATURE, 1f, 2f, 64, 3, "time_fissure"));

    /**
     * Registers an entity type with specified properties.
     *
     * @param factory          - Factory to create the entity.
     * @param classification   - MobCategory of the entity.
     * @param width            - Entity width.
     * @param height           - Entity height.
     * @param trackingRange    - Radius in chunks to sync the entity to clients.
     * @param updateFreq       - Update interval in ticks.
     * @param name             - Registry name (without mod ID prefix).
     * @param <T>              - Type of the entity.
     * @return The registered EntityType.
     */
    private static <T extends Entity> EntityType<T> registerStatic(EntityType.EntityFactory<T> factory, SpawnGroup classification, float width, float height, int trackingRange, int updateFreq, String name) {
        Identifier loc = new Identifier(BlackArchive.MOD_ID, name);
        EntityType.Builder<T> builder = EntityType.Builder.create(factory, classification)
                .maxTrackingRange(trackingRange)
                .trackingTickInterval(updateFreq)
                .setDimensions(width, height);
        return builder.build(loc.toString());
    }


    public static void registerModEntities() {
        BlackArchive.LOGGER.info("Registering Entities for " + BlackArchive.MOD_ID);
    }
}
