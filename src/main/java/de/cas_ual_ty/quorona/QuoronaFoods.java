package de.cas_ual_ty.quorona;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class QuoronaFoods
{
    public static final Food DEAD_BAT = (new Food.Builder()).hunger(4).saturation(0.1F).effect(() -> new EffectInstance(Effects.HUNGER, 600, 0), 0.8F).meat().build();
}
