package net.nick.ametrine.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nick.ametrine.Ametrine;
import net.nick.ametrine.entity.projectile.WarfanProjectileEntity;

public class ModEntities {
    public static final EntityType<WarfanProjectileEntity> WARFAN_PROJECTILE_ENTITY = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Ametrine.MOD_ID, "warfan_projectile_entity"),
            FabricEntityTypeBuilder.<WarfanProjectileEntity>create(SpawnGroup.MISC, WarfanProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(2.5f, -1.2f)).build());

    public static void registerModEntites() {
        Ametrine.LOGGER.info("Registering Mod Entities for " + Ametrine.MOD_ID);
    }
}
