package com.itsjustmiaouss.ijmreinforced.reference;

import com.itsjustmiaouss.ijmreinforced.IJMReinforcedBlocks;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

public class ReinforcedBlockItemIds {

    public static final BlockItemId REINFORCED_STONE = create("reinforced_stone");
    public static final BlockItemId REINFORCED_DEEPSLATE_BRICKS = create("reinforced_deepslate_bricks");

    public static BlockItemId create(String name) {
        Identifier id = IJMReinforcedBlocks.id(name);
        return BlockItemId.create(id, id);
    }

}
