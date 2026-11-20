package com.itsjustmiaouss.ijmreinforced.block.reinforced;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ReinforcedStone extends ReinforcedBlock implements SilkTouchable {

    public ReinforcedStone(Properties properties) {
        super(Blocks.STONE, properties);
    }

    @Override
    public Block withoutSilkTouchDrop() {
        return Blocks.COBBLESTONE;
    }
}
