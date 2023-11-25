package net.nick.ametrine.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> AMETRINE_ORE_PLACED = PlacedFeatures.register("ametrine_ore_placed",
            ModConfiguredFeatures.AMETRINE_ORE, modifiersWithCount(3,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-70), YOffset.fixed(0))));

    public static final RegistryEntry<PlacedFeature> CITRINE_ORE_PLACED = PlacedFeatures.register("citrine_ore_placed",
            ModConfiguredFeatures.CITRINE_ORE, modifiersWithCount(4,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-60), YOffset.fixed(0))));

    public static final RegistryEntry<PlacedFeature> AMETHYST_ORE_PLACED = PlacedFeatures.register("amethyst_ore_placed",
            ModConfiguredFeatures.AMETHYST_ORE, modifiersWithCount(4,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-60), YOffset.fixed(0))));



    public static final RegistryEntry<PlacedFeature> CITRINE_GEODE_PLACED = PlacedFeatures.register("citrine_geode_placed",
            ModConfiguredFeatures.CITRINE_GEODE, RarityFilterPlacementModifier.of(31),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.aboveBottom(50)),
            BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> AMETRINE_GEODE_PLACED = PlacedFeatures.register("ametrine_geode_placed",
            ModConfiguredFeatures.AMETRINE_GEODE, RarityFilterPlacementModifier.of(21),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.aboveBottom(50)),
            BiomePlacementModifier.of());

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
