package com.benbenlaw.cosmopolis.block.custom;

import com.benbenlaw.cosmopolis.entity.custom.TeleporterBlockEntity;
import com.benbenlaw.cosmopolis.world.dimension.ModDimensions;
import com.benbenlaw.cosmopolis.world.dimension.SpaceDimensionTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TeleporterBlock extends Block implements EntityBlock {

    public TeleporterBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (player instanceof ServerPlayer) {
            transferPlayer((ServerPlayer) player, pos);
        }
        return InteractionResult.SUCCESS;
    }

    public boolean transferPlayer(ServerPlayer player, BlockPos pos) {
        if (player.getVehicle() != null || player.isVehicle()) {
            return false;
        }

        if (player.level.dimension().equals(ModDimensions.SPACE) ) {
            ServerLevel teleportWorld = player.server.getLevel(Level.OVERWORLD);
            if (teleportWorld == null) {
                return false;
            }
            player.changeDimension(teleportWorld, new SpaceDimensionTeleporter(pos));
        } else if (player.level.dimension().equals(Level.OVERWORLD)) {
            ServerLevel teleportWorld = player.server.getLevel(ModDimensions.SPACE);
            if (teleportWorld == null) {
                return false;
            }
            player.changeDimension(teleportWorld, new SpaceDimensionTeleporter(pos));
        } else {
            player.displayClientMessage(new TranslatableComponent("message.wrong_dimension"), true);
        }

        return true;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TeleporterBlockEntity(pos, state);
    }
}