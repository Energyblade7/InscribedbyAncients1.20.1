package net.Energyblade7.inscribedbyancients.block;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.block.custom.*;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
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

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, float smeltOperations) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerFuelItem(name, toReturn, (int) smeltOperations * 200);
        return toReturn;
    }


    //-----------------------------------------------------------------------------------------------------------------
    //Put the number of Smelting Operations a Fuel Object should get, not burn time!

    public static final RegistryObject<Block> RECLAIMED_SAND = registerBlock("reclaimed_sand",
            () -> new BrushableBlock(Blocks.SAND, BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_SAND)
                            .strength(0.2F)
                            .noLootTable(),
                    SoundEvents.BRUSH_SAND,
                    SoundEvents.BRUSH_SAND_COMPLETED));

    public static final RegistryObject<Block> RECLAIMED_GRAVEL = registerBlock("reclaimed_gravel",
            () -> new BrushableBlock(Blocks.GRAVEL, BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_GRAVEL)
                            .strength(0.2F)
                            .noLootTable(),
                    SoundEvents.BRUSH_GRAVEL,
                    SoundEvents.BRUSH_GRAVEL_COMPLETED));

    public static final RegistryObject<Block> RECLAIMED_DIRT = registerBlock("reclaimed_dirt",
            () -> new BrushableBlock(Blocks.COARSE_DIRT, BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)
                            .strength(0.4F)
                            .noLootTable(),
                    SoundEvents.BRUSH_GRAVEL,
                    SoundEvents.BRUSH_GRAVEL_COMPLETED));

    public static final RegistryObject<Block> NETHER_ANTHRACITE_ORE = registerBlock("nether_anthracite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .ignitedByLava()
                    .strength(3F)
                    , UniformInt.of(1, 2)));
    public static final RegistryObject<Block> SMOLDERING_NETHER_ANTHRACITE_ORE = registerBlock("smoldering_nether_anthracite_ore",
            () -> new SmolderingNetherAnthraciteOre(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .ignitedByLava()
                    .strength(3F)
                    , UniformInt.of(2,3)));

    public static final RegistryObject<Block> NETHER_ANTHRACITE_BLOCK = registerBlock("nether_anthracite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .ignitedByLava()
                    .strength(3F))
                    , 200);

    //--- Dreck Reef Biome Blocks register here ------------------------------------------------------------------------
    public static final RegistryObject<Block> COMPACTED_RECLAIMATION = registerBlock("compacted_reclaimation",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT)
                    .instrument(NoteBlockInstrument.SNARE)
                    .sound(ModSoundType.RECLAIMATION)
                    .strength(1F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ENRICHED_RECLAIMATION = registerBlock("enriched_reclaimation",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT)
                    .instrument(NoteBlockInstrument.SNARE)
                    .sound(ModSoundType.RECLAIMATION)
                    .strength(1F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MOSSY_RECLAIMATION = registerBlock("mossy_reclaimation",
            () -> new DreckMossBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT)
                    .instrument(NoteBlockInstrument.SNARE)
                    .sound(ModSoundType.MOSSY_RECLAIMATION)
                    .randomTicks()
                    .strength(1F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DRECK_MOSS = registerBlock("dreck_moss",
            () -> new DreckMossBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK)
                    .randomTicks()
                    .ignitedByLava()
                    .strength(0.5F))
                    , 0.5f);

    // -----------------------------------------------------------------------------------------------------------------

// --- Dreck Tallow Wood Items Register here ---------------------------------------------------------------------------
    public static final RegistryObject<Block> DRECK_TALLOW_LOG = registerBlock("dreck_tallow_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG))
            , 1.5f);
    public static final RegistryObject<Block> STRIPPED_DRECK_TALLOW_LOG = registerBlock("stripped_dreck_tallow_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG))
            , 1.5f);
    public static final RegistryObject<Block> DRECK_TALLOW_WOOD = registerBlock("dreck_tallow_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD))
            , 1.5f);
    public static final RegistryObject<Block> STRIPPED_DRECK_TALLOW_WOOD = registerBlock("stripped_dreck_tallow_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD))
            , 1.5f);

    public static final RegistryObject<Block> DRECK_TALLOW_LEAVES = registerBlock("dreck_tallow_leaves",
            () -> new DreckTallowLeaves(BlockBehaviour.Properties.copy(Blocks.CHERRY_LEAVES))
            , 0.2f);

    public static final RegistryObject<Block> DRECK_TALLOW_PLANK = registerBlock("dreck_tallow_plank",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD))
            , 1.5f);
    public static final RegistryObject<Block> DRECK_TALLOW_STAIRS = registerBlock("dreck_tallow_stairs",
            () -> new StairBlock(() -> ModBlocks.DRECK_TALLOW_PLANK.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS))
            , 1.5f);
    public static final RegistryObject<Block> DRECK_TALLOW_SLAB = registerBlock("dreck_tallow_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB))
            , 1.5f);
    public static final RegistryObject<Block> DRECK_TALLOW_PRESSURE_PLATE = registerBlock("dreck_tallow_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)
                    , BlockSetType.OAK)
                    , 0.5f);
    public static final RegistryObject<Block> DRECK_TALLOW_BUTTON = registerBlock("dreck_tallow_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
                    , BlockSetType.OAK, 40, true));
    public static final RegistryObject<Block> DRECK_TALLOW_FENCE = registerBlock("dreck_tallow_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE))
            , 0.5f);
    public static final RegistryObject<Block> DRECK_TALLOW_FENCE_GATE = registerBlock("dreck_tallow_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE)
            , 0.5f);
    // -----------------------------------------------------------------------------------------------------------------

    public static final RegistryObject<Block> INSCRIBED_TILE = registerBlock("inscribed_tile",
            () -> new InscriptionTile(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .sound(ModSoundType.INSCRIPTION_TILE)
                    .strength(50.0F,0.2F)
                    .noOcclusion()
                    .noCollission()
                    .noLootTable()
                    .pushReaction(PushReaction.IGNORE)));

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
