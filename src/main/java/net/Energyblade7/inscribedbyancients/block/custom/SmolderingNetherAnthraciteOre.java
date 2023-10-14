package net.Energyblade7.inscribedbyancients.block.custom;

import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class SmolderingNetherAnthraciteOre extends DropExperienceBlock {
    public static final BooleanProperty SMOLDERING = BooleanProperty.create("smoldering");
    private IntProvider xpRange;

    public SmolderingNetherAnthraciteOre(Properties pProperties, IntProvider pXpRange) {
        super(pProperties, pXpRange);
        this.xpRange = pXpRange;
        this.registerDefaultState(this.defaultBlockState().setValue(SMOLDERING, Boolean.valueOf(true)));
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(SMOLDERING);
    }

    // --- Block Behaviors ----------------------------------------------------------------------------------


    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {


        if (!pEntity.isSteppingCarefully() && pEntity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)pEntity) && pState.getValue(SMOLDERING)) {
            pEntity.hurt(pLevel.damageSources().hotFloor(), 1.0F);
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {

        return silkTouchLevel == 0 && !state.getValue(SMOLDERING) ? this.xpRange.sample(randomSource) : 0;
    }

    @Override // TEMPORARY BEHAVIOR UNTIL AWAY TO EXTINGUISH SMOLDERING NETHER ANTHRACITE IS DETERMINED
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        InscribedbyAncients.LOGGER.info("test");

        if(!pLevel.isClientSide && pHand == InteractionHand.MAIN_HAND && !pPlayer.isCrouching()){

            boolean currentState = pState.getValue(SMOLDERING);
            pLevel.setBlock(pPos, pState.setValue(SMOLDERING, !currentState), 3);


            pLevel.playSound(null, pPos, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1F, 1F);
            pLevel.setBlockAndUpdate(pPos, ModBlocks.MOSSY_RECLAIMATION.get().defaultBlockState());
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }


    }
}
