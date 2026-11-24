package com.itsjustmiaouss.ijmreinforced.datagen;

import com.itsjustmiaouss.ijmreinforced.IJMReinforcedBlocks;
import com.itsjustmiaouss.ijmreinforced.block.ReinforcedBlocks;
import com.itsjustmiaouss.ijmreinforced.item.ReinforcedItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NonNull;

import java.util.Map;
import java.util.Optional;

public class ReinforcedModelProvider extends FabricModelProvider {

    private static final ModelTemplate REINFORCED_CUBE = new ModelTemplate(
            Optional.of(IJMReinforcedBlocks.id("block/reinforced_cube")),
            Optional.empty(),
            TextureSlot.ALL
    );

    // Those blocks have the same textures on all sides, but have separate texture files
    private static final Map<Block, Material> TEXTURE_OVERRIDES = Map.of(
            Blocks.QUARTZ_BLOCK, TextureMapping.getBlockTexture(Blocks.QUARTZ_BLOCK, "_side"),
            Blocks.SMOOTH_QUARTZ, TextureMapping.getBlockTexture(Blocks.QUARTZ_BLOCK, "_bottom")
    );

    public ReinforcedModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators modelGen) {
        ReinforcedBlocks.getReinforcedBlocks().forEach(block -> {
            Block original = block.getOriginalBlock();
            Material material = TEXTURE_OVERRIDES.getOrDefault(original, TextureMapping.getBlockTexture(original));

            TextureMapping textures = new TextureMapping().put(TextureSlot.ALL, material);

            Identifier model = REINFORCED_CUBE.create(block, textures, modelGen.modelOutput);

            modelGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, BlockModelGenerators.plainVariant(model)));
            modelGen.registerSimpleItemModel(block, model);
        });
    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators modelGen) {
        modelGen.generateFlatItem(ReinforcedItems.REINFORCER_ITEM, ModelTemplates.FLAT_HANDHELD_ITEM);
    }
}
