package net.Energyblade7.inscribedbyancients.util;


import net.Energyblade7.inscribedbyancients.InscribedbyAncients;
import net.Energyblade7.inscribedbyancients.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, InscribedbyAncients.MOD_ID);
    public static RegistryObject<CreativeModeTab> ANCIENTS_TAB = CREATIVE_MODE_TABS.register("ancients_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.ARCHEOLOGISTS_JOURNAL.get()))
            .title(Component.translatable("creativemodetab.ancients_tab")).build());

    public static void register(IEventBus eventBus) {CREATIVE_MODE_TABS.register(eventBus);
    }

}
