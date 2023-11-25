package net.nick.ametrine.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.nick.ametrine.entity.projectile.WarfanProjectileEntity;
import net.nick.ametrine.item.ModItems;
import net.nick.ametrine.particle.ModParticleTypes;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AmetrineWarfanItem extends SwordItem {

    private final float attackDamage;
    public final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public AmetrineWarfanItem(int attackDamage, float attackSpeed, Settings settings) {
        super(ToolMaterials.NETHERITE, attackDamage, attackSpeed, settings);
        this.attackDamage = ToolMaterials.NETHERITE.getAttackDamage() + attackDamage;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier("Attack range", -0.25D, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("§5Right §5click §7to fan a blade of ametrine.").formatted(Formatting.DARK_GRAY));

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
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        stack.damage(5, player, entity -> entity.sendEquipmentBreakStatus(hand.equals(Hand.MAIN_HAND) ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND));
        player.getItemCooldownManager().set(this, 80);

        if (!world.isClient()) {
            WarfanProjectileEntity warfanProjectileEntity = new WarfanProjectileEntity(world, player);
            warfanProjectileEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 0.25F);
            world.spawnEntity(warfanProjectileEntity);
        }


        player.world.playSoundFromEntity(null, player, SoundEvents.ITEM_TRIDENT_THROW, player.getSoundCategory(), 1.1F, 1.2F);
        player.swingHand(hand);
        player.getItemCooldownManager().set(ModItems.AMETRINE_WARFAN, 20);
        return TypedActionResult.success(stack, world.isClient());
    }
}