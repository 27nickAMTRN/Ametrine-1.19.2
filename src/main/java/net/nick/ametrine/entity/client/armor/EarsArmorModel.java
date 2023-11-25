package net.nick.ametrine.entity.client.armor;

import net.minecraft.util.Identifier;
import net.nick.ametrine.Ametrine;
import net.nick.ametrine.item.custom.EarsArmorItem;
import net.nick.ametrine.item.custom.HornsArmorItem;
import net.nick.ametrine.item.custom.RobesArmorItem;
import net.nick.ametrine.item.custom.RoyalArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EarsArmorModel extends AnimatedGeoModel<EarsArmorItem> {
    @Override
    public Identifier getModelResource(EarsArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "geo/elf_ears_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(EarsArmorItem object) {
        return new Identifier(Ametrine.MOD_ID, "textures/models/armor/elf_ears_armor.png");
    }

    @Override
    public Identifier getAnimationResource(EarsArmorItem animatable) {
        return new Identifier(Ametrine.MOD_ID, "animations/armor_animation.json");
    }
}
