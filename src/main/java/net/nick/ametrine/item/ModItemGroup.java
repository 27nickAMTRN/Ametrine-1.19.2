package net.nick.ametrine.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.nick.ametrine.Ametrine;
import net.nick.ametrine.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup AMETRINE = FabricItemGroupBuilder.build(
            new Identifier(Ametrine.MOD_ID, "ametrine"), () -> new ItemStack(ModBlocks.AMETRINE_CLUSTER));

}
