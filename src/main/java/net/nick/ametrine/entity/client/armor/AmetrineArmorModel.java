package net.nick.ametrine.entity.client.armor;

import net.minecraft.util.Identifier;
import net.nick.ametrine.Ametrine;
import net.nick.ametrine.item.custom.AmetrineArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AmetrineArmorModel extends AnimatedGeoModel<AmetrineArmorItem> {
    @Override
    public Identifier getModelResource(AmetrineArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "geo/ametrine_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(AmetrineArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "textures/models/armor/ametrine_armor.png");
    }

    @Override
    public Identifier getAnimationResource(AmetrineArmorItem animatable) {
        return new Identifier(Ametrine.MOD_ID, "animations/armor_animation.json");
    }
}
