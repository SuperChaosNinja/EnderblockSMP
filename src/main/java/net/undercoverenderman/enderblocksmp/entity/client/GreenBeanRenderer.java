package net.undercoverenderman.enderblocksmp.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.undercoverenderman.enderblocksmp.EnderblockSMP;
import net.undercoverenderman.enderblocksmp.entity.custom.GreenBeanEntity;

public class GreenBeanRenderer extends MobRenderer<GreenBeanEntity, GreenBeanModel<GreenBeanEntity>> {
    public GreenBeanRenderer(EntityRendererProvider.Context context) {
        super(context, new GreenBeanModel<>(context.bakeLayer(GreenBeanModel.LAYER_LOCATION)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(GreenBeanEntity greenBeanEntity) {
        return ResourceLocation.fromNamespaceAndPath(EnderblockSMP.MOD_ID, "textures/entity/greenbean/greenbean.png");
    }

    @Override
    public void render(GreenBeanEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
