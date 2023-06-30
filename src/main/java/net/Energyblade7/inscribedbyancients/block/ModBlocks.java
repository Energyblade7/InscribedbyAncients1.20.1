package net.Energyblade7.inscribedbyancients.block;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.block.custom.InscribedBlocks;
import net.Energyblade7.inscribedbyancients.block.custom.OreBlocks;
import net.Energyblade7.inscribedbyancients.block.custom.ReclaimedBlocks;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, InscribedbyAncients.MOD_ID);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, int smeltOperations) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerFuelItem(name, toReturn, smeltOperations * 200);
        return toReturn;
    }


    //-----------------------------------------------------------------------------------------------------------------
    //Put the number of Smelting Operations a Fuel Object should get, not burn time!
    public static final RegistryObject<Block> INSCRIBED_MOSSY_STONE_BRICK = registerBlock("inscribed_mossy_stone_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(6F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_CRACKED_STONE_BRICK = registerBlock("inscribed_cracked_stone_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(6F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_STONE_BRICK = registerBlock("inscribed_stone_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(6F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_DEEPSLATE_BRICK = registerBlock("inscribed_deepslate_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)
                    .strength(6F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_CRACKED_DEEPSLATE_BRICK = registerBlock("inscribed_cracked_deepslate_bricks",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)
                    .strength(6F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_DEEPSLATE_TILE = registerBlock("inscribed_deepslate_tiles",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)
                    .strength(6F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> INSCRIBED_CRACKED_DEEPSLATE_TILE = registerBlock("inscribed_cracked_deepslate_tiles",
            () -> new InscribedBlocks(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)
                    .strength(6F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RECLAIMED_SAND = registerBlock("reclaimed_sand",
            () -> new BrushableBlock(Blocks.SAND, BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_SAND)
                            .strength(1.5F)
                            .requiresCorrectToolForDrops(),
                    SoundEvents.BRUSH_SAND,
                    SoundEvents.BRUSH_SAND_COMPLETED));

    public static final RegistryObject<Block> RECLAIMED_GRAVEL = registerBlock("reclaimed_gravel",
            () -> new BrushableBlock(Blocks.GRAVEL, BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_GRAVEL)
                            .strength(1.5F)
                            .requiresCorrectToolForDrops(),
                    SoundEvents.BRUSH_GRAVEL,
                    SoundEvents.BRUSH_GRAVEL_COMPLETED));

    public static final RegistryObject<Block> RECLAIMED_DIRT = registerBlock("reclaimed_dirt",
            () -> new BrushableBlock(Blocks.COARSE_DIRT, BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_GRAVEL)
                            .strength(1.5F)
                            .requiresCorrectToolForDrops(),
                    SoundEvents.BRUSH_GRAVEL,
                    SoundEvents.BRUSH_GRAVEL_COMPLETED));

    public static final RegistryObject<Block> NETHER_ANTHRACITE_ORE = registerBlock("nether_anthracite_ore",
            () -> new OreBlocks(3, BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .ignitedByLava()
                    .strength(3F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NETHER_ANTHRACITE_BLOCK = registerBlock("nether_anthracite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .ignitedByLava()
                    .strength(3F)
                    .requiresCorrectToolForDrops())
                    , 200);


    public static final RegistryObject<Block> COMPACTED_RECLAIMATION = registerBlock("compacted_reclaimation",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_GRAVEL)
                    .sound(ModSoundType.RECLAIMATION)
                    .strength(1F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ENRICHED_RECLAIMATION = registerBlock("enriched_reclaimation",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_GRAVEL)
                    .sound(ModSoundType.RECLAIMATION)
                    .strength(1F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MOSSY_RECLAIMATION = registerBlock("mossy_reclaimation",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_GRAVEL)
                    .sound(ModSoundType.MOSSY_RECLAIMATION)
                    .strength(1F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DRECK_MOSS = registerBlock("dreck_moss",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK)
                    .ignitedByLava()
                    .strength(0.5F))
                    , 1);


    public static final RegistryObject<Block> DRECK_GINKGO_LOG = registerBlock("dreck_ginkgo_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .ignitedByLava()
                    .strength(2.0F))
            , 4);

    public static final RegistryObject<Block> DRECK_GINKGO_LEAVES = registerBlock("dreck_ginkgo_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .ignitedByLava()
                    .strength(0.2F))
            , 1);


    //------------------------------------------------------------------------------------------------------------------
   //Put the number of Smelting Operations a Fuel Object should get, not burn time!
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<Item> registerFuelItem(String name, RegistryObject<T> block, int smeltOperations) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()){
            @Override
            public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                return smeltOperations;
            }
        });
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
