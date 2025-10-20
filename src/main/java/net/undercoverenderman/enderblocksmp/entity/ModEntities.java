package net.undercoverenderman.enderblocksmp.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.undercoverenderman.enderblocksmp.EnderblockSMP;
import net.undercoverenderman.enderblocksmp.entity.custom.GreenBeanEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, EnderblockSMP.MOD_ID);

    public static final Supplier<EntityType<GreenBeanEntity>> GBEAN =
            ENTITY_TYPES.register("greenbean", () -> EntityType.Builder.of(GreenBeanEntity::new, MobCategory.MONSTER)
                    .sized(1.0f, 2.0f).build("greenbean"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
