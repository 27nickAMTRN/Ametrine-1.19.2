package net.nick.ametrine.entity.client;


import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import net.nick.ametrine.Ametrine;
import net.nick.ametrine.entity.projectile.WarfanProjectileEntity;

public class WarfanProjectileEntityRenderer extends ProjectileEntityRenderer<WarfanProjectileEntity> {
    public static final Identifier TEXTURE = new Identifier(Ametrine.MOD_ID, "textures/entity/nothing.png");

    public WarfanProjectileEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public Identifier getTexture(WarfanProjectileEntity warfanProjectileEntity) {
        return TEXTURE;
    }
}