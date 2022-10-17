package com.benbenlaw.cosmopolis.block;

import com.benbenlaw.cosmopolis.Cosmopolis;

import com.benbenlaw.cosmopolis.block.custom.*;
import com.benbenlaw.cosmopolis.item.ModCreativeModTab;
import com.benbenlaw.cosmopolis.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Cosmopolis.MOD_ID);


    public static final RegistryObject<Block> GRAVITY_GENERATOR = registerBlock("gravity_generator",
            () -> new GravityGeneratorBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(2.0f, 2.0f)
                    .noOcclusion()
                    .sound(SoundType.STONE)));


    //New Blocks

    public static final RegistryObject<Block> BLACKSTONE_DEBRIS_ORE = registerBlock("blackstone_debris_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0f, 6f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> BLACKSTONE_EMERALD_ORE = registerBlock("blackstone_emerald_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0f, 6f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> BLACKSTONE_DIAMOND_ORE = registerBlock("blackstone_diamond_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0f, 6f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> BLACKSTONE_OSMIUM_ORE = registerBlock("blackstone_osmium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0f, 6f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> BLACKSTONE_URANIUM_ORE = registerBlock("blackstone_uranium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0f, 6f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ASTEROID_BLOCK = registerBlock("asteroid_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0f, 6f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ARTIFICIAL_PLANKS = registerBlock("artificial_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0f, 3f).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> VENUS_FUNGUS = registerBlock("venus_fungus",
            () -> new Block(BlockBehaviour.Properties.of(Material.PLANT).strength(0.5f, 0.5f).sound(SoundType.CROP)));

    public static final RegistryObject<Block> MARS_FUNGUS = registerBlock("mars_fungus",
            () -> new Block(BlockBehaviour.Properties.of(Material.PLANT).strength(0.5f, 0.5f).sound(SoundType.CROP)));

    public static final RegistryObject<Block> SPACE_PORTAL_FRAME = registerBlock("space_portal_frame",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.5f, 0.5f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> MINING_BELT_PORTAL_FRAME = registerBlock("mining_belt_portal_frame",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.5f, 0.5f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> VENUS_PORTAL_FRAME = registerBlock("venus_portal_frame",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.5f, 0.5f).sound(SoundType.STONE)));

    public static final RegistryObject<Block>MARS_PORTAL_FRAME = registerBlock("mars_portal_frame",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.5f, 0.5f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> MOON_PORTAL_FRAME = registerBlock("moon_portal_frame",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.5f, 0.5f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> GLOWSTONE_LANTERN = registerBlock("glowstone_lantern",
            () -> new GlowstoneLanternBlock(BlockBehaviour.Properties.of(Material.METAL).strength(3.5f).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
                    .lightLevel((state) -> 14)
                    .noOcclusion()
                    .sound(SoundType.LANTERN)));

    //Blocks Without Items

    public static final RegistryObject<Block> SPACE_PORTAL = BLOCKS.register("space_portal",
            SpacePortalBlock::new);

    public static final RegistryObject<Block> MINING_BELT_PORTAL = BLOCKS.register("mining_belt_portal",
            MiningBeltPortalBlock::new);

    public static final RegistryObject<Block> VENUS_PORTAL = BLOCKS.register("venus_portal",
            VenusPortalBlock::new);

    public static final RegistryObject<Block> MARS_PORTAL = BLOCKS.register("mars_portal",
            MarsPortalBlock::new);

    public static final RegistryObject<Block> MOON_PORTAL = BLOCKS.register("moon_portal",
            MoonPortalBlock::new);

    public static final RegistryObject<Block> GLOWSTONE_TORCH = BLOCKS.register("glowstone_torch",
            () -> new GlowstoneTorchBlock(BlockBehaviour.Properties.copy(Blocks.TORCH).lightLevel((state) -> 14)));

    public static final RegistryObject<Block> GLOWSTONE_WALL_TORCH = BLOCKS.register("glowstone_wall_torch",
            () -> new GlowstoneWallTorchBlock(BlockBehaviour.Properties.copy(Blocks.WALL_TORCH).lightLevel((state) -> 14).lootFrom(ModBlocks.GLOWSTONE_TORCH)));





    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, String tooltipKey) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(Component.literal(tooltipKey));
            }
        });

    }



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModTab.COSMOPOLIS)));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
