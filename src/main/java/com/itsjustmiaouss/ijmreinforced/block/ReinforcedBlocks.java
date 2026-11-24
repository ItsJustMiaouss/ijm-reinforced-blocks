package com.itsjustmiaouss.ijmreinforced.block;

import com.itsjustmiaouss.ijmreinforced.block.reinforced.ReinforcedBlock;
import com.itsjustmiaouss.ijmreinforced.block.reinforced.ReinforcedRedstoneBlock;
import com.itsjustmiaouss.ijmreinforced.block.reinforced.ReinforcedStone;
import com.itsjustmiaouss.ijmreinforced.reference.ReinforcedBlockItemIds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ReinforcedBlocks {

    private static final LinkedHashMap<Block, AbstractReinforcedBlock> reinforcedBlocks = new LinkedHashMap<>();

    public static final Block REINFORCED_STONE = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_STONE, (_, properties) -> new ReinforcedStone(properties), Blocks.STONE);
    public static final Block REINFORCED_STONE_BRICKS = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_STONE_BRICKS, ReinforcedBlock::new, Blocks.STONE_BRICKS);

    public static final Block REINFORCED_POLISHED_GRANITE = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_POLISHED_GRANITE, ReinforcedBlock::new, Blocks.POLISHED_GRANITE);
    public static final Block REINFORCED_POLISHED_DIORITE = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_POLISHED_DIORITE, ReinforcedBlock::new, Blocks.POLISHED_DIORITE);
    public static final Block REINFORCED_POLISHED_ANDESITE = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_POLISHED_ANDESITE, ReinforcedBlock::new, Blocks.POLISHED_ANDESITE);

    public static final Block REINFORCED_DEEPSLATE_BRICKS = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_DEEPSLATE_BRICKS, ReinforcedBlock::new, Blocks.DEEPSLATE_BRICKS);
    public static final Block REINFORCED_POLISHED_DEEPSLATE = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_POLISHED_DEEPSLATE, ReinforcedBlock::new, Blocks.POLISHED_DEEPSLATE);
    public static final Block REINFORCED_CHISELED_DEEPSLATE = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_CHISELED_DEEPSLATE, ReinforcedBlock::new, Blocks.CHISELED_DEEPSLATE);
    public static final Block REINFORCED_DEEPSLATE_TILES = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_DEEPSLATE_TILES, ReinforcedBlock::new, Blocks.DEEPSLATE_TILES);

    public static final Block REINFORCED_BRICKS = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_BRICKS, ReinforcedBlock::new, Blocks.BRICKS);
    public static final Block REINFORCED_PURPUR_BLOCK = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_PURPUR_BLOCK, ReinforcedBlock::new, Blocks.PURPUR_BLOCK);
    public static final Block REINFORCED_END_STONE_BRICKS = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_END_STONE_BRICKS, ReinforcedBlock::new, Blocks.END_STONE_BRICKS);

    public static final Block REINFORCED_OBSIDIAN = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_OBSIDIAN, ReinforcedBlock::new, Blocks.OBSIDIAN);
    public static final Block REINFORCED_CRYING_OBSIDIAN = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_CRYING_OBSIDIAN, ReinforcedBlock::new, Blocks.CRYING_OBSIDIAN);

    public static final Block REINFORCED_IRON_BLOCK = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_IRON_BLOCK, ReinforcedBlock::new, Blocks.IRON_BLOCK);
    public static final Block REINFORCED_COPPER_BLOCK = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_COPPER_BLOCK, ReinforcedBlock::new, Blocks.COPPER_BLOCK.weathering().unaffected());
    public static final Block REINFORCED_GOLD_BLOCK = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_GOLD_BLOCK, ReinforcedBlock::new, Blocks.GOLD_BLOCK);
    public static final Block REINFORCED_REDSTONE_BLOCK = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_REDSTONE_BLOCK, (_, properties) -> new ReinforcedRedstoneBlock(properties), Blocks.REDSTONE_BLOCK);
    public static final Block REINFORCED_EMERALD_BLOCK = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_EMERALD_BLOCK, ReinforcedBlock::new, Blocks.EMERALD_BLOCK);
    public static final Block REINFORCED_LAPIS_BLOCK = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_LAPIS_BLOCK, ReinforcedBlock::new, Blocks.LAPIS_BLOCK);
    public static final Block REINFORCED_DIAMOND_BLOCK = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_DIAMOND_BLOCK, ReinforcedBlock::new, Blocks.DIAMOND_BLOCK);
    public static final Block REINFORCED_NETHERITE_BLOCK = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_NETHERITE_BLOCK, ReinforcedBlock::new, Blocks.NETHERITE_BLOCK);

    public static final Block REINFORCED_POLISHED_TUFF = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_POLISHED_TUFF, ReinforcedBlock::new, Blocks.POLISHED_TUFF);
    public static final Block REINFORCED_TUFF_BRICKS = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_TUFF_BRICKS, ReinforcedBlock::new, Blocks.TUFF_BRICKS);

    public static final Block REINFORCED_NETHER_BRICKS = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_NETHER_BRICKS, ReinforcedBlock::new, Blocks.NETHER_BRICKS);
    public static final Block REINFORCED_CHISELED_NETHER_BRICKS = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_CHISELED_NETHER_BRICKS, ReinforcedBlock::new, Blocks.CHISELED_NETHER_BRICKS);
    public static final Block REINFORCED_RED_NETHER_BRICKS = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_RED_NETHER_BRICKS, ReinforcedBlock::new, Blocks.RED_NETHER_BRICKS);

    public static final Block REINFORCED_CHISELED_POLISHED_BLACKSTONE = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_CHISELED_POLISHED_BLACKSTONE, ReinforcedBlock::new, Blocks.CHISELED_POLISHED_BLACKSTONE);
    public static final Block REINFORCED_POLISHED_BLACKSTONE = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_POLISHED_BLACKSTONE, ReinforcedBlock::new, Blocks.POLISHED_BLACKSTONE);
    public static final Block REINFORCED_POLISHED_BLACKSTONE_BRICKS = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_POLISHED_BLACKSTONE_BRICKS, ReinforcedBlock::new, Blocks.POLISHED_BLACKSTONE_BRICKS);

    public static final Block REINFORCED_QUARTZ_BLOCK = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_QUARTZ_BLOCK, ReinforcedBlock::new, Blocks.QUARTZ_BLOCK);
    public static final Block REINFORCED_QUARTZ_BRICKS = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_QUARTZ_BRICKS, ReinforcedBlock::new, Blocks.QUARTZ_BRICKS);
    public static final Block REINFORCED_SMOOTH_QUARTZ = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_SMOOTH_QUARTZ, ReinforcedBlock::new, Blocks.SMOOTH_QUARTZ);

    /**
     * Get a Collection of the registered reinforced blocks.
     *
     * @return An instance of {@link AbstractReinforcedBlock}.
     */
    public static Collection<AbstractReinforcedBlock> getReinforcedBlocks() {
        return Collections.unmodifiableCollection(reinforcedBlocks.values());
    }

    public static Optional<AbstractReinforcedBlock> getReinforcedFromOriginal(Block original) {
        return Optional.ofNullable(reinforcedBlocks.get(original));
    }

    /**
     * Register a Reinforced Block, an instance of {@link AbstractReinforcedBlock}.
     */
    private static Block registerReinforcedBlock(BlockItemId id, BiFunction<Block, BlockBehaviour.Properties, AbstractReinforcedBlock> blockFactory, Block originalBlock) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .ofFullCopy(originalBlock)
                .strength(originalBlock.defaultDestroyTime() * 2f, 3600000.0f)
                .isValidSpawn(Blocks::never);

        return register(id, props -> {
            AbstractReinforcedBlock block = blockFactory.apply(originalBlock, props);

            var result = reinforcedBlocks.putIfAbsent(originalBlock, block);
            if (result != null) throw new IllegalStateException("Can't add duplicated reinforced block! This value already exists : " + result);

            return block;
        }, properties);
    }

    /**
     * Register a block with an item.
     */
    private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        Block block = register(id.block(), blockFactory, properties);

        BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
        Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

        return block;
    }

    /**
     * Register a block without an item.
     */
    private static Block register(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        Block block = blockFactory.apply(properties.setId(id));

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void initialize() {}

}
