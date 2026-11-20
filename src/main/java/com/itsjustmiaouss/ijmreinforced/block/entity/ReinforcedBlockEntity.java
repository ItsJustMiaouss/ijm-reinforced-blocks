package com.itsjustmiaouss.ijmreinforced.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.UUIDUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.UUID;

public class ReinforcedBlockEntity extends BlockEntity {

    private @Nullable UUID ownerUuid;
    private @Nullable String ownerName;

    public ReinforcedBlockEntity(BlockPos pos, BlockState state) {
        super(ReinforcedBlockEntities.REINFORCED_BLOCK_ENTITY, pos, state);
    }

    public void setOwner(Player player) {
        this.ownerUuid = player.getUUID();
        this.ownerName = player.getPlainTextName();

        setChanged();
    }

    public @Nullable UUID getOwnerUuid() {
        return this.ownerUuid;
    }

    public boolean isOwner(Player player) {
        return  this.ownerUuid != null && this.ownerUuid.equals(player.getUUID());
    }

    public @Nullable String getOwnerName() {
        return this.ownerName;
    }

    public void refreshOwnerName(Player player) {
        // Only if the owner match
        if (!player.getUUID().equals(this.ownerUuid)) return;

        this.ownerName = player.getPlainTextName();
    }

    @Override
    protected void saveAdditional(@NonNull ValueOutput output) {
        if (this.ownerUuid != null && this.ownerName != null) {
            output.store("ownerUuid", UUIDUtil.CODEC, this.ownerUuid);
            output.putString("ownerName", this.ownerName);
        }

        super.saveAdditional(output);
    }

    @Override
    protected void loadAdditional(@NonNull ValueInput input) {
        super.loadAdditional(input);

        this.ownerUuid = input.read("ownerUuid", UUIDUtil.CODEC).orElse(null);
        this.ownerName = input.getString("ownerName").orElse(null);
    }

    @Override
    public @NonNull CompoundTag getUpdateTag(HolderLookup.@NonNull Provider registries) {
        return saveWithFullMetadata(registries);
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void setChanged() {
        super.setChanged();

        if (level == null) return;
        BlockState state = getBlockState();
        level.sendBlockUpdated(worldPosition, state, state, Block.UPDATE_ALL);
    }
}
