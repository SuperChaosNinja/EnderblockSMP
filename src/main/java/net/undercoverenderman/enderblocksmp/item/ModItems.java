package net.undercoverenderman.enderblocksmp.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.undercoverenderman.enderblocksmp.EnderblockSMP;
import net.undercoverenderman.enderblocksmp.entity.ModEntities;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EnderblockSMP.MOD_ID);

    public static final DeferredItem<Item> KMECH = ITEMS.register("kineticmechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SAW = ITEMS.register("craftingsaw",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GBEAN_SPAWN_EGG = ITEMS.register("greenbean_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.GBEAN, 0x93c572, 0xffdf00,
                    new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
