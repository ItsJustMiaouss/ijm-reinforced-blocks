package com.itsjustmiaouss.ijmreinforced.block;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.itsjustmiaouss.ijmreinforced.block.reinforced.ReinforcedBlock;
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

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ReinforcedBlocks {

//    private static final Set<AbstractReinforcedBlock> reinforcedBlocks = new HashSet<>();
//    private static final Set<BlockItemId> reinforcedBlockIds = new LinkedHashSet<>();

    private static final BiMap<BlockItemId, AbstractReinforcedBlock> reinforcedBlocks = HashBiMap.create();

    public static final Block REINFORCED_STONE = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_STONE, (_, properties) -> new ReinforcedStone(properties), Blocks.STONE);
    public static final Block REINFORCED_DEEPSLATE_BRICKS = registerReinforcedBlock(ReinforcedBlockItemIds.REINFORCED_DEEPSLATE_BRICKS, ReinforcedBlock::new, Blocks.DEEPSLATE_BRICKS);
    /**
     * Get a Set of the registered reinforced blocks.
     *
     * @return An instance of {@link AbstractReinforcedBlock}.
     */
    public static Set<AbstractReinforcedBlock> getReinforcedBlocks() {
        return Collections.unmodifiableSet(reinforcedBlocks.values());
    }

    /**
     * Get the ids of the registered reinforced blocks, in registration order.
     */
    public static Set<BlockItemId> getReinforcedBlockIds() {
        return Collections.unmodifiableSet(reinforcedBlocks.keySet());
    }

    /**
     * Register a Reinforced Block, an instance of {@link AbstractReinforcedBlock}.
     */
    private static Block registerReinforcedBlock(BlockItemId id, BiFunction<Block, BlockBehaviour.Properties, AbstractReinforcedBlock> blockFactory, Block originalBlock) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties
                .ofFullCopy(originalBlock)
                .strength(6.5f, 3600000.0f)
                .isValidSpawn(Blocks::never);

        return register(id, props -> {
            AbstractReinforcedBlock block = blockFactory.apply(originalBlock, props);
            reinforcedBlocks.put(id, block);
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
