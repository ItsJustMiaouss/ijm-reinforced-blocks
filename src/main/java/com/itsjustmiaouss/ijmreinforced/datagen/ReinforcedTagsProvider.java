package com.itsjustmiaouss.ijmreinforced.datagen;

import com.itsjustmiaouss.ijmreinforced.block.ReinforcedBlocks;
import com.itsjustmiaouss.ijmreinforced.reference.ReinforcedTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemId;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.BlockTags.*;

public class ReinforcedTagsProvider extends FabricTagsProvider.BlockTagsProvider {

    private static final List<TagKey<Block>> SHARED_TAGS = List.of(
            WITHER_IMMUNE, DRAGON_IMMUNE, OCCLUDES_VIBRATION_SIGNALS,
            MINEABLE_WITH_PICKAXE, NEEDS_DIAMOND_TOOL, BLOCKS_LAVA_FIRE_SPREAD,
            BLOCKS_WIND_CHARGE_EXPLOSIONS, CAUSES_SUFFOCATION
    );

    public ReinforcedTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        builder(ReinforcedTags.REINFORCED_BLOCKS).add(ReinforcedBlocks.getReinforcedBlockIds().toArray(BlockItemId[]::new));

        SHARED_TAGS.forEach(tag -> builder(tag).addTag(ReinforcedTags.REINFORCED_BLOCKS));
    }
}
