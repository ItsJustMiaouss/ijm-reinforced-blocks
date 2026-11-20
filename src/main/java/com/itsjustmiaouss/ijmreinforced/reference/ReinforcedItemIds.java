package com.itsjustmiaouss.ijmreinforced.reference;

import com.itsjustmiaouss.ijmreinforced.IJMReinforcedBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ReinforcedItemIds {

    public static final ResourceKey<Item> REINFORCER_ITEM = create("reinforcer");

    public static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, IJMReinforcedBlocks.id(name));
    }

}
