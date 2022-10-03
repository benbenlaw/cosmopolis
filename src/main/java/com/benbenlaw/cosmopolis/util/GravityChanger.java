package com.benbenlaw.cosmopolis.util;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.world.dimension.ModDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;

public class GravityChanger {

    public static final float SPACE = 0.05F;
    public static final float OVERWORLD = 1.0F;

    public static void changeGravity(LivingEntity entity, Level level, Player player) {



        if (level.dimension().equals(ModDimensions.SPACE)) {
            player.getAttribute(ForgeMod.ENTITY_GRAVITY.get()).setBaseValue(SPACE);
          //  entity.getAttribute(ForgeMod.ENTITY_GRAVITY.get()).setBaseValue(SPACE);
        }

        else if (level.dimension().equals(Level.OVERWORLD)) {
            player.getAttribute(ForgeMod.ENTITY_GRAVITY.get()).setBaseValue(OVERWORLD);


        }
    }
}



