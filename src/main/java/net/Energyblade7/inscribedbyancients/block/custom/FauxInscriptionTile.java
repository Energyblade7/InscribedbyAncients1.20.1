package net.Energyblade7.inscribedbyancients.block.custom;

import net.Energyblade7.inscribedbyancients.block.library.WritingTile;
import net.Energyblade7.inscribedbyancients.util.InscriptionRarity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.HashMap;

public class FauxInscriptionTile extends WritingTile {
    public static final EnumProperty<InscriptionRarity> INSCRIPTION_RARITY = EnumProperty.create("inscription_rarity", InscriptionRarity.class);

    public FauxInscriptionTile(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(INSCRIPTION_RARITY, InscriptionRarity.DULL));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(INSCRIPTION_RARITY);
    }

    // --- Block Behaviors ---------------------------------------------------------------------------------------------

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if(pLevel.isClientSide
                || pPlayer.isCrouching()
                || pHand != pPlayer.getUsedItemHand()){return InteractionResult.FAIL;}

        pLevel.setBlockAndUpdate(pPos, pState.setValue(INSCRIPTION_RARITY, getRarityIndex().get(pState.getValue(INSCRIPTION_RARITY))));
        pLevel.playSound(null, pPos, SoundEvents.BRUSH_GRAVEL, SoundSource.BLOCKS, 1F, 1F);
        return InteractionResult.SUCCESS;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // --- Helper Functions --------------------------------------------------------------------------------------------

    public static HashMap<InscriptionRarity, InscriptionRarity> getRarityIndex(){

        HashMap<InscriptionRarity, InscriptionRarity> rarityIndex = new HashMap<>(5);
        rarityIndex.put(InscriptionRarity.DULL, InscriptionRarity.MUTABLE);
        rarityIndex.put(InscriptionRarity.MUTABLE, InscriptionRarity.UNCOMMON);
        rarityIndex.put(InscriptionRarity.UNCOMMON, InscriptionRarity.RARE);
        rarityIndex.put(InscriptionRarity.RARE, InscriptionRarity.EXOTIC);
        rarityIndex.put(InscriptionRarity.EXOTIC, InscriptionRarity.DULL);

        return rarityIndex;
    }
    // -----------------------------------------------------------------------------------------------------------------
}
