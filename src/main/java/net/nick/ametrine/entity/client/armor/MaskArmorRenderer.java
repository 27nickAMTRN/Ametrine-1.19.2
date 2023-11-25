package net.nick.ametrine.entity.client.armor;

import net.nick.ametrine.item.custom.HornsArmorItem;
import net.nick.ametrine.item.custom.MaskArmorItem;
import net.nick.ametrine.item.custom.RobesArmorItem;
import net.nick.ametrine.item.custom.RoyalArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class MaskArmorRenderer extends GeoArmorRenderer<MaskArmorItem> {
    public MaskArmorRenderer() {
        super(new MaskArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorLeftArm";
        this.leftArmBone = "armorRightArm";
        this.leftLegBone = "armorLeftLeg";
        this.rightLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";

    }
}