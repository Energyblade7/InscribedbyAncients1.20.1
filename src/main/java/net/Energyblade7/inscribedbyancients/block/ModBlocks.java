package net.Energyblade7.inscribedbyancients.block;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.block.custom.InscribedBlocks;
import net.Energyblade7.inscribedbyancients.block.custom.OreBlocks;
import net.Energyblade7.inscribedbyancients.block.custom.ReclaimedEarths;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, InscribedbyAncients.MOD_ID);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    //-----------------------------------------------------------------------------------------------------------------

    public static final RegistryObject<Block> INSCRIBED_MOSSY_STONE_BRICK = registerBlock("inscribed_mossy_stone_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(9F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_CRACKED_STONE_BRICK = registerBlock("inscribed_cracked_stone_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(9F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_STONE_BRICK = registerBlock("inscribed_stone_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(9F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_DEEPSLATE_BRICK = registerBlock("inscribed_deepslate_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(9F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_CRACKED_DEEPSLATE_BRICK = registerBlock("inscribed_cracked_deepslate_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(9F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_DEEPSLATE_TILE = registerBlock("inscribed_deepslate_tiles",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(9F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_CRACKED_DEEPSLATE_TILE = registerBlock("inscribed_cracked_deepslate_tiles",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(9F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RECLAIMED_SAND = registerBlock("reclaimed_sand",
            () -> new ReclaimedEarths(BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_SAND)
                    .strength(9F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RECLAIMED_GRAVEL = registerBlock("reclaimed_gravel",
            () -> new ReclaimedEarths(BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_GRAVEL)
                    .strength(9F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RECLAIMED_DIRT = registerBlock("reclaimed_dirt",
            () -> new ReclaimedEarths(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)
                    .strength(9F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NETHER_ANTHRACITE_ORE = registerBlock("nether_anthracite_ore",
            () -> new OreBlocks(3, BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(6F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NETHER_ANTHRACITE_BLOCK =registerBlock("nether_anthracite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(6F)
                    .requiresCorrectToolForDrops()));


   //------------------------------------------------------------------------------------------------------------------
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
