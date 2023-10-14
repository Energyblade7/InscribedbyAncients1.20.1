package net.Energyblade7.inscribedbyancients.item.library;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties TALLOW_NUT = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600), .9f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 1), .8f)
            .build();
}
