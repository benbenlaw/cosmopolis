package com.benbenlaw.cosmopolis.block.custom;

import com.benbenlaw.cosmopolis.block.entity.ModBlockEntities;
import com.benbenlaw.cosmopolis.block.entity.custom.GravityGeneratorBlockEntity;
import com.benbenlaw.cosmopolis.config.CosmopolisConfigFile;
import com.benbenlaw.cosmopolis.util.ModTags;
import com.benbenlaw.cosmopolis.world.dimension.ModDimensions;
import com.sun.security.auth.login.ConfigFile;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ForgeBiomeTagsProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GravityGeneratorBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public GravityGeneratorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide) {
            if (pHand.equals(InteractionHand.MAIN_HAND)) {
                if(pLevel.getBiome(pPos).is(ModTags.Biomes.IS_MARS)) {
                    pPlayer.sendSystemMessage(Component.literal("Generating " + CosmopolisConfigFile.gravityGeneratorPowerMars.get() + " RF per tick "));
                }
                if(pLevel.getBiome(pPos).is(ModTags.Biomes.IS_VENUS)) {
                    pPlayer.sendSystemMessage(Component.literal("Generating " + CosmopolisConfigFile.gravityGeneratorPowerVenus.get() + " RF per tick "));
                }
                if(pLevel.getBiome(pPos).is(ModTags.Biomes.IS_MOON)) {
                    pPlayer.sendSystemMessage(Component.literal("Generating " + CosmopolisConfigFile.gravityGeneratorPowerMoon.get() + " RF per tick "));
                }
                if(pLevel.getBiome(pPos).is(ModTags.Biomes.IS_MINING_BELT)) {
                    pPlayer.sendSystemMessage(Component.literal("Generating " + CosmopolisConfigFile.gravityGeneratorPowerMiningBelt.get() + " RF per tick "));
                }
                if(pLevel.getBiome(pPos).is(ModTags.Biomes.IS_SPACE)) {
                    pPlayer.sendSystemMessage(Component.literal("Generating " + CosmopolisConfigFile.gravityGeneratorPowerSpace.get() + " RF per tick "));
                }
                if(pLevel.getBiome(pPos).is(BiomeTags.IS_OVERWORLD)) {
                    pPlayer.sendSystemMessage(Component.literal("Generating " + CosmopolisConfigFile.gravityGeneratorPowerOverworld.get() + " RF per tick "));
                }
                if(pLevel.getBiome(pPos).is(BiomeTags.IS_NETHER)) {
                    pPlayer.sendSystemMessage(Component.literal("Generating " + CosmopolisConfigFile.gravityGeneratorPowerNether.get() + " RF per tick "));
                }
                if(pLevel.getBiome(pPos).is(BiomeTags.IS_END)) {
                    pPlayer.sendSystemMessage(Component.literal("Generating " + CosmopolisConfigFile.gravityGeneratorPowerEnd.get() + " RF per tick "));
                }

            }
        }

        return InteractionResult.SUCCESS;
    }

    /* FACING */


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public @NotNull BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public @NotNull BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }


    // Block Entity Stuff //




    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new GravityGeneratorBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide) return null;
        return createTickerHelper(pBlockEntityType, ModBlockEntities.GRAVITY_GENERATOR.get(),
                GravityGeneratorBlockEntity::serverTick);
    }
}

