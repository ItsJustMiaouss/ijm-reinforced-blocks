package com.itsjustmiaouss.ijmreinforced.event;

import com.itsjustmiaouss.ijmreinforced.block.entity.ReinforcedBlockEntity;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jspecify.annotations.NonNull;

public class AttackBlockEvent implements AttackBlockCallback {

    @Override
    public @NonNull InteractionResult interact(Player player, @NonNull Level level, @NonNull InteractionHand hand, @NonNull BlockPos pos, @NonNull Direction direction) {
        if (player.isCreative()) return InteractionResult.PASS;

        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (blockEntity instanceof ReinforcedBlockEntity reinforcedBlockEntity) {
            if (reinforcedBlockEntity.getOwnerUuid() == null || !reinforcedBlockEntity.getOwnerUuid().equals(player.getUUID())) {
                return InteractionResult.FAIL;
            }
        }

        return InteractionResult.PASS;
    }
}
