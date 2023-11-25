package net.nick.ametrine.statuseffect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nick.ametrine.Ametrine;

public class ModEffects {
    public static StatusEffect QUARTZ_POISONING;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Ametrine.MOD_ID, name),
                new QuartzPoisoningEffect(StatusEffectCategory.HARMFUL, 14456339));
    }

    public static void registerEffects() {
        QUARTZ_POISONING = registerStatusEffect("quartz_poisoning");
    }
}
