package net.Energyblade7.inscribedbyancients.client.screen.library.button;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class IBAButton extends ImageButton {
    private final ResourceLocation TEXTURE;
    private static final int WHITE = 14737632;


    private static float guiScale;


    private final int xPos;
    private final int yPos;
    private final int buttonWidth;
    private final int buttonHeight;
    private final int xOffset;
    private final int yOffset;
    private final int yDiff;
    private String buttonText;
    private Boolean toggleEffect;


    private ButtonSelector buttonSelector = ButtonSelector.DEFAULT;

    public IBAButton(float guiScale, boolean initialVisibility, int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int yDiff, ResourceLocation pResourceLocation, OnPress pOnPress, @Nullable String buttonText, Boolean toggleEffect) {
        super(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pResourceLocation, pOnPress);

        IBAButton.guiScale = guiScale;
        this.TEXTURE = pResourceLocation;
        this.xPos = pX;
        this.yPos = pY;
        this.xOffset = pXTexStart;
        this.yOffset = pYTexStart;
        this.yDiff = yDiff;
        this.buttonWidth = pWidth;
        this.buttonHeight = pHeight;
        this.visible = initialVisibility;
        this.buttonText = buttonText;
        this.toggleEffect = toggleEffect;
    }

    private int getSelectorType(ButtonSelector pButtonSelector, int yDiff) {
        switch (pButtonSelector) {
            case DEFAULT -> { return 0; }
            case FOCUSED -> { return yDiff; }
            default -> {return yDiff * 2; }
        }
    }

    @Override
    public void renderWidget(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {

        if(this.isHovered && buttonSelector != ButtonSelector.SELECTED && buttonSelector != ButtonSelector.NEGATED) {
            this.buttonSelector = ButtonSelector.FOCUSED;
        } else if (buttonSelector != ButtonSelector.SELECTED && buttonSelector != ButtonSelector.NEGATED) {
            this.buttonSelector = ButtonSelector.DEFAULT;
        }

        this.setPosition((int) ((this.xPos * guiScale)), (int) ((this.yPos) * guiScale));
        this.setWidth((int) (this.buttonWidth * guiScale));
        this.setHeight((int) (this.buttonHeight * guiScale));

        pGuiGraphics.blit(this.TEXTURE, this.xPos, this.yPos, this.xOffset, yOffset + getSelectorType(this.buttonSelector, this.yDiff), buttonWidth, buttonHeight);

        if (this.buttonText != null && this.visible) this.renderText(pGuiGraphics);
    }

    public void renderText(GuiGraphics pGuiGraphics) {
        Component displayPhrase = Component.translatable(buttonText);

        pGuiGraphics.drawCenteredString(Minecraft.getInstance().font, displayPhrase, xPos + 24, yPos + 4, WHITE);
    }

    public static void isSoloSelectionButton(int finalI, int countLimit, IBAButton[] pButtonList) {
        for (int j = 0; j < countLimit; j++){

            if(j != finalI) pButtonList[j].setButtonSelector(ButtonSelector.DEFAULT);

            pButtonList[finalI].setButtonSelector(ButtonSelector.SELECTED);
        }
    }

    // --- Getters and Setters -----------------------------------------------------------------------------------------

    public ButtonSelector getButtonSelector() {
        return this.buttonSelector;
    }

    public void setButtonSelector(ButtonSelector buttonSelector) {
        this.buttonSelector = buttonSelector;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public Boolean getToggleEffect() {
        return toggleEffect;
    }

    public void setToggleEffect(Boolean toggleEffect) {
        this.toggleEffect = toggleEffect;
    }

}
