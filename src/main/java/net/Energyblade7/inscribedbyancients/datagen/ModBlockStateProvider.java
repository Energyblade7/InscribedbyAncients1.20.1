package net.Energyblade7.inscribedbyancients.datagen;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.Energyblade7.inscribedbyancients.block.custom.InscriptionTile;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;



public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, InscribedbyAncients.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.NETHER_ANTHRACITE_BLOCK);
        blockWithItem(ModBlocks.NETHER_ANTHRACITE_ORE);
        blockWithItem(ModBlocks.SMOLDERING_NETHER_ANTHRACITE_ORE);


        blockWithItem(ModBlocks.COMPACTED_RECLAIMATION);
        blockWithItem(ModBlocks.ENRICHED_RECLAIMATION);
        blockWithItem(ModBlocks.DRECK_MOSS);


        logBlock((RotatedPillarBlock) ModBlocks.DRECK_TALLOW_LOG.get());
        blockItem(ModBlocks.DRECK_TALLOW_LOG);

        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_DRECK_TALLOW_LOG.get());
        blockItem(ModBlocks.STRIPPED_DRECK_TALLOW_LOG);

        axisBlock((RotatedPillarBlock) ModBlocks.DRECK_TALLOW_WOOD.get(), ResourceLocation.of("inscribedbyancients:block/dreck_tallow_log", ':'), ResourceLocation.of("inscribedbyancients:block/dreck_tallow_log", ':'));
        blockItem(ModBlocks.DRECK_TALLOW_WOOD);

        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_DRECK_TALLOW_WOOD.get(), ResourceLocation.of("inscribedbyancients:block/stripped_dreck_tallow_log", ':'), ResourceLocation.of("inscribedbyancients:block/stripped_dreck_tallow_log", ':'));
        blockItem(ModBlocks.STRIPPED_DRECK_TALLOW_WOOD);

        blockWithItem(ModBlocks.DRECK_TALLOW_LEAVES);

        blockWithItem(ModBlocks.DRECK_TALLOW_PLANK);

        stairsBlock((StairBlock) ModBlocks.DRECK_TALLOW_STAIRS.get(), blockTexture(ModBlocks.DRECK_TALLOW_PLANK.get()));
        blockItem(ModBlocks.DRECK_TALLOW_STAIRS);

        slabBlock(((SlabBlock) ModBlocks.DRECK_TALLOW_SLAB.get()), blockTexture(ModBlocks.DRECK_TALLOW_PLANK.get()), blockTexture(ModBlocks.DRECK_TALLOW_PLANK.get()));
        blockItem(ModBlocks.DRECK_TALLOW_SLAB);

        doorBlockWithRenderType((DoorBlock) ModBlocks.DRECK_TALLOW_DOOR.get(), modLoc("block/dreck_tallow_door_bottom"), modLoc("block/dreck_tallow_door_top"), "cutout");
        //Handled in ModItemModelProvider

        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.DRECK_TALLOW_TRAPDOOR.get(), modLoc("block/dreck_tallow_trapdoor"), true, "cutout");
        blockItem(ModBlocks.DRECK_TALLOW_TRAPDOOR, "_bottom");

        buttonBlock((ButtonBlock) ModBlocks.DRECK_TALLOW_BUTTON.get(), blockTexture(ModBlocks.DRECK_TALLOW_PLANK.get()));
        //Handled in ModItemModelProvider

        pressurePlateBlock((PressurePlateBlock) ModBlocks.DRECK_TALLOW_PRESSURE_PLATE.get(), blockTexture(ModBlocks.DRECK_TALLOW_PLANK.get()));
        blockItem(ModBlocks.DRECK_TALLOW_PRESSURE_PLATE);

        fenceBlock((FenceBlock) ModBlocks.DRECK_TALLOW_FENCE.get(), blockTexture(ModBlocks.DRECK_TALLOW_PLANK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.DRECK_TALLOW_FENCE_GATE.get(), blockTexture(ModBlocks.DRECK_TALLOW_PLANK.get()));
        blockItem(ModBlocks.DRECK_TALLOW_FENCE_GATE);

        blockItem(ModBlocks.INSCRIBED_TILE); //Remove later, will likely have a custom tool, or 2D texture to pair with this
    }

    // --- Helper Functions -------------------------------------------------------------------------------------------

    public void inscriptionTile(FenceGateBlock block, ModelFile modelFile) {
        getVariantBuilder(block).forAllStates(state -> {
            ModelFile model = modelFile;
            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY((int) state.getValue(FenceGateBlock.FACING).toYRot())
                    .uvLock(true)
                    .build();
        });
    }

    /*
                if (state.getValue(FenceGateBlock.OPEN)) {
                model = model == gateWall ? gateWallOpen : gateOpen;
            }
     */
    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("inscribedbyancients:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("inscribedbyancients:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
