package net.undercoverenderman.enderblocksmp.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.undercoverenderman.enderblocksmp.EnderblockSMP;
import net.undercoverenderman.enderblocksmp.entity.ModEntities;
import net.undercoverenderman.enderblocksmp.entity.client.GreenBeanModel;
import net.undercoverenderman.enderblocksmp.entity.custom.GreenBeanEntity;

@EventBusSubscriber(modid = EnderblockSMP.MOD_ID)
public class ModEventsBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GreenBeanModel.LAYER_LOCATION, GreenBeanModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GBEAN.get(), GreenBeanEntity.createAttributes().build());
    }
}
