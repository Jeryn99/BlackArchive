package net.SpectrumFATM.black_archive.item;

import net.SpectrumFATM.black_archive.BlackArchive;
import net.SpectrumFATM.black_archive.block.ModBlocks;
import net.SpectrumFATM.black_archive.item.custom.*;
import net.SpectrumFATM.black_archive.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.util.Formatting;
import whocraft.tardis_refined.common.items.KeyItem;
import dev.architectury.injectables.annotations.ExpectPlatform;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static net.SpectrumFATM.black_archive.entity.ModEntityRegistry.*;

public class ModItems {

    public static final DeferredRegistry<Item> ITEMS = DeferredRegistry.create(BlackArchive.MOD_ID, Registries.ITEM.getKey());
    public static List<RegistrySupplier<Item>> TAB_ITEMS = new ArrayList<>();

    public static final RegistrySupplier<Item> VORTEXMANIP = register("vortex_manipulator", () -> new VortexManipulatorItem(new FabricItemSettings().maxCount(1)), true);
    public static final RegistrySupplier<Item> CONTACTLENS = register("contact_lens", () -> new ContactLensItem(new FabricItemSettings().maxCount(1)), true);
    public static final RegistrySupplier<Item> TARDISKEYCLASSIC = register("key_01", () -> new KeyItem(new FabricItemSettings().maxCount(1)), true);
    public static final RegistrySupplier<Item> SUPERPHONE = register("superphone", () -> new DistressItem(new FabricItemSettings().maxCount(1), "item.superphone.tooltip"), true);
    public static final RegistrySupplier<Item> REMOTE = register("remote", () -> new RemoteItem(new FabricItemSettings().maxCount(1)), true);
    public static final RegistrySupplier<Item> SONIC10 = register("10thsonic", () -> new SonicItem(new FabricItemSettings().maxCount(1), "item.sonic10.tooltip", Formatting.BLUE), true);
    public static final RegistrySupplier<Item> SONIC11 = register("11thsonic", () -> new SonicItem(new FabricItemSettings().maxCount(1), "item.sonic11.tooltip", Formatting.DARK_GREEN), true);
    public static final RegistrySupplier<Item> SONIC12 = register("12thsonic", () -> new SonicItem(new FabricItemSettings().maxCount(1), "item.sonic12.tooltip", Formatting.BLUE), true);
    public static final RegistrySupplier<Item> SONIC14 = register("14thsonic", () -> new SonicItem(new FabricItemSettings().maxCount(1), "item.sonic.tooltip", Formatting.BLUE), true);
    public static final RegistrySupplier<Item> SONIC15 = register("15thsonic", () -> new SonicItem(new FabricItemSettings().maxCount(1), "item.sonic15.tooltip", Formatting.BLUE), true);
    public static final RegistrySupplier<Item> SONIC13 = register("13thsonic", () -> new SonicItem(new FabricItemSettings().maxCount(1), "item.sonic13.tooltip", Formatting.GOLD), true);
    public static final RegistrySupplier<Item> DALEK_LASER_GUN = register("dalek_gun_stick", () -> new LaserGunItem(new FabricItemSettings().maxCount(1), "item.dalek_laser.tooltip", ModSounds.DALEK_LASER.get(), ModSounds.DALEK_MALFUNCTION.get()), true);
    public static final RegistrySupplier<Item> DALEK_BRACELET = register("dalek_bracelet", () -> new TooltipItem(new FabricItemSettings().maxCount(1), "item.dalek_bracelet.tooltip"), true);
    public static final RegistrySupplier<Item> TCE = register("tce", () -> new CompressorItem(new FabricItemSettings().maxCount(1), "item.tce.tooltip"), true);

    public static final RegistrySupplier<Item> STEEL_INGOT = register("steel_ingot", () -> new Item(new FabricItemSettings()), true);
    public static final RegistrySupplier<Item> RAW_STEEL = register("raw_steel", () -> new Item(new FabricItemSettings()), true);

    public static final RegistrySupplier<Item> DALEK_GRAV_GEN = register("dalek_gravity_generator", () -> new TooltipBlockItem(ModBlocks.DALEK_GRAVITY_GEN.get(), new FabricItemSettings(), "block.dalek_gravity.tooltip"), true);
    public static final RegistrySupplier<Item> GRAVITY_GEN = register("gravity_generator", () -> new TooltipBlockItem(ModBlocks.GRAVITY_GEN.get(), new FabricItemSettings(), "block.gravity.tooltip"), true);
    public static final RegistrySupplier<Item> OXYGEN_GEN = register("oxygen_field", () -> new TooltipBlockItem(ModBlocks.OXYGEN_GEN.get(), new FabricItemSettings(), "block.oxygen.tooltip"), true);
    public static final RegistrySupplier<Item> STEEL_BLOCK = register("steel_block", () -> new BlockItem(ModBlocks.STEEL_BLOCK.get(), new FabricItemSettings()), true);
    public static final RegistrySupplier<Item> CUT_STEEL = register("cut_steel", () -> new BlockItem(ModBlocks.CUT_STEEL.get(), new FabricItemSettings()), true);
    public static final RegistrySupplier<Item> ETCHED_STEEL = register("etched_steel", () -> new BlockItem(ModBlocks.ETCHED_STEEL.get(), new FabricItemSettings()), true);
    public static final RegistrySupplier<Item> STEEL_STAIRS = register("steel_stairs", () -> new BlockItem(ModBlocks.STEEL_STAIRS.get(), new FabricItemSettings()), true);
    public static final RegistrySupplier<Item> STEEL_SLAB = register("steel_slab", () -> new BlockItem(ModBlocks.STEEL_SLAB.get(), new FabricItemSettings()), true);

    public static final RegistrySupplier<Item> DALEK_EGG = register("dalek_spawn_egg", () -> new SpawnEggItem(DALEK.get(), 0xFFFFFF, 0xFFFFFF, new FabricItemSettings().maxCount(1)), true);
    public static final RegistrySupplier<Item> CYBERMAT_EGG = register("cybermat_spawn_egg", () -> new SpawnEggItem(CYBERMAT.get(), 0xFFFFFF, 0xFFFFFF, new FabricItemSettings().maxCount(1)), true);
    public static final RegistrySupplier<Item> CYBERMAN_EGG = register("cyberman_spawn_egg", () -> new SpawnEggItem(CYBERMAN.get(), 0xFFFFFF, 0xFFFFFF, new FabricItemSettings().maxCount(1)), true);

    private static <T extends Item> RegistrySupplier<T> register(String id, Supplier<T> itemSupplier, boolean addToTab) {
        RegistrySupplier<T> item = ITEMS.register(id, itemSupplier);
        if (addToTab) {
            TAB_ITEMS.add((RegistrySupplier<Item>) item);
        }
        return item;
    }

    @ExpectPlatform
    public static ItemGroup getCreativeTab() {
        throw new RuntimeException("Bad!");
    }

    public static void registerModItems() {
        BlackArchive.LOGGER.info("Registering mod items for " + BlackArchive.MOD_ID);
    }
}
