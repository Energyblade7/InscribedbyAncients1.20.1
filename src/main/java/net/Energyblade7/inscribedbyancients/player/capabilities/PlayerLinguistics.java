package net.Energyblade7.inscribedbyancients.player.capabilities;

import net.Energyblade7.inscribedbyancients.util.translation.KnowledgeFlags;
import net.Energyblade7.inscribedbyancients.util.translation.LoreFlags;
import net.Energyblade7.inscribedbyancients.util.translation.TranslationNexus;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;

@AutoRegisterCapability
public class PlayerLinguistics {
    private byte[] lore = new byte[TranslationNexus.alphaDictionary.length];
    private byte[] knowledge = new byte[TranslationNexus.alphaAnthology.length];

    public LoreFlags getLoreEntry(int pointer) {
        switch (lore[pointer]) {
            case 1 -> {return LoreFlags.UNSOLVABLE;}
            case 2 -> {return LoreFlags.SOLVABLE;}
            case 3 -> {return LoreFlags.TRANSLATED;}
            default -> {return LoreFlags.UNDISCOVERED;}
        }
    }

    public void setLoreEntry(int pointer, LoreFlags lore) {
        switch (lore) {
            case UNSOLVABLE -> this.lore[pointer] = 1;
            case SOLVABLE -> this.lore[pointer] = 2;
            case TRANSLATED -> this.lore[pointer] = 3;
            default -> this.lore[pointer] = 0;
        }

    }

    public KnowledgeFlags getKnowledgeEntry(int pointer) {
        switch (lore[pointer]) {
            case 1 -> {return KnowledgeFlags.DISCOVERED;}
            case 2 -> {return KnowledgeFlags.ESTABLISHED;}
            default -> {return KnowledgeFlags.UNKNOWN;}
        }
    }

    public void setKnowledge(int pointer, KnowledgeFlags knowledge) {
        switch (knowledge) {
            case DISCOVERED -> this.knowledge[pointer] = 1;
            case ESTABLISHED -> this.knowledge[pointer] = 2;
            default -> this.knowledge[pointer] = 0;
        }
    }

    public void copyFrom(PlayerLinguistics source) {
        this.lore = source.lore;
        this.knowledge = source.knowledge;
    }

    public void saveNBTKnowledge(CompoundTag nbt) {
        nbt.putByteArray("knowledge", knowledge);
    }
    public void loadNBTKnowledge(CompoundTag nbt) {
        knowledge = nbt.getByteArray("knowledge");
    }

    public void saveNBTLore(CompoundTag nbt) {
        nbt.putByteArray("lore", lore);
    }
    public void loadNBTLore(CompoundTag nbt) {
        lore = nbt.getByteArray("lore");
    }
}
