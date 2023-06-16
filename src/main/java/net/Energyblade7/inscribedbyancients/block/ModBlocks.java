package net.Energyblade7.inscribedbyancients.block;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.block.custom.InscribedBlocks;
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
                    .strength(6F)
                    .noLootTable()
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_CRACKED_STONE_BRICK = registerBlock("inscribed_cracked_stone_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(6F)
                    .noLootTable()
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_STONE_BRICK = registerBlock("inscribed_stone_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(6F)
                    .noLootTable()
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_DEEPSLATE_BRICK = registerBlock("inscribed_deepslate_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(6F)
                    .noLootTable()
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_CRACKED_DEEPSLATE_BRICK = registerBlock("inscribed_cracked_deepslate_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)
                    .strength(6F)
                    .noLootTable()
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_DEEPSLATE_TILE = registerBlock("inscribed_deepslate_tiles",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(6F)
                    .noLootTable()
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_CRACKED_DEEPSLATE_TILE = registerBlock("inscribed_cracked_deepslate_tiles",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(6F)
                    .noLootTable()
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NETHER_ANTHRACITE_ORE = registerBlock("nether_anthracite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
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
