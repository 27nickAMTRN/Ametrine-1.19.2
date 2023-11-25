package net.nick.ametrine.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.nick.ametrine.Ametrine;
import net.nick.ametrine.block.ModBlocks;
import software.bernie.shadowed.eliotlash.mclib.math.functions.classic.Mod;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_AMETRINE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    ModBlocks.DEEPSLATE_AMETRINE_ORE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> OVERWORLD_AMETHYST_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    ModBlocks.DEEPSLATE_AMETHYST.getDefaultState()));

    public static final List<OreFeatureConfig.Target> OVERWORLD_CITTRINE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    ModBlocks.DEEPSLATE_CITRINE_ORE.getDefaultState()));


    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CITRINE_ORE =
            ConfiguredFeatures.register("citrine_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_CITTRINE_ORES, 4));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> AMETHYST_ORE =
            ConfiguredFeatures.register("amethyst_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_AMETHYST_ORES, 4));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> AMETRINE_ORE =
            ConfiguredFeatures.register("ametrine_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_AMETRINE_ORES, 3));


    public static final RegistryEntry<ConfiguredFeature<GeodeFeatureConfig, ?>> CITRINE_GEODE =
            ConfiguredFeatures.register("citrine_geode", Feature.GEODE,
                    new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
                            BlockStateProvider.of(ModBlocks.CITRINE_BLOCK),
                            BlockStateProvider.of(ModBlocks.BUDDING_CITRINE_BLOCK),
                            BlockStateProvider.of(Blocks.CALCITE),
                            BlockStateProvider.of(Blocks.SMOOTH_BASALT),
                            List.of(ModBlocks.SMALL_CITRINE_BUD.getDefaultState(), ModBlocks.MEDIUM_CITRINE_BUD.getDefaultState(),
                                    ModBlocks.LARGE_CITRINE_BUD.getDefaultState(), ModBlocks.CITRINE_CLUSTER.getDefaultState()),
                            BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                            new GeodeLayerThicknessConfig(1.7D, 2.2D, 3.2D, 4.2D),
                            new GeodeCrackConfig(0.95D, 2.0D, 2),
                            0.35D, 0.083D,
                            true, UniformIntProvider.create(4, 6),
                            UniformIntProvider.create(3, 4), UniformIntProvider.create(1, 2),
                            -16, 16, 0.05D, 1));

    public static final RegistryEntry<ConfiguredFeature<GeodeFeatureConfig, ?>> AMETRINE_GEODE =
            ConfiguredFeatures.register("ametrine_geode", Feature.GEODE,
                    new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
                            BlockStateProvider.of(ModBlocks.AMETRINE_BLOCK),
                            BlockStateProvider.of(ModBlocks.BUDDING_AMETRINE_BLOCK),
                            BlockStateProvider.of(Blocks.CALCITE),
                            BlockStateProvider.of(Blocks.SMOOTH_BASALT),
                            List.of(ModBlocks.SMALL_AMETRINE_BUD.getDefaultState(), ModBlocks.MEDIUM_AMETRINE_BUD.getDefaultState(),
                                    ModBlocks.LARGE_AMETRINE_BUD.getDefaultState(), ModBlocks.AMETRINE_CLUSTER.getDefaultState()),
                            BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                            new GeodeLayerThicknessConfig(1.7D, 2.2D, 3.2D, 4.2D),
                            new GeodeCrackConfig(0.95D, 2.0D, 2),
                            0.35D, 0.083D,
                            true, UniformIntProvider.create(4, 6),
                            UniformIntProvider.create(3, 4), UniformIntProvider.create(1, 2),
                            -16, 16, 0.05D, 1));

    public static void registerConfiguredFeatures() {
        Ametrine.LOGGER.debug("Registering the ModConfiguredFeatures for " + Ametrine.MOD_ID);

    }
}