package com.benbenlaw.cosmopolis.entity;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.entity.custom.UFOEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class UFORenderer extends MobRenderer<UFOEntity, UFOModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Cosmopolis.MOD_ID,
            "textures/entity/ufo.png");

    public UFORenderer(EntityRendererProvider.Context context) {
        super(context, new UFOModel(context.bakeLayer(UFOModel.LAYER_LOCATION)), 1f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull UFOEntity pEntity) {
        return TEXTURE;
    }
}