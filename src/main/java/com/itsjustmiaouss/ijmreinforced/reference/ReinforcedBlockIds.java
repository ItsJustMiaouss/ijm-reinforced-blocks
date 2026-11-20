package com.itsjustmiaouss.ijmreinforced.reference;

import com.itsjustmiaouss.ijmreinforced.IJMReinforcedBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class ReinforcedBlockIds {

//    public static final ResourceKey<Block> REINFORCED_STONE = create("reinforced_stone");

    private static ResourceKey<Block> create(String name) {
        Identifier id = IJMReinforcedBlocks.id(name);
        return ResourceKey.create(Registries.BLOCK, id);
    }
}
