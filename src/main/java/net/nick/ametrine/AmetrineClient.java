package net.nick.ametrine;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.nick.ametrine.block.ModBlocks;
import net.nick.ametrine.entity.ModEntities;
import net.nick.ametrine.entity.client.WarfanProjectileEntityRenderer;
import net.nick.ametrine.entity.client.armor.*;
import net.nick.ametrine.item.ModItems;
import net.nick.ametrine.particle.AmetrineSweepAttackParticle;
import net.nick.ametrine.particle.ModParticleTypes;
import net.nick.ametrine.particle.WarfanBladeParticle;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class AmetrineClient implements ClientModInitializer {

    public static final Identifier AMETRINE_GLAIVE_RIPTIDE_OVERLAY =
            new Identifier(Ametrine.MOD_ID, "textures/entity/ametrine_riptide.png");


    @Environment(EnvType.CLIENT)
    @Override
    public void onInitializeClient() {
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("ametrine", "ametrine_longsword_gui", "inventory")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("ametrine", "ametrine_glaive_gui", "inventory")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> out.accept(new ModelIdentifier("ametrine", "ametrine_scythe_gui", "inventory")));



        GeoArmorRenderer.registerArmorRenderer(new AmetrineArmorRenderer(), ModItems.AMETRINE_BOOTS,
                ModItems.AMETRINE_HELMET);
        GeoArmorRenderer.registerArmorRenderer(new CitrineArmorRenderer(), ModItems.CITRINE_BOOTS,
                ModItems.CITRINE_HELMET);
        GeoArmorRenderer.registerArmorRenderer(new RoyalArmorRenderer(), ModItems.ROYAL_AMETRINE_CAPE,
                ModItems.ROYAL_AMETRINE_CROWN);
        GeoArmorRenderer.registerArmorRenderer(new RobesArmorRenderer(), ModItems.AMETRINE_WITCHS_HAT,
                ModItems.CROPPED_AMETRINE_ROBES);
        GeoArmorRenderer.registerArmorRenderer(new HornsArmorRenderer(), ModItems.CITRINE_RAM_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new EarsArmorRenderer(), ModItems.ELF_EARS);
        GeoArmorRenderer.registerArmorRenderer(new MaskArmorRenderer(), ModItems.CITRINE_MASK);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CITRINE_CLUSTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_CITRINE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_CITRINE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_CITRINE_BUD, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMETRINE_CLUSTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_AMETRINE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_AMETRINE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_AMETRINE_BUD, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.WARFAN_PROJECTILE_ENTITY, WarfanProjectileEntityRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.AMETRINE_SWEEP_ATTACK_PARTICLE, AmetrineSweepAttackParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.WARFAN_BLADE_PARTICLE, WarfanBladeParticle.Factory::new);
    }
}
