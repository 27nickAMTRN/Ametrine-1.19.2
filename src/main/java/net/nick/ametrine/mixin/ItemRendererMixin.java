package net.nick.ametrine.mixin;

import net.minecraft.client.render.model.json.ModelTransformation.Mode;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.nick.ametrine.item.ModItems;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    private static final ModelIdentifier LS_INVENTORY_MODEL = new ModelIdentifier("ametrine:ametrine_longsword_gui#inventory");
    private static final ModelIdentifier GL_INVENTORY_MODEL = new ModelIdentifier("ametrine:ametrine_glaive_gui#inventory");
    private static final ModelIdentifier SC_INVENTORY_MODEL = new ModelIdentifier("ametrine:ametrine_scythe_gui#inventory");


    @Shadow
    private @Final ItemModels models;

    @ModifyVariable(method = "renderItem", at = @At("HEAD"), argsOnly = true)
    private BakedModel ametrine_guiModel(BakedModel model, ItemStack stack, Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel modelAgain) {
        boolean bl = renderMode == Mode.GUI || renderMode == Mode.GROUND || renderMode == Mode.FIXED;
        if (bl) {
            if (stack.isOf(ModItems.AMETRINE_LONGSWORD)) {
                return models.getModelManager().getModel(LS_INVENTORY_MODEL);
            }
        }
        if (bl) {
            if (stack.isOf(ModItems.AMETRINE_GLAIVE)) {
                return models.getModelManager().getModel(GL_INVENTORY_MODEL);
            }
        }
        if (bl) {
            if (stack.isOf(ModItems.AMETRINE_SCYTHE)) {
                return models.getModelManager().getModel(SC_INVENTORY_MODEL);
            }
        }



        return model;
     }
    }