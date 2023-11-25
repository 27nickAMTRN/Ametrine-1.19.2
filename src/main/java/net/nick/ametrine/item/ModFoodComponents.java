package net.nick.ametrine.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.nick.ametrine.statuseffect.ModEffects;

public class ModFoodComponents {
    public static final FoodComponent AMETHYST_COVERED_BERRIES = new
            FoodComponent.Builder().hunger(5).saturationModifier(1.0f).build();
    public static final FoodComponent CITRINE_GLAZED_APPLE = new
            FoodComponent.Builder().hunger(8).saturationModifier(0.4f).build();
    public static final FoodComponent AMETRINE_GROWN_MELON_SLICE = new
            FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build();
    public static final FoodComponent FLAWLESS_QUARTZ_CHUNK = new
            FoodComponent.Builder().hunger(5).saturationModifier(0.2f).snack()
            .statusEffect(new StatusEffectInstance(ModEffects.QUARTZ_POISONING, 200), 0.18f).build();
    public static final FoodComponent ANTIDOTE = new
            FoodComponent.Builder().hunger(6).saturationModifier(0.3f).snack().build();

}
