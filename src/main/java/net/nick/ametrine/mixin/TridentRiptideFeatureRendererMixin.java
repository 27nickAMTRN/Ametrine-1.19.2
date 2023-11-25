package net.nick.ametrine.mixin;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.TridentRiptideFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.nick.ametrine.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static net.nick.ametrine.AmetrineClient.AMETRINE_GLAIVE_RIPTIDE_OVERLAY;

@Mixin(TridentRiptideFeatureRenderer.class)
public abstract class TridentRiptideFeatureRendererMixin {
    @ModifyVariable(method = "render", at = @At("STORE"))
    private VertexConsumer AmetrineRiptide(VertexConsumer orig, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity && livingEntity.isUsingRiptide() &&
                (livingEntity.getMainHandStack().getItem() == ModItems.AMETRINE_GLAIVE || (livingEntity.getOffHandStack().getItem() == ModItems.AMETRINE_GLAIVE))) {
            return vertexConsumerProvider.getBuffer(RenderLayer.getEntityCutoutNoCull(AMETRINE_GLAIVE_RIPTIDE_OVERLAY));
        }
        return orig;
    }
}
