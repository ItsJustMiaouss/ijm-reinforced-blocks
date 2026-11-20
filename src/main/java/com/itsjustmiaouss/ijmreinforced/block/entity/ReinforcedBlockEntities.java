package com.itsjustmiaouss.ijmreinforced.block.entity;

import com.itsjustmiaouss.ijmreinforced.IJMReinforcedBlocks;
import com.itsjustmiaouss.ijmreinforced.block.ReinforcedBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ReinforcedBlockEntities {

    public static final BlockEntityType<ReinforcedBlockEntity> REINFORCED_BLOCK_ENTITY =
            registerReinforcedBlockEntity(ReinforcedBlocks.getReinforcedBlocks().toArray(Block[]::new));

    public static BlockEntityType<ReinforcedBlockEntity> registerReinforcedBlockEntity(Block... blocks) {
        return register("reinforced_block_entity", ReinforcedBlockEntity::new, blocks);
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name,
            FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
            Block... blocks
    ) {
        Identifier id = IJMReinforcedBlocks.id(name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    public static void initialize() {}
}
