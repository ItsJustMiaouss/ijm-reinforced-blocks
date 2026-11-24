package com.itsjustmiaouss.ijmreinforced.block.reinforced;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class ReinforcedRedstoneBlock extends ReinforcedBlock {

    public ReinforcedRedstoneBlock(BlockBehaviour.Properties properties) {
        super(Blocks.REDSTONE_BLOCK, properties);
    }

    @Override
    protected boolean isSignalSource(@NonNull BlockState state) {
        return true;
    }

    @Override
    protected int ownSignal(@NonNull BlockState state, @NonNull BlockGetter level, @NonNull BlockPos pos) {
        return 15;
    }
}
