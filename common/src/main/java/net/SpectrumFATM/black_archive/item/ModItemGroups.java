package net.SpectrumFATM.black_archive.item;

import net.SpectrumFATM.black_archive.BlackArchive;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BLACK_ARCHIVE = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BlackArchive.MOD_ID, "vortex_manipulator"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.black_archive"))
                    .icon(() -> new ItemStack(ModItems.VORTEXMANIP.get())).entries((displayContext, entries) -> {
                        entries.add(ModItems.VORTEXMANIP.get());
                        entries.add(ModItems.CONTACTLENS.get());
                        entries.add(ModItems.TARDISKEYCLASSIC.get());
                        entries.add(ModItems.REMOTE.get());
                        entries.add(ModItems.SUPERPHONE.get());
                        entries.add(ModItems.SONIC10.get());
                        entries.add(ModItems.SONIC11.get());
                        entries.add(ModItems.SONIC12.get());
                        entries.add(ModItems.SONIC13.get());
                        entries.add(ModItems.SONIC14.get());
                        entries.add(ModItems.SONIC15.get());
                        entries.add(ModItems.DALEK_LASER_GUN.get());
                        entries.add(ModItems.DALEK_BRACELET.get());
                        entries.add(ModItems.TCE.get());
                        entries.add(ModItems.GRAVITY_GEN.get());
                        entries.add(ModItems.OXYGEN_GEN.get());
                    }).build());


    public static void registerToVanillaItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
            content.add(ModItems.DALEK_EGG.get());
            content.add(ModItems.CYBERMAN_EGG.get());
            content.add(ModItems.CYBERMAT_EGG.get());
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.add(ModItems.STEEL_INGOT.get());
            content.add(ModItems.RAW_STEEL.get());
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.add(ModItems.STEEL_BLOCK.get());
            content.add(ModItems.CUT_STEEL.get());
            content.add(ModItems.ETCHED_STEEL.get());
            content.add(ModItems.STEEL_STAIRS.get());
            content.add(ModItems.STEEL_SLAB.get());
        });
    }

    public static void registerItemGroups() {
        BlackArchive.LOGGER.info("Registering Item Groups for " + BlackArchive.MOD_ID);
    }
}