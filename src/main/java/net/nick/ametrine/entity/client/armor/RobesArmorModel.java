package net.nick.ametrine.entity.client.armor;

import net.minecraft.util.Identifier;
import net.nick.ametrine.Ametrine;
import net.nick.ametrine.item.custom.RobesArmorItem;
import net.nick.ametrine.item.custom.RoyalArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RobesArmorModel extends AnimatedGeoModel<RobesArmorItem> {
    @Override
    public Identifier getModelResource(RobesArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "geo/mialee_robes_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(RobesArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "textures/models/armor/mialee_robes_armor.png");
    }

    @Override
    public Identifier getAnimationResource(RobesArmorItem animatable) {
        return new Identifier(Ametrine.MOD_ID, "animations/armor_animation.json");
    }
}
