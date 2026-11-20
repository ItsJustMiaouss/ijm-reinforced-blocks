package com.itsjustmiaouss.ijmreinforced;

import com.itsjustmiaouss.ijmreinforced.block.ReinforcedBlocks;
import com.itsjustmiaouss.ijmreinforced.block.entity.ReinforcedBlockEntities;
import com.itsjustmiaouss.ijmreinforced.item.ReinforcedItems;
import com.itsjustmiaouss.ijmreinforced.item.tab.ReinforcedCreativeTabs;
import net.fabricmc.api.ModInitializer;
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
		ReinforcedCreativeTabs.initialize();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
