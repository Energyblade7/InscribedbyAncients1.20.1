package net.Energyblade7.inscribedbyancients.player.capabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerLinguisticsProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerLinguistics> PLAYER_LINGUISTICS = CapabilityManager.get(new CapabilityToken<>() {
    });
    private PlayerLinguistics linguistics = null;
    private final LazyOptional<PlayerLinguistics> optional = LazyOptional.of(this::getPlayerLinguistics);

    private PlayerLinguistics getPlayerLinguistics() {
        if (this.linguistics == null) this.linguistics = new PlayerLinguistics();

        return this.linguistics;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_LINGUISTICS) return optional.cast();

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        getPlayerLinguistics().saveNBTLore(nbt);
        getPlayerLinguistics().saveNBTKnowledge(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        getPlayerLinguistics().loadNBTLore(nbt);
        getPlayerLinguistics().loadNBTKnowledge(nbt);
    }
}
