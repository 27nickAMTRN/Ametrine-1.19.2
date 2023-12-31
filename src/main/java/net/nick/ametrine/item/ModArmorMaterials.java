package net.nick.ametrine.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    AMETRINE("ametrine", 38, new int[]{4, 6, 8, 4}, 20,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0f, 0.1f, () -> Ingredient.ofItems(ModItems.AMETRINE_CHUNK)),
    CITRINE("citrine", 40, new int[]{3, 6, 8, 3}, 16,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0f, 0.15f, () -> Ingredient.ofItems(ModItems.CITRINE_CHUNK)),
    ROYAL("royal", 37, new int[]{3, 6, 6, 3}, 32,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.0f, 0f, () -> Ingredient.ofItems(ModItems.AMETRINE_SHARD)),
    ROBES("robes", 37, new int[]{3, 6, 6, 3}, 32,
    SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.0f, 0f, () -> Ingredient.ofItems(ModItems.AMETRINE_SHARD)),
    HORNS("horns", 37, new int[]{3, 6, 6, 3}, 32,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.0f, 0f, () -> Ingredient.ofItems(ModItems.AMETRINE_SHARD)),
    EARS("ears", 37, new int[]{3, 6, 6, 3}, 40,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 0.0f, 0f, () -> Ingredient.ofItems(ModItems.AMETRINE_SHARD)),
    MASK("mask", 37, new int[]{3, 6, 6, 3}, 32,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.0f, 0f, () -> Ingredient.ofItems(ModItems.AMETRINE_SHARD));



    private static final int[] BASE_DURABILITY;
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    static {
        BASE_DURABILITY = new int[]{13, 15, 16, 11};
    }
}