package net.SpectrumFATM.black_archive.block;

import net.SpectrumFATM.black_archive.block.custom.DalekGravityGenBlock;
import net.SpectrumFATM.black_archive.block.custom.GravityGenBlock;
import net.SpectrumFATM.black_archive.block.custom.OxygenGenBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;
import whocraft.tardis_refined.registry.TRItemRegistry;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegistry<Block> BLOCKS = DeferredRegistry.create("tardis_refined", RegistryKeys.BLOCK);
    public static final RegistrySupplier<Block> DALEK_GRAVITY_GEN = register("dalek_gravity_generator", () -> new DalekGravityGenBlock(AbstractBlock.Settings.create()), false);
    public static final RegistrySupplier<Block> GRAVITY_GEN = register("gravity_generator", () -> new GravityGenBlock(AbstractBlock.Settings.create()), false);
    public static final RegistrySupplier<Block> OXYGEN_GEN = register("oxygen_field", () -> new OxygenGenBlock(AbstractBlock.Settings.create()), false);
    public static final RegistrySupplier<Block> STEEL_BLOCK = register("steel_block", () -> new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.COPPER).hardness(5.0F).resistance(6.0F)), false);
    public static final RegistrySupplier<Block> CUT_STEEL = register("cut_steel", () -> new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.COPPER).hardness(5.0F).resistance(6.0F)), false);
    public static final RegistrySupplier<Block> ETCHED_STEEL = register("etched_steel", () -> new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.COPPER).hardness(5.0F).resistance(6.0F)), false);

    public static final RegistrySupplier<Block> STEEL_STAIRS = register("steel_stairs", () -> new StairsBlock(STEEL_BLOCK.get().getDefaultState(), AbstractBlock.Settings.create().sounds(BlockSoundGroup.COPPER).hardness(5.0F).resistance(6.0F)), false);

    public static final RegistrySupplier<Block> STEEL_SLAB = register("steel_slab", () -> new SlabBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.COPPER).hardness(5.0F).resistance(6.0F)), false);

    private static <T extends Block> RegistrySupplier<T> register(String id, Supplier<T> blockSupplier, boolean addToTab, boolean registerItem) {
        RegistrySupplier<T> registryObject = BLOCKS.register(id, blockSupplier);
        if (registerItem) {
            RegistrySupplier<Item> itemSupplier = TRItemRegistry.ITEMS.register(id, () -> new BlockItem((Block) registryObject.get(), new Item.Settings()));
            if (addToTab) {
                TRItemRegistry.TAB_ITEMS.add(itemSupplier);
            }
        }

        return registryObject;
    }

    private static <T extends Block> RegistrySupplier<T> register(String id, Supplier<T> blockSupplier, boolean addToTab) {
        return register(id, blockSupplier, addToTab, true);
    }
}
