package com.itsjustmiaouss.ijmreinforced.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ReinforcedDataGen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ReinforcedLootTableProvider::new);
		pack.addProvider(ReinforcedTagsProvider::new);
		pack.addProvider(ReinforcedModelProvider::new);

		pack.addProvider(ReinforcedEnglishLangProvider::new);
	}
}
