package net.SpectrumFATM.black_archive.effects;

import net.SpectrumFATM.black_archive.BlackArchive;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

public class EffectRegistry {

    public static final DeferredRegistry<StatusEffect> EFFECTS = DeferredRegistry.create(BlackArchive.MOD_ID, Registries.STATUS_EFFECT.getKey());
    public static final RegistrySupplier<DalekNanocloudEffect> DALEK_NANOCLOUD = EFFECTS.register("dalek_nanocloud", DalekNanocloudEffect::new);
    public static final RegistrySupplier<DalekNanocloudEffect> CYBER_CONVERSION = EFFECTS.register("cyber_conversion", DalekNanocloudEffect::new);


}
