package net.nick.ametrine.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.nick.ametrine.Ametrine;
import net.nick.ametrine.item.custom.*;

public class ModItems {

    public static final Item AMETRINE_CHUNK = registerItem("ametrine_chunk",
            new Item(new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroup.AMETRINE)));
    public static final Item AMETHYST_CHUNK = registerItem("amethyst_chunk",
            new Item(new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroup.AMETRINE)));
    public static final Item CITRINE_CHUNK = registerItem("citrine_chunk",
            new Item(new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroup.AMETRINE)));
    public static final Item CITRINE_SHARD = registerItem("citrine_shard",
            new Item(new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroup.AMETRINE)));
    public static final Item AMETRINE_SHARD = registerItem("ametrine_shard",
            new Item(new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroup.AMETRINE)));


    public static final Item GLASS_VIAL = registerItem("glass_vial",
            new Item(new FabricItemSettings().rarity(Rarity.COMMON).group(ModItemGroup.AMETRINE)));
    public static final Item ANTIDOTE = registerItem("antidote",
            new AntidoteItem(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(16)
                    .food(ModFoodComponents.ANTIDOTE).group(ModItemGroup.AMETRINE)));



    public static final Item AMETRINE_GROWN_MELON_SLICE = registerItem("ametrine_grown_melon_slice",
            new Item(new FabricItemSettings().
                    food(ModFoodComponents.AMETRINE_GROWN_MELON_SLICE).rarity(Rarity.COMMON).group(ModItemGroup.AMETRINE)));
    public static final Item AMETHYST_COVERED_BERRIES = registerItem("amethyst_covered_berries",
            new Item(new FabricItemSettings().
                    food(ModFoodComponents.AMETHYST_COVERED_BERRIES).rarity(Rarity.COMMON).group(ModItemGroup.AMETRINE)));
    public static final Item CITRINE_GLAZED_APPLE = registerItem("citrine_glazed_apple",
            new Item(new FabricItemSettings().
                    food(ModFoodComponents.CITRINE_GLAZED_APPLE).rarity(Rarity.COMMON).group(ModItemGroup.AMETRINE)));



    public static final Item FLAWLESS_CITRINE_CHUNK = registerItem("flawless_citrine_chunk",
            new Item(new FabricItemSettings().
                    food(ModFoodComponents.FLAWLESS_QUARTZ_CHUNK).rarity(Rarity.UNCOMMON).group(ModItemGroup.AMETRINE)));
    public static final Item FLAWLESS_AMETHYST_CHUNK = registerItem("flawless_amethyst_chunk",
            new Item(new FabricItemSettings().
                    food(ModFoodComponents.FLAWLESS_QUARTZ_CHUNK).rarity(Rarity.EPIC).group(ModItemGroup.AMETRINE)));
    public static final Item FLAWLESS_AMETRINE_CHUNK = registerItem("flawless_ametrine_chunk",
            new Item(new FabricItemSettings().
                    food(ModFoodComponents.FLAWLESS_QUARTZ_CHUNK).rarity(Rarity.EPIC).group(ModItemGroup.AMETRINE)));


    public static final Item AMETRINE_GLAIVE = registerItem("ametrine_glaive",
            new AmetrineGlaiveItem(3, -2.6f,
                    (settings()).fireproof().rarity(Rarity.EPIC).group(ModItemGroup.AMETRINE).maxCount(1)));
    public static final Item AMETRINE_LONGSWORD = registerItem("ametrine_longsword",
            new AmetrineLongswordItem(4, -2.8f,
                    (settings()).fireproof().rarity(Rarity.EPIC).group(ModItemGroup.AMETRINE).maxCount(1)));
    public static final Item AMETRINE_SCYTHE = registerItem("ametrine_scythe",
            new AmetrineScytheItem(5, -3.0F,
                    (settings()).fireproof().rarity(Rarity.EPIC).group(ModItemGroup.AMETRINE).maxCount(1)));
    public static final Item AMETRINE_WARFAN = registerItem("ametrine_warfan",
            new AmetrineWarfanItem(1, -2.0f,
                    (settings()).fireproof().rarity(Rarity.EPIC).group(ModItemGroup.AMETRINE).maxCount(1)));



    public static final Item AMETRINE_HELMET = registerItem("ametrine_helmet",
            new AmetrineArmorItem(ModArmorMaterials.AMETRINE, EquipmentSlot.HEAD,
                    new FabricItemSettings().fireproof().rarity(Rarity.EPIC).group(ModItemGroup.AMETRINE)));
    public static final Item AMETRINE_BOOTS = registerItem("ametrine_boots",
            new AmetrineArmorItem(ModArmorMaterials.AMETRINE, EquipmentSlot.FEET,
                    new FabricItemSettings().fireproof().rarity(Rarity.EPIC).group(ModItemGroup.AMETRINE)));

    public static final Item CITRINE_HELMET = registerItem("citrine_helmet",
            new CitrineArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.HEAD,
                    new FabricItemSettings().fireproof().rarity(Rarity.UNCOMMON).group(ModItemGroup.AMETRINE)));
    public static final Item CITRINE_BOOTS = registerItem("citrine_boots",
            new CitrineArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.FEET,
                    new FabricItemSettings().fireproof().rarity(Rarity.UNCOMMON).group(ModItemGroup.AMETRINE)));

    public static final Item ROYAL_AMETRINE_CROWN = registerItem("royal_ametrine_crown",
            new RoyalArmorItem(ModArmorMaterials.ROYAL, EquipmentSlot.HEAD,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.AMETRINE)));
    public static final Item ROYAL_AMETRINE_CAPE = registerItem("royal_ametrine_cape",
            new RoyalArmorItem(ModArmorMaterials.ROYAL, EquipmentSlot.CHEST,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.AMETRINE)));

    public static final Item AMETRINE_WITCHS_HAT = registerItem("ametrine_witchs_hat",
            new RobesArmorItem(ModArmorMaterials.ROBES, EquipmentSlot.HEAD,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.AMETRINE)));
    public static final Item CROPPED_AMETRINE_ROBES = registerItem("cropped_ametrine_robes",
            new RobesArmorItem(ModArmorMaterials.ROBES, EquipmentSlot.CHEST,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.AMETRINE)));

    public static final Item CITRINE_RAM_HORNS = registerItem("citrine_ram_horns",
            new HornsArmorItem(ModArmorMaterials.HORNS, EquipmentSlot.HEAD,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.AMETRINE)));


    public static final Item ELF_EARS = registerItem("elf_ears",
            new EarsArmorItem(ModArmorMaterials.EARS, EquipmentSlot.HEAD,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.AMETRINE)));

    public static final Item CITRINE_MASK = registerItem("citrine_mask",
            new MaskArmorItem(ModArmorMaterials.MASK, EquipmentSlot.HEAD,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.AMETRINE)));


    private static Item.Settings settings() {
        return new FabricItemSettings().group(ModItemGroup.AMETRINE);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Ametrine.MOD_ID, name), item );
    }

    public static void registerModItems() {
        Ametrine.LOGGER.debug("Registering Mod Items for " + Ametrine.MOD_ID);
    }
}
