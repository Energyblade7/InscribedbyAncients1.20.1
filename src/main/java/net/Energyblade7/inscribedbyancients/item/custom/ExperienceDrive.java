package net.Energyblade7.inscribedbyancients.item.custom;


import net.Energyblade7.inscribedbyancients.item.library.IBAItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ExperienceDrive extends IBAItem {

    private static int soundCoolDown = 5; // in ticks

    public ExperienceDrive(String description, @Nullable String shiftDescription, Properties pProperties) {
        super(description, shiftDescription, pProperties);
    }

    // --- Item Stack Properties ---------------------------------------------------------------------------------------

    /* NOTES ON EXPERIENCE DRIVE BEHAVIORS
        - Can store up to 30 Levels (1395 EXP)
        - On Right-click(Hold)[while player has EXP != 0], starts consuming EXP from player at X rate
        - On SHIFT + Right-click(Hold), provides EXP up to the amount currently stored
     */

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return true;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 200;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;}

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        soundCoolDown = 0;

        if(!pLevel.isClientSide && pPlayer.totalExperience != 0) {
            pPlayer.startUsingItem(pUsedHand);
            return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
        } else {
            return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
        }
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if(pRemainingUseDuration == getUseDuration(pStack)) {
            return;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // --- Helper Functions --------------------------------------------------------------------------------------------

    private void exchangeEXP(ItemStack pStack, Player pPlayer, boolean isStoringEXP){
        double exchangeRate = (pStack.getMaxDamage() * 0.02) * (isStoringEXP ? -1 : 1);

        pPlayer.totalExperience = (int) (pPlayer.totalExperience + exchangeRate);
        pStack.setDamageValue((int) (pStack.getDamageValue() + exchangeRate));
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        stack.getOrCreateTag().putInt("Damage",damage);
    }
    // -----------------------------------------------------------------------------------------------------------------
}
