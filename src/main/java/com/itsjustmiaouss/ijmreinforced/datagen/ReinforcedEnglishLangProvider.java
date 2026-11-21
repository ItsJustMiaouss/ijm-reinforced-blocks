package com.itsjustmiaouss.ijmreinforced.datagen;

import com.itsjustmiaouss.ijmreinforced.IJMReinforcedBlocks;
import com.itsjustmiaouss.ijmreinforced.block.ReinforcedBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ReinforcedEnglishLangProvider extends FabricLanguageProvider {

    protected ReinforcedEnglishLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider registryLookup, @NonNull TranslationBuilder translationBuilder) {
        translationBuilder.add("creativeTab.ijmreinforced", "IJM's Reinforced Blocks");
        translationBuilder.add("item.ijmreinforced.reinforcer", "Reinforcer");

        ReinforcedBlocks.getReinforcedBlocks().forEach(block -> {
            Identifier reinforcedBlockId = BuiltInRegistries.BLOCK.getKey(block);
            Identifier originalBlockId = BuiltInRegistries.BLOCK.getKey(block.getOriginalBlock());

            String originalBlockKey = String.format("block.minecraft.%s", originalBlockId.getPath());
            String originalBlockValue = Component.translatable(originalBlockKey).getString();

            String reinforcedBlockKey = String.format("block.%s.%s", IJMReinforcedBlocks.MOD_ID, reinforcedBlockId.getPath());
            translationBuilder.add(reinforcedBlockKey, "Reinforced " + originalBlockValue);
        });
    }
}
