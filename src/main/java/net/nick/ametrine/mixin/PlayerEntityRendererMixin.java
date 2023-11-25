package net.nick.ametrine.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.nick.ametrine.item.custom.AmetrineGlaiveItem;
import net.nick.ametrine.item.custom.AmetrineLongswordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {
    @Inject(
            method = "getArmPose(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/client/render/entity/model/BipedEntityModel$ArmPose;",
            at = @At("TAIL"),
            cancellable = true
    )
    private static void holdLongsword(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<BipedEntityModel.ArmPose> ci) {
        ItemStack lv = player.getStackInHand(hand);
        if (lv.getItem() instanceof AmetrineLongswordItem) {
            ci.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_HOLD);
            ci.cancel();
        }
    }

    private static void throwGlaive(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<BipedEntityModel.ArmPose> ci) {
        ItemStack lv = player.getStackInHand(hand);
        if (lv.getItem() instanceof AmetrineGlaiveItem) {
            ci.setReturnValue(BipedEntityModel.ArmPose.THROW_SPEAR);
            ci.cancel();
        }
    }
}