package com.itsjustmiaouss.ijmreinforced.item;

import com.itsjustmiaouss.ijmreinforced.block.AbstractReinforcedBlock;
import com.itsjustmiaouss.ijmreinforced.block.ReinforcedBlocks;
import com.itsjustmiaouss.ijmreinforced.block.entity.ReinforcedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.Optional;

public class ReinforcerItem extends Item {

    public ReinforcerItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult useOn(@NonNull UseOnContext context) {
        Level level = context.getLevel();

        BlockPos clickedPos = context.getClickedPos();
        Block block = level.getBlockState(clickedPos).getBlock();
        Player player = context.getPlayer();
        ItemStack itemInHand = context.getItemInHand();

        if (player == null) return InteractionResult.PASS;

        Optional<AbstractReinforcedBlock> reinforcedBlock = ReinforcedBlocks.getReinforcedFromOriginal(block);

        if (reinforcedBlock.isEmpty()) return InteractionResult.PASS;
        if (level.isClientSide()) return InteractionResult.SUCCESS;
        if (!level.mayInteract(player, clickedPos)) return InteractionResult.PASS;

        level.setBlockAndUpdate(clickedPos, reinforcedBlock.get().defaultBlockState());
        if (level.getBlockEntity(clickedPos) instanceof ReinforcedBlockEntity reinforcedBlockEntity) {
            reinforcedBlockEntity.setOwner(player);
            itemInHand.hurtAndBreak(1, player, context.getHand());
            level.playSound(null, clickedPos, SoundEvents.NETHER_BRICKS_PLACE, SoundSource.BLOCKS, 1f, 1f);

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
