package com.itsjustmiaouss.ijmreinforced.block.reinforced;

import net.minecraft.world.level.block.Block;

/**
 * Represents a reinforced block that drops a specific
 * item when the used tool isn't enchanted with Silk Touch.
 */
public interface SilkTouchable {

    Block withoutSilkTouchDrop();

}
