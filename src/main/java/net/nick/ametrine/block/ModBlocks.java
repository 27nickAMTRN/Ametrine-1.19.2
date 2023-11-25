package net.nick.ametrine.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.nick.ametrine.Ametrine;
import net.nick.ametrine.block.custom.AmetrineClusterBlock;
import net.nick.ametrine.block.custom.BuddingAmetrineBlock;
import net.nick.ametrine.block.custom.BuddingCitrineBlock;
import net.nick.ametrine.block.custom.CitrineClusterBlock;
import net.nick.ametrine.item.ModItemGroup;

public class ModBlocks {
    public static final Block DEEPSLATE_AMETRINE_ORE = registerBlock("deepslate_ametrine_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4.5f, 3.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .requiresTool(), UniformIntProvider.create(4, 10)),
            ModItemGroup.AMETRINE);

    public static final Block DEEPSLATE_CITRINE_ORE = registerBlock("deepslate_citrine_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4.5f, 3.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .requiresTool(), UniformIntProvider.create(4, 10)),
            ModItemGroup.AMETRINE);

    public static final Block DEEPSLATE_AMETHYST = registerBlock("deepslate_amethyst_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4.5f, 3.0f)
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .requiresTool(), UniformIntProvider.create(4, 10)),
            ModItemGroup.AMETRINE);


    public static final Block CITRINE_BLOCK = registerBlock("citrine_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .requiresTool()),
            ModItemGroup.AMETRINE);
    public static final Block BUDDING_CITRINE_BLOCK = registerBlock("budding_citrine",
            new BuddingCitrineBlock(FabricBlockSettings.of(Material.AMETHYST).ticksRandomly().strength(1.5f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .requiresTool()),
            ModItemGroup.AMETRINE);
    public static final Block CITRINE_CLUSTER = registerBlock("citrine_cluster",
            new CitrineClusterBlock(7, 3,FabricBlockSettings.of(Material.AMETHYST)
                    .nonOpaque().ticksRandomly().strength(1.5f).sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(5)),
            ModItemGroup.AMETRINE);
    public static final Block LARGE_CITRINE_BUD = registerBlock("large_citrine_bud",
            new CitrineClusterBlock(5, 3,FabricBlockSettings.of(Material.AMETHYST)
                    .nonOpaque().ticksRandomly().strength(1.5f).sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(4)),
            ModItemGroup.AMETRINE);
    public static final Block MEDIUM_CITRINE_BUD = registerBlock("medium_citrine_bud",
            new CitrineClusterBlock(4, 3,FabricBlockSettings.of(Material.AMETHYST)
                    .nonOpaque().ticksRandomly().strength(1.5f).sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(2)),
            ModItemGroup.AMETRINE);
    public static final Block SMALL_CITRINE_BUD = registerBlock("small_citrine_bud",
            new CitrineClusterBlock(3, 4,FabricBlockSettings.of(Material.AMETHYST)
                    .nonOpaque().ticksRandomly().strength(1.5f).sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(1)),
            ModItemGroup.AMETRINE);


    public static final Block AMETRINE_BLOCK = registerBlock("ametrine_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .requiresTool()),
            ModItemGroup.AMETRINE);
    public static final Block BUDDING_AMETRINE_BLOCK = registerBlock("budding_ametrine",
            new BuddingAmetrineBlock(FabricBlockSettings.of(Material.AMETHYST).ticksRandomly().strength(1.5f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .requiresTool()),
            ModItemGroup.AMETRINE);
    public static final Block AMETRINE_CLUSTER = registerBlock("ametrine_cluster",
            new AmetrineClusterBlock(7, 3,FabricBlockSettings.of(Material.AMETHYST)
                    .nonOpaque().ticksRandomly().strength(1.5f).sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(5)),
            ModItemGroup.AMETRINE);
    public static final Block LARGE_AMETRINE_BUD = registerBlock("large_ametrine_bud",
            new AmetrineClusterBlock(5, 3,FabricBlockSettings.of(Material.AMETHYST)
                    .nonOpaque().ticksRandomly().strength(1.5f).sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(4)),
            ModItemGroup.AMETRINE);
    public static final Block MEDIUM_AMETRINE_BUD = registerBlock("medium_ametrine_bud",
            new AmetrineClusterBlock(4, 3,FabricBlockSettings.of(Material.AMETHYST)
                    .nonOpaque().ticksRandomly().strength(1.5f).sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(2)),
            ModItemGroup.AMETRINE);
    public static final Block SMALL_AMETRINE_BUD = registerBlock("small_ametrine_bud",
            new AmetrineClusterBlock(3, 4,FabricBlockSettings.of(Material.AMETHYST)
                    .nonOpaque().ticksRandomly().strength(1.5f).sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(1)),
            ModItemGroup.AMETRINE);


    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(Ametrine.MOD_ID, name), block );
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(Ametrine.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {Ametrine.LOGGER.debug("Registering Mod Blocks for " + Ametrine.MOD_ID);
    }
}
