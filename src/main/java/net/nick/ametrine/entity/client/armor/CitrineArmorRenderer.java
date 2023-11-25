package net.nick.ametrine.entity.client.armor;

import net.nick.ametrine.item.custom.CitrineArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CitrineArmorRenderer extends GeoArmorRenderer<CitrineArmorItem> {
    public CitrineArmorRenderer() {
        super(new CitrineArmorModel());

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