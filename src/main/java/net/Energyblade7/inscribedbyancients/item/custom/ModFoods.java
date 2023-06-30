package net.Energyblade7.inscribedbyancients.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BATTERY = new FoodProperties.Builder()
            .alwaysEat()
            .nutrition(2)
            .saturationMod(2)
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 20), 1f).build();
}
