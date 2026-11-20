package item.tab;

import com.itsjustmiaouss.ijmreinforced.IJMReinforcedBlocks;
import com.itsjustmiaouss.ijmreinforced.block.ReinforcedBlocks;
import item.ReinforcedItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ReinforcedCreativeTabs {

    public static final ResourceKey<CreativeModeTab> REINFORCED_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), IJMReinforcedBlocks.id("reinforced_tab")
    );

    public static final CreativeModeTab REINFORCED_TAB = FabricCreativeModeTab.builder()
            .title(Component.translatable("creativeTab." + IJMReinforcedBlocks.MOD_ID))
            .icon(() -> new ItemStack(ReinforcedItems.REINFORCER_ITEM))
            .displayItems((params, output) -> {
                ReinforcedBlocks.getReinforcedBlocks().forEach(output::accept);
                output.accept(ReinforcedItems.REINFORCER_ITEM);
            })
            .build();

}
