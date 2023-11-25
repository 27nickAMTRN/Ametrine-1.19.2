package net.nick.ametrine.entity.client.armor;

import net.minecraft.util.Identifier;
import net.nick.ametrine.Ametrine;
import net.nick.ametrine.item.custom.MaskArmorItem;
import net.nick.ametrine.item.custom.RobesArmorItem;
import net.nick.ametrine.item.custom.RoyalArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MaskArmorModel extends AnimatedGeoModel<MaskArmorItem> {
    @Override
    public Identifier getModelResource(MaskArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "geo/masons_mask_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(MaskArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "textures/models/armor/masons_mask_armor.png");
    }

    @Override
    public Identifier getAnimationResource(MaskArmorItem animatable) {
        return new Identifier(Ametrine.MOD_ID, "animations/armor_animation.json");
    }
}
