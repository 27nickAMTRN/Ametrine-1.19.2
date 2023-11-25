package net.nick.ametrine.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nick.ametrine.item.ModItemGroup;
import net.nick.ametrine.item.ModItems;
import net.nick.ametrine.particle.ModParticleTypes;
import net.nick.ametrine.registry.ModDamageSources;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class AmetrineGlaiveItem extends SwordItem {
    private final float attackDamage;
    public final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public AmetrineGlaiveItem(int attackDamage, float attackSpeed, Settings settings) {
        super(ToolMaterials.NETHERITE, attackDamage, attackSpeed, settings);
        this.attackDamage = ToolMaterials.NETHERITE.getAttackDamage() + attackDamage;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier("Attack range", 0.75D, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.REACH, new EntityAttributeModifier("Attack range", 1.5D, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§5Hold §5Right §5click §7to vault forwards.").formatted(Formatting.DARK_GRAY));


        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? attributeModifiers : super.getAttributeModifiers(equipmentSlot);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player) {
            spawnAmetrineSweepParticle(player);
        }
        return super.postHit(stack, target, attacker);
    }

    private void spawnAmetrineSweepParticle(PlayerEntity player) {
        if (player.world instanceof ServerWorld) {
            for (int i = 0; i <= 0; i++) {
                double d = -MathHelper.sin(player.getYaw() * 0.017453292F);
                double e = MathHelper.cos(player.getYaw() * 0.017453292F);
                ((ServerWorld) player.world).spawnParticles(ModParticleTypes.AMETRINE_SWEEP_ATTACK_PARTICLE, player.getX() + d, player.getBodyY(0.5), player.getZ() + e, 0, d, 0.0, e, 0.0);
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (itemStack.getDamage() >= itemStack.getMaxDamage() - 1) {
            return TypedActionResult.fail(itemStack);
        }
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        return stack;


    }
    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!(user instanceof PlayerEntity playerEntity)) {
            return;
        }
        if ((this.getMaxUseTime(stack) - remainingUseTicks) < 10) {
            return;
        }
        int riptideLevel = 2;
        if (!world.isClient) {
            stack.damage(5, playerEntity, p -> p.sendToolBreakStatus(user.getActiveHand()));
        }
        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        float playerYaw = playerEntity.getYaw();
        float playerPitch = playerEntity.getPitch();
        float xOffset = -MathHelper.sin(playerYaw * ((float)Math.PI / 180)) * MathHelper.cos(playerPitch * ((float)Math.PI / 180));
        float yOffset = -MathHelper.sin(playerPitch * ((float)Math.PI / 180));
        float zOffset = MathHelper.cos(playerYaw * ((float)Math.PI / 180)) * MathHelper.cos(playerPitch * ((float)Math.PI / 180));
        float distance = MathHelper.sqrt(xOffset * xOffset + yOffset * yOffset + zOffset * zOffset);
        float n = 3.0f * (1.0f + riptideLevel) / 4.0f;
        playerEntity.addVelocity(xOffset * (n / distance), yOffset * (n / distance), zOffset * (n / distance));
        playerEntity.useRiptide(20);
        if (playerEntity.isOnGround()) {
            playerEntity.move(MovementType.SELF, new Vec3d(0.0, 1.1999999284744263, 0.0));
        }
        user.damage(ModDamageSources.AMETRINE_COLLISION, 2.0f);
        SoundEvent soundEvent = riptideLevel >= 2 ? SoundEvents.ITEM_TRIDENT_RIPTIDE_2 : (riptideLevel == 2 ? SoundEvents.ITEM_TRIDENT_RIPTIDE_2 : SoundEvents.ITEM_TRIDENT_RIPTIDE_1);
        world.playSoundFromEntity(null, playerEntity, soundEvent, SoundCategory.PLAYERS, 1.1f, 0.85f);
    }
}
