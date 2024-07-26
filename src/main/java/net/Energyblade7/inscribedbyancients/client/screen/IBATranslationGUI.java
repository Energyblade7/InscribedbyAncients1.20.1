package net.Energyblade7.inscribedbyancients.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.client.screen.library.IBAStyles;
import net.Energyblade7.inscribedbyancients.client.screen.library.button.ButtonSelector;
import net.Energyblade7.inscribedbyancients.client.screen.library.button.IBAButton;
import net.Energyblade7.inscribedbyancients.util.translation.InscriptionPhrase;
import net.Energyblade7.inscribedbyancients.util.translation.TranslationKey;
import net.Energyblade7.inscribedbyancients.util.translation.TranslationNexus;
import net.Energyblade7.inscribedbyancients.util.translation.TranslationSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;

public class IBATranslationGUI extends Screen {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(InscribedbyAncients.MOD_ID,"textures/gui/translation_menu.png");

// Make buttons retain data after a resize - DO THIS AFTER FINAL / Add function to get player EXP if menu closes while translation is solved
    private static final float GUI_SCALE = 1.6F;
    private static final int[] BACKGROUND_AREA = {195, 134}; // {w, h}
    private static final int WHITE = 14737632;


    private static Boolean buttonSelected, completionNotify;
    private int x_anchor, y_anchor, bracketTarget, buttonAlignment;
    
    private IBAButton[] ibaTranslationButtons;
    private IBAButton[][] ibaSubButtons;
    private TranslationKey[] selectionKey;
    private static InscriptionPhrase inscriptionPhrase;


    public IBATranslationGUI(InscriptionPhrase pInscriptionPhrase) {
        super(Component.translatable("menu.translation.title"));

        inscriptionPhrase = pInscriptionPhrase;
    }

    @Override
    protected void init() {
        super.init();

        buttonSelected = false;
        completionNotify = false;

        this.x_anchor = (int) (width /  (2 * GUI_SCALE)) - (BACKGROUND_AREA[0] / 2);
        this.y_anchor = (int) (height /  (2 * GUI_SCALE)) - (BACKGROUND_AREA[1] / 2);

        this.buttonAlignment = x_anchor + 98 - (((15 * inscriptionPhrase.wordComponents().length ) - 2) / 2);

        this.ibaTranslationButtons = new IBAButton[inscriptionPhrase.wordComponents().length];
        this.ibaSubButtons = new IBAButton[inscriptionPhrase.wordComponents().length][3];
        this.selectionKey = new TranslationKey[inscriptionPhrase.wordComponents().length];

        for (int i = 0; i < inscriptionPhrase.wordComponents().length; ++i) {
            this.initializeTranslationButtons(i);
            this.initializeSubButtons(i);
        }

    }


    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {

        pGuiGraphics.pose().scale(GUI_SCALE, GUI_SCALE, GUI_SCALE);

        this.renderBackground(pGuiGraphics);
        this.renderDisplayPhrase(pGuiGraphics);
        this.renderTranslationKey(pGuiGraphics);

        if(completionNotify) this.renderCompletionMessage(pGuiGraphics);

        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        this.renderToggleEffect(pGuiGraphics);
        if(buttonSelected) this.renderGUIBrackets(pGuiGraphics);
    }

    // --- Render Sub-Processes ----------------------------------------------------------------------------------------

    public void renderBackground(GuiGraphics pGuiGraphics){
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        pGuiGraphics.blit(TEXTURE, x_anchor, y_anchor, 0, 0, BACKGROUND_AREA[0], BACKGROUND_AREA[1]);
    }

    public void renderDisplayPhrase(GuiGraphics pGuiGraphics) {
        Component displayPhrase = Component.literal(TranslationSystem.buildString(inscriptionPhrase.wordComponents(), true)).withStyle(IBAStyles.BUILDSCRIT_STYLE);

        pGuiGraphics.drawCenteredString(this.font, displayPhrase, x_anchor + 100, y_anchor + 30, WHITE);
    }

    private void renderTranslationKey(GuiGraphics pGuiGraphics) {
        pGuiGraphics.drawCenteredString(this.font, TranslationSystem.buildString(this.selectionKey, true), x_anchor + 98, y_anchor + 50, WHITE);
    }

    private void renderCompletionMessage(GuiGraphics pGuiGraphics) {
        pGuiGraphics.drawCenteredString(this.font, Component.translatable("menu.translation.completed").withStyle(IBAStyles.ETHER_GREEN), x_anchor + 98, y_anchor + 95, WHITE);
    }

    private void renderToggleEffect(GuiGraphics pGuiGraphics) {
        for (int i = 0; i < inscriptionPhrase.wordComponents().length; ++i) {
            if (ibaTranslationButtons[i].getToggleEffect()) pGuiGraphics.blit(TEXTURE, buttonAlignment + 5 + (15 * i), y_anchor + 73, 96, 136, 3, 3);
        }
    }

    private void renderGUIBrackets(GuiGraphics pGuiGraphics) {
        pGuiGraphics.pose().popPose();
        pGuiGraphics.pose().scale(GUI_SCALE, GUI_SCALE, GUI_SCALE);

        pGuiGraphics.blit(TEXTURE, x_anchor + 22, y_anchor + 91, 15, 179, 155, 7);
        pGuiGraphics.blit(TEXTURE, buttonAlignment + (15 * this.bracketTarget), y_anchor + 73, 81, 136, 13, 19);
    }

    // --- Button Functions --------------------------------------------------------------------------------------------

    private void initializeTranslationButtons(int finalI){
        this.addIBAButton(finalI, ibaTranslationButtons ,new IBAButton(GUI_SCALE, true, buttonAlignment + (15 * finalI), y_anchor + 68, 13, 13, 15, 136, 14,TEXTURE, (button) -> {

            if (this.ibaTranslationButtons[finalI].getButtonSelector() == ButtonSelector.NEGATED) return;

            this.revealSubButtons(ibaSubButtons[finalI]);
            IBAButton.isSoloSelectionButton(finalI, inscriptionPhrase.wordComponents().length, ibaTranslationButtons);
            this.bracketTarget = finalI;
            buttonSelected = true;

            }, null, false));
    }

    private void initializeSubButtons(int pMainButton) {

        for (int i = 0; i < 3; ++i) {

            int finalI = i;
            TranslationKey translatedDictionaryEntry = TranslationNexus.alphaDictionary[inscriptionPhrase.wordSelection()[pMainButton][finalI]];

            this.addIBAButton(finalI ,ibaSubButtons[pMainButton] ,new IBAButton(GUI_SCALE, false,x_anchor + 22 + (finalI * 53), y_anchor + 96, 49, 13, 30, 136, 14,TEXTURE, (button) -> {

                IBAButton.isSoloSelectionButton(finalI,3, ibaSubButtons[pMainButton]);
                this.ibaTranslationButtons[pMainButton].setToggleEffect(true);

                this.selectionKey[pMainButton] = translatedDictionaryEntry;

                if (TranslationSystem.checkForCorrectness(inscriptionPhrase.wordComponents(), this.selectionKey)) {
                    this.inscriptionSuccessfullyTranslated();
                }

            }, translatedDictionaryEntry.translatedWord(), false));
        }
    }

    private void revealSubButtons(IBAButton[] pSubButtonGroup) {

        for (IBAButton[] ibaSubButton : ibaSubButtons) {

            if (pSubButtonGroup == ibaSubButton) {
                for (int j = 0; j < 3; ++j) pSubButtonGroup[j].visible = true;
            } else {
                resetSubButtonGroup(ibaSubButton);
            }

        }

    }

    // --- Helper Functions --------------------------------------------------------------------------------------------

    private <T extends IBAButton> void addIBAButton(int index, IBAButton[] pButtonGroup,T pButton) {
        this.addRenderableWidget(pButton);
        pButtonGroup[index] = pButton;
    }

    private static void resetSubButtonGroup(IBAButton[] pSubButtonGroup) {
        for (int i = 0 ; i < 3; ++i) {
            pSubButtonGroup[i].visible = false;
        }
    }

    private void inscriptionSuccessfullyTranslated(){

        buttonSelected = false;
        completionNotify = true;

        for (int i = 0 ; i < inscriptionPhrase.wordComponents().length; ++i) {
            this.ibaTranslationButtons[i].setButtonSelector(ButtonSelector.NEGATED);
            resetSubButtonGroup(this.ibaSubButtons[i]);
        }

        assert minecraft != null;
        minecraft.getSoundManager().play(SimpleSoundInstance.forLocalAmbience(SoundEvents.PLAYER_LEVELUP, 1, 0.2F));

    }

    // -----------------------------------------------------------------------------------------------------------------
}
