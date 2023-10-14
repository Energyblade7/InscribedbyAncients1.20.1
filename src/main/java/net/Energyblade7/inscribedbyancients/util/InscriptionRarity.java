package net.Energyblade7.inscribedbyancients.util;

import net.minecraft.util.StringRepresentable;

public enum InscriptionRarity implements StringRepresentable {
    UNCOMMON("uncommon"),
    RARE("rare"),
    EXOTIC("exotic"),
    MUTABLE("mutable"),
    DULL("dull")
    ;
    private final String name;

    InscriptionRarity(String pName) {
        this.name = pName;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

}
