package net.Energyblade7.inscribedbyancients.client;

import net.Energyblade7.inscribedbyancients.client.screen.IBATranslationGUI;
import net.Energyblade7.inscribedbyancients.util.translation.TranslationSystem;
import net.minecraft.client.Minecraft;

public class ClientHooks {
    public static void openTranslationScreen(){
        Minecraft.getInstance().setScreen(new IBATranslationGUI(TranslationSystem.rollAnthologyEntry()));
    }
}
