package de.cas_ual_ty.quorona;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

import java.util.ArrayList;
import java.util.List;

public class ImmunityEffect extends Effect
{
    public ImmunityEffect()
    {
        super(EffectType.BENEFICIAL, 0x0000BB);
    }
    
    @Override
    public List<ItemStack> getCurativeItems()
    {
        return new ArrayList<>();
    }
}
