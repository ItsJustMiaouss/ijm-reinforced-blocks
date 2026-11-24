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

    public static final BlockItemId REINFORCED_OBSIDIAN = create("reinforced_obsidian");
    public static final BlockItemId REINFORCED_CRYING_OBSIDIAN = create("reinforced_crying_obsidian");

    public static final BlockItemId REINFORCED_IRON_BLOCK = create("reinforced_iron_block");
    public static final BlockItemId REINFORCED_COPPER_BLOCK = create("reinforced_copper_block");
    public static final BlockItemId REINFORCED_GOLD_BLOCK = create("reinforced_gold_block");
    public static final BlockItemId REINFORCED_REDSTONE_BLOCK = create("reinforced_redstone_block");
    public static final BlockItemId REINFORCED_EMERALD_BLOCK = create("reinforced_emerald_block");
    public static final BlockItemId REINFORCED_LAPIS_BLOCK = create("reinforced_lapis_block");
    public static final BlockItemId REINFORCED_DIAMOND_BLOCK = create("reinforced_diamond_block");
    public static final BlockItemId REINFORCED_NETHERITE_BLOCK = create("reinforced_netherite_block");

    public static final BlockItemId REINFORCED_POLISHED_TUFF = create("reinforced_polished_tuff");
    public static final BlockItemId REINFORCED_TUFF_BRICKS = create("reinforced_tuff_bricks");

    public static final BlockItemId REINFORCED_NETHER_BRICKS = create("reinforced_nether_bricks");
    public static final BlockItemId REINFORCED_CHISELED_NETHER_BRICKS = create("reinforced_chiseled_nether_bricks");
    public static final BlockItemId REINFORCED_RED_NETHER_BRICKS = create("reinforced_red_nether_bricks");

    public static final BlockItemId REINFORCED_CHISELED_POLISHED_BLACKSTONE = create("reinforced_chiseled_polished_blackstone");
    public static final BlockItemId REINFORCED_POLISHED_BLACKSTONE = create("reinforced_polished_blackstone");
    public static final BlockItemId REINFORCED_POLISHED_BLACKSTONE_BRICKS = create("reinforced_polished_blackstone_bricks");

    public static final BlockItemId REINFORCED_QUARTZ_BLOCK = create("reinforced_quartz_block");
    public static final BlockItemId REINFORCED_QUARTZ_BRICKS = create("reinforced_quartz_bricks");
    public static final BlockItemId REINFORCED_SMOOTH_QUARTZ = create("reinforced_smooth_quartz");

    public static BlockItemId create(String name) {
        Identifier id = IJMReinforcedBlocks.id(name);
        return BlockItemId.create(id, id);
    }

}
