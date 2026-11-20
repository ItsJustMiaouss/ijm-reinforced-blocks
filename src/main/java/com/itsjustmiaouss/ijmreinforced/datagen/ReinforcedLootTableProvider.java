package com.itsjustmiaouss.ijmreinforced.datagen;

import com.itsjustmiaouss.ijmreinforced.block.ReinforcedBlocks;
import com.itsjustmiaouss.ijmreinforced.block.reinforced.SilkTouchable;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ReinforcedLootTableProvider extends FabricBlockLootSubProvider {

    protected ReinforcedLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        ReinforcedBlocks.getReinforcedBlocks().forEach(reinforcedBlock -> {
            Block original = reinforcedBlock.getOriginalBlock();

            if (reinforcedBlock instanceof SilkTouchable silkTouchable) {
                this.add(reinforcedBlock, this.createSingleItemTableWithSilkTouch(original, silkTouchable.withoutSilkTouchDrop()));
            } else {
                this.dropOther(reinforcedBlock, original);
            }

        });
    }
}
