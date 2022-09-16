package de.cas_ual_ty.quorona;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ImmunityEffect extends MobEffect
{
    public ImmunityEffect()
    {
        super(MobEffectCategory.BENEFICIAL, 0x0000BB);
    }
    
    @Override
    public List<ItemStack> getCurativeItems()
    {
        return new ArrayList<>();
    }
}
