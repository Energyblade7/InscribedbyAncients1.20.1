package net.Energyblade7.inscribedbyancients.util.translation;


import net.minecraft.network.chat.Component;

import java.util.Objects;
import java.util.Random;

public class TranslationSystem {

    public static String buildString(String[] pInscriptionPhrase, Boolean addSpaces){
        StringBuilder stringbuilder = new StringBuilder();



        for (String wordComponent : pInscriptionPhrase) {
            stringbuilder.append(Objects.requireNonNullElse(wordComponent, "---"));

            if (addSpaces) stringbuilder.append(" ");
        }

        return String.valueOf(stringbuilder);
    }

    public static String buildString(TranslationKey[] pInscriptionPhrase, Boolean addSpaces){
        StringBuilder stringbuilder = new StringBuilder();

        for (TranslationKey pSelectedKey : pInscriptionPhrase) {
            try {
                stringbuilder.append(Component.translatable(pSelectedKey.translatedWord()).getString());
            } catch (NullPointerException nullPointerException) {
                stringbuilder.append("---");
            }

            if (addSpaces) stringbuilder.append(" ");
        }

        return String.valueOf(stringbuilder);
    }

    public static String translateString(TranslationKey[] pTranslationKey){
        StringBuilder stringBuilder = new StringBuilder();

        for (TranslationKey pSelectedKey: pTranslationKey) {
            try {
                stringBuilder.append(pSelectedKey.ancientWord());
            } catch (NullPointerException nullPointerException) {
                stringBuilder.append("---");
            }
        }

        return String.valueOf(stringBuilder);
    }

    public static Boolean checkForCorrectness(String[] pInscriptionPhrase, TranslationKey[] pTranslationKey) {
        StringBuilder inscriptionKey = new StringBuilder(buildString(pInscriptionPhrase, false));

        try {
            do {
                inscriptionKey.deleteCharAt(inscriptionKey.indexOf(","));
            } while (inscriptionKey.indexOf(",") != -1);

            do {
                inscriptionKey.deleteCharAt(inscriptionKey.indexOf("<"));
            } while (inscriptionKey.indexOf("<") != -1);
        } catch (StringIndexOutOfBoundsException ignored) {}


        return String.valueOf(inscriptionKey).equals(translateString(pTranslationKey));
    }

    public static InscriptionPhrase rollAnthologyEntry() {
        Random random = new Random();

        return TranslationNexus.alphaAnthology[random.nextInt(TranslationNexus.alphaAnthology.length)];
    }

}
