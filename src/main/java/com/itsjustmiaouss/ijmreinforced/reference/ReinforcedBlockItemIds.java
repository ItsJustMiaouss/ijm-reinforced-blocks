package com.itsjustmiaouss.ijmreinforced.reference;

import com.itsjustmiaouss.ijmreinforced.IJMReinforcedBlocks;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

public class ReinforcedBlockItemIds {

    public static final BlockItemId REINFORCED_STONE = create("reinforced_stone");
    public static final BlockItemId REINFORCED_STONE_BRICKS = create("reinforced_stone_bricks");

    public static final BlockItemId REINFORCED_POLISHED_GRANITE = create("reinforced_polished_granite");
    public static final BlockItemId REINFORCED_POLISHED_ANDESITE = create("reinforced_polished_andesite");
    public static final BlockItemId REINFORCED_POLISHED_DIORITE = create("reinforced_polished_diorite");

    public static final BlockItemId REINFORCED_DEEPSLATE_BRICKS = create("reinforced_deepslate_bricks");
    public static final BlockItemId REINFORCED_POLISHED_DEEPSLATE = create("reinforced_polished_deepslate");
    public static final BlockItemId REINFORCED_CHISELED_DEEPSLATE = create("reinforced_chiseled_deepslate");
    public static final BlockItemId REINFORCED_DEEPSLATE_TILES = create("reinforced_deepslate_tiles");

    public static final BlockItemId REINFORCED_BRICKS = create("reinforced_bricks");
    public static final BlockItemId REINFORCED_PURPUR_BLOCK = create("reinforced_purpur_block");
    public static final BlockItemId REINFORCED_END_STONE_BRICKS = create("reinforced_end_stone_bricks");

    public static BlockItemId create(String name) {
        Identifier id = IJMReinforcedBlocks.id(name);
        return BlockItemId.create(id, id);
    }

}
