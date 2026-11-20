package com.itsjustmiaouss.ijmreinforced.item;

import com.itsjustmiaouss.ijmreinforced.reference.ReinforcedItemIds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ReinforcedItems {

    public static final Item REINFORCER_ITEM = register(
            ReinforcedItemIds.REINFORCER_ITEM,
            ReinforcerItem::new,
            new Item.Properties().stacksTo(1).durability(1000)
    );


    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        Item item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    public static void initialize() {}

}
