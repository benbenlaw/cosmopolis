package com.benbenlaw.cosmopolis.item.custom;

import com.benbenlaw.cosmopolis.block.ModBlocks;
import com.benbenlaw.cosmopolis.block.custom.MiningBeltPortalBlock;
import com.benbenlaw.cosmopolis.block.custom.SpacePortalBlock;
import com.benbenlaw.cosmopolis.item.ModCreativeModTab;
import com.benbenlaw.cosmopolis.world.dimension.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SpaceCoreItem extends Item {
    public SpaceCoreItem() {
        super(new Properties()
                .tab(ModCreativeModTab.COSMOPOLIS)
                .stacksTo(1)
                .rarity(Rarity.RARE)
        );
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer() != null) {
            if(context.getPlayer().level.dimension() == ModDimensions.SPACE
                    || context.getPlayer().level.dimension() == ModDimensions.MINING_BELT) {
                for(Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if(((SpacePortalBlock) ModBlocks.SPACE_PORTAL.get()).trySpawnPortal(context.getLevel(), framePos)) {
                        context.getLevel().playSound(context.getPlayer(), framePos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    }
                    if(((MiningBeltPortalBlock) ModBlocks.MINING_BELT_PORTAL.get()).trySpawnPortal(context.getLevel(), framePos)) {
                        context.getLevel().playSound(context.getPlayer(), framePos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    }
                    else return InteractionResult.FAIL;
                }
            }
        }
        return InteractionResult.FAIL;
    }
}