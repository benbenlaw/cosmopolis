package com.benbenlaw.cosmopolis.data;

import com.benbenlaw.cosmopolis.Cosmopolis;
import com.benbenlaw.cosmopolis.util.ModTags;
import com.benbenlaw.cosmopolis.world.ModBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ModBiomeTagsProvider extends BiomeTagsProvider {

    public ModBiomeTagsProvider(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, Cosmopolis.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(ModTags.Biomes.IS_MARS)
                .add(ModBiomes.MARTIAN_ICE_CAP)
                .add(ModBiomes.MARTIAN_PLANE);

        tag(ModTags.Biomes.IS_MINING_BELT).add(ModBiomes.MINING_BELT);

        tag(ModTags.Biomes.IS_MOON)
                .add(ModBiomes.MOON)
                .add(ModBiomes.MOON_SATELLITE_GRAVEYARD);

        tag(ModTags.Biomes.IS_SPACE)
                .add(ModBiomes.SPACE);

        tag(ModTags.Biomes.IS_VENUS)
                .add(ModBiomes.VENUS)
                .add(ModBiomes.VENUS_HELLGROUND);

        tag(ModTags.Biomes.NEEDS_SPACE_SUIT)
                .addTag(ModTags.Biomes.IS_VENUS)
                .addTag(ModTags.Biomes.IS_MARS)
                .addTag(ModTags.Biomes.IS_MOON)
                .addTag(ModTags.Biomes.IS_SPACE)
                .addTag(ModTags.Biomes.IS_MINING_BELT);



    }
}