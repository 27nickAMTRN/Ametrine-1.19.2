package net.nick.ametrine.entity.client.armor;

import net.minecraft.util.Identifier;
import net.nick.ametrine.Ametrine;
import net.nick.ametrine.item.custom.HornsArmorItem;
import net.nick.ametrine.item.custom.RobesArmorItem;
import net.nick.ametrine.item.custom.RoyalArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HornsArmorModel extends AnimatedGeoModel<HornsArmorItem> {
    @Override
    public Identifier getModelResource(HornsArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "geo/ram_horns_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(HornsArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "textures/models/armor/ram_horns_armor.png");
    }

    @Override
    public Identifier getAnimationResource(HornsArmorItem animatable) {
        return new Identifier(Ametrine.MOD_ID, "animations/armor_animation.json");
    }
}
