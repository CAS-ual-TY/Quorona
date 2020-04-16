package de.cas_ual_ty.quorona;

import javax.annotation.Nullable;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;

public class QuoronaPotion extends Potion
{
    public QuoronaPotion(@Nullable String baseNameIn, EffectInstance... effectsIn)
    {
        super(baseNameIn, effectsIn);
    }
}
