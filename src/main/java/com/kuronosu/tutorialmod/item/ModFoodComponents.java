package com.kuronosu.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.15f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0), 0.2f).build();
}
