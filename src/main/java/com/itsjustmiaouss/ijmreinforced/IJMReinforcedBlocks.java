package com.itsjustmiaouss.ijmreinforced;

import com.itsjustmiaouss.ijmreinforced.block.ReinforcedBlocks;
import com.itsjustmiaouss.ijmreinforced.block.entity.ReinforcedBlockEntities;
import com.itsjustmiaouss.ijmreinforced.event.AttackBlockEvent;
import com.itsjustmiaouss.ijmreinforced.item.tab.ReinforcedCreativeTabs;
import com.itsjustmiaouss.ijmreinforced.item.ReinforcedItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IJMReinforcedBlocks implements ModInitializer {

	public static final String MOD_ID = "ijmreinforced";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ReinforcedItems.initialize();
		ReinforcedBlocks.initialize();
		ReinforcedBlockEntities.initialize();

		AttackBlockCallback.EVENT.register(new AttackBlockEvent());

		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ReinforcedCreativeTabs.REINFORCED_TAB_KEY, ReinforcedCreativeTabs.REINFORCED_TAB);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
