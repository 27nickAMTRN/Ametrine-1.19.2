package net.nick.ametrine.entity.client.armor;

import net.minecraft.util.Identifier;
import net.nick.ametrine.Ametrine;
import net.nick.ametrine.item.custom.CitrineArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CitrineArmorModel extends AnimatedGeoModel<CitrineArmorItem> {
    @Override
    public Identifier getModelResource(CitrineArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "geo/citrine_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(CitrineArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "textures/models/armor/citrine_armor.png");
    }

    @Override
    public Identifier getAnimationResource(CitrineArmorItem animatable) {
        return new Identifier(Ametrine.MOD_ID, "animations/armor_animation.json");
    }
}
