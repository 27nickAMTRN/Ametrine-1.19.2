package net.nick.ametrine.registry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;


public class ModDamageSources {

    public static final DamageSource QUARTZ_POISONING =
            (new DamageSource("quartz_poisoning")).setUnblockable().setBypassesArmor();

public static final DamageSource AMETRINE_COLLISION =
        (new DamageSource("ametrine_collision")).setUnblockable().setBypassesArmor();



    public static class ReapingDamageSource extends DamageSource {
        protected final Entity source;

        public static DamageSource playerRip(PlayerEntity attacker) {
            return (new ReapingDamageSource("reaping", attacker)).setUsesMagic();
        }

        public ReapingDamageSource(String name, PlayerEntity source) {
            super(name);
            this.source = source;
        }

        @Override
        public Entity getAttacker() {
            return this.source;
        }

        @Override
        public boolean isScaledWithDifficulty() {
            return this.source instanceof LivingEntity && !(this.source instanceof PlayerEntity);
        }

        @Override
        public @Nullable Vec3d getPosition() {
            return this.source.getPos();
        }

        @Override
        public String toString() {
            return "EntityDamageSource (" + this.source + ")";
        }
    }
}