package com.itsjustmiaouss.ijmreinforced.reference;

import com.itsjustmiaouss.ijmreinforced.IJMReinforcedBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ReinforcedTags {

    /** Every reinforced block. Vanilla behaviour tags include this tag instead of listing blocks one by one. */
    public static final TagKey<Block> REINFORCED_BLOCKS = TagKey.create(Registries.BLOCK, IJMReinforcedBlocks.id("reinforced_blocks"));

}
