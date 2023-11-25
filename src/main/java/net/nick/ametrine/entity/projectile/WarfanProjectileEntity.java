package net.nick.ametrine.entity.projectile;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.nick.ametrine.entity.ModEntities;
import net.nick.ametrine.particle.ModParticleTypes;
import net.nick.ametrine.statuseffect.ModEffects;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class WarfanProjectileEntity extends PersistentProjectileEntity {

    private static final TrackedData<Boolean> HIT
            = DataTracker.registerData(WarfanProjectileEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int counter = 0;

    public WarfanProjectileEntity(EntityType<? extends WarfanProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
    public WarfanProjectileEntity(World world, LivingEntity owner) {
        super(ModEntities.WARFAN_PROJECTILE_ENTITY, owner, world);
        this.setPierceLevel((byte) 32);
    }


    @Nullable
    private IntOpenHashSet piercedEntities;
    @Nullable
    private List<Entity> piercingKilledEntities;

    @Override
    public double getDamage() {
        return 0.1f;
    }


    @Override
    public void tick() {
        super.tick();
        if (this.world.isClient) {
            this.world.addParticle(ModParticleTypes.WARFAN_BLADE_PARTICLE,
                    this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        }
        if (this.inGround) {this.discard();}

        if (this.age >=  30) {
            this.remove(RemovalReason.DISCARDED);
            }
    }
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        float f = (float)this.getVelocity().length();
        int i = MathHelper.ceil(MathHelper.clamp((double)f * 1, 0.0, 2.147483647E9));
        if (this.getPierceLevel() > 0) {
            if (this.piercedEntities == null) {
                this.piercedEntities = new IntOpenHashSet(5);
            }

            if (this.piercingKilledEntities == null) {
                this.piercingKilledEntities = Lists.newArrayListWithCapacity(5);
            }

            if (this.piercedEntities.size() >= this.getPierceLevel() + 1) {
                this.discard();
                return;
            }

            this.piercedEntities.add(entity.getId());
        }

        if (this.isCritical()) {
            long l = (long)this.random.nextInt(i / 2 + 2);
            i = (int)Math.min(l + (long)i, 2147483647L);
        }

        Entity entity2 = this.getOwner();
        DamageSource damageSource;
        if (entity2 == null) {
            damageSource = DamageSource.arrow(this, this);
        } else {
            damageSource = DamageSource.arrow(this, entity2);
            if (entity2 instanceof LivingEntity) {
                ((LivingEntity)entity2).onAttacking(entity);
            }
        }

        boolean bl = entity.getType() == EntityType.ENDERMAN;
        int j = entity.getFireTicks();
        if (this.isOnFire() && !bl) {
            entity.setOnFireFor(5);
        }

        if (entity.damage(damageSource, (float)i)) {
            if (bl) {
                return;
            }
            LivingEntity livingEntity = (LivingEntity)entity;

                if (!this.world.isClient && entity2 instanceof LivingEntity) {
                    EnchantmentHelper.onUserDamaged(livingEntity, entity2);
                    EnchantmentHelper.onTargetDamaged((LivingEntity)entity2, livingEntity);
                }

                this.onHit(livingEntity);
                if (entity2 != null && livingEntity != entity2 && livingEntity instanceof PlayerEntity && entity2 instanceof ServerPlayerEntity && !this.isSilent()) {
                    ((ServerPlayerEntity)entity2).networkHandler.sendPacket(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.PROJECTILE_HIT_PLAYER, 0.0F));
                }

                if (!entity.isAlive() && this.piercingKilledEntities != null) {
                    this.piercingKilledEntities.add(livingEntity);
                }

                if (!this.world.isClient && entity2 instanceof ServerPlayerEntity) {
                    ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity2;
                    if (this.piercingKilledEntities != null && this.isShotFromCrossbow()) {
                        Criteria.KILLED_BY_CROSSBOW.trigger(serverPlayerEntity, this.piercingKilledEntities);
                    } else if (!entity.isAlive() && this.isShotFromCrossbow()) {
                        Criteria.KILLED_BY_CROSSBOW.trigger(serverPlayerEntity, Arrays.asList(entity));
                    }
                }
            }

        }


        @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        StatusEffectInstance statusEffectInstance = new StatusEffectInstance(ModEffects.QUARTZ_POISONING, 30, 0);
        target.addStatusEffect(statusEffectInstance, this.getEffectCause());
    }


    @Override
    protected SoundEvent getHitSound() {
        return SoundEvents.BLOCK_LARGE_AMETHYST_BUD_BREAK;

    }

    @Override
    protected ItemStack asItemStack() {
        return ItemStack.EMPTY;
    }
    @Override
    public boolean hasNoGravity() {
        return true;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(HIT, false);
    }
}


