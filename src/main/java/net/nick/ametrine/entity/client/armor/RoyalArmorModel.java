package net.nick.ametrine.entity.client.armor;

import net.minecraft.util.Identifier;
import net.nick.ametrine.Ametrine;
import net.nick.ametrine.item.custom.RoyalArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RoyalArmorModel extends AnimatedGeoModel<RoyalArmorItem> {
    @Override
    public Identifier getModelResource(RoyalArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "geo/royal_ametrine_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(RoyalArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "textures/models/armor/royal_ametrine_armor.png");
    }

    @Override
    public Identifier getAnimationResource(RoyalArmorItem animatable) {
        return new Identifier(Ametrine.MOD_ID, "animations/armor_animation.json");
    }
}
