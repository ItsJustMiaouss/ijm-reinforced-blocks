package com.itsjustmiaouss.ijmreinforced.block;

import com.itsjustmiaouss.ijmreinforced.IJMReinforcedBlocks;
import com.itsjustmiaouss.ijmreinforced.block.entity.ReinforcedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public abstract class AbstractReinforcedBlock extends BaseEntityBlock {

    private final Block originalBlock;

    public AbstractReinforcedBlock(Block originalBlock, BlockBehaviour.Properties properties) {
        super(properties);

        this.originalBlock = originalBlock;
    }

    public Block getOriginalBlock() {
        return originalBlock;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NonNull BlockPos pos, @NonNull BlockState state) {
        return new ReinforcedBlockEntity(pos, state);
    }

    @Override
    public void setPlacedBy(@NonNull Level level, @NonNull BlockPos pos, @NonNull BlockState state, @Nullable LivingEntity placer, @NonNull ItemStack itemStack) {
        super.setPlacedBy(level, pos, state, placer, itemStack);

        if (level.isClientSide()) return;
        if (!(placer instanceof Player player)) return;
        IJMReinforcedBlocks.LOGGER.info("placed by {}", player.getName());

        if (level.getBlockEntity(pos) instanceof ReinforcedBlockEntity blockEntity) {
            blockEntity.setOwner(player);
        }
    }

}
