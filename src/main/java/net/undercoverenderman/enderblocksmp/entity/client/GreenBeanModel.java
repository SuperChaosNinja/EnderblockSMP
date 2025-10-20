package net.undercoverenderman.enderblocksmp.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.undercoverenderman.enderblocksmp.EnderblockSMP;
import net.undercoverenderman.enderblocksmp.entity.custom.GreenBeanEntity;

public class GreenBeanModel<T extends GreenBeanEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(EnderblockSMP.MOD_ID, "greenbean"), "main");
    private final ModelPart Greenbean;
    private final ModelPart legs;
    private final ModelPart leg2;
    private final ModelPart leg1;
    private final ModelPart arms;
    private final ModelPart Arm1;
    private final ModelPart Arm2;
    private final ModelPart head;
    private final ModelPart body;

    public GreenBeanModel(ModelPart root) {
        this.Greenbean = root.getChild("Greenbean");
        this.legs = this.Greenbean.getChild("legs");
        this.leg2 = this.legs.getChild("leg2");
        this.leg1 = this.legs.getChild("leg1");
        this.arms = this.Greenbean.getChild("arms");
        this.Arm1 = this.arms.getChild("Arm1");
        this.Arm2 = this.arms.getChild("Arm2");
        this.head = this.Greenbean.getChild("head");
        this.body = this.Greenbean.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Greenbean = partdefinition.addOrReplaceChild("Greenbean", CubeListBuilder.create().texOffs(8, 8).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition legs = Greenbean.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -1.0F));

        PartDefinition leg2 = legs.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(8, 24).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -2.0F, 0.0F));

        PartDefinition leg1 = legs.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 8).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -2.0F, 0.0F));

        PartDefinition arms = Greenbean.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition Arm1 = arms.addOrReplaceChild("Arm1", CubeListBuilder.create().texOffs(16, 24).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 0.0F));

        PartDefinition Arm2 = arms.addOrReplaceChild("Arm2", CubeListBuilder.create().texOffs(20, 8).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, 0.0F));

        PartDefinition head = Greenbean.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -1.0F));

        PartDefinition body = Greenbean.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, -1.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(GreenBeanEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotiation(netHeadYaw, headPitch);

        this.animateWalk(GreenBeanAnimations.ANIM_GBEAN_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, GreenBeanAnimations.ANIM_GBEAN_IDLE, ageInTicks, 1f);
    }

    private void applyHeadRotiation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head.yRot = headYaw * ((float)Math.PI / 180f);
        this.head.xRot = headPitch * ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Greenbean.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return Greenbean;
    }
}
