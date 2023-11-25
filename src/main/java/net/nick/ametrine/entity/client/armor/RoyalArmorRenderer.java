package net.nick.ametrine.entity.client.armor;

import net.nick.ametrine.item.custom.RoyalArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class RoyalArmorRenderer extends GeoArmorRenderer<RoyalArmorItem> {
    public RoyalArmorRenderer() {
        super(new RoyalArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.leftLegBone = "armorLeftLeg";
        this.rightLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";

    }
}