package de.cas_ual_ty.quorona;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

import java.util.ArrayList;
import java.util.List;

public class QuoronaEffect extends Effect
{
    public QuoronaEffect()
    {
        super(EffectType.HARMFUL, 0xB3E108);
        addAttributeModifier(Attributes.MAX_HEALTH, "A570C5AA-79A5-11EA-BC55-0242AC130003", -0.1D, Operation.MULTIPLY_TOTAL);
    }
    
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier)
    {
        return true;
    }
    
    @Override
    public void applyEffectTick(LivingEntity entityLivingBaseIn, int amplifier)
    {
        if(entityLivingBaseIn.hasEffect(QuoronaEffects.IMMUNITY.get()))
        {
            entityLivingBaseIn.removeEffect(this);
            return;
        }
        
        LivingEntity target;
        for(Entity entity : entityLivingBaseIn.level.getEntities(entityLivingBaseIn, entityLivingBaseIn.getBoundingBox().inflate(1.5D), (entity) -> true))
        {
            if(entity instanceof LivingEntity)
            {
                target = (LivingEntity) entity;
                
                if(!target.hasEffect(QuoronaEffects.IMMUNITY.get()) && !target.hasEffect(this) && !target.isInvertedHealAndHarm())
                {
                    target.addEffect(new EffectInstance(this, Quorona.DEFAULT_THE_FLOO_TIME, 0, false, false));
                }
            }
        }
        
        EffectInstance ef = entityLivingBaseIn.getEffect(this);
        if(ef != null && ef.getDuration() == 1)
        {
            entityLivingBaseIn.addEffect(new EffectInstance(QuoronaEffects.IMMUNITY.get(), Quorona.DEFAULT_IMMUNITY_TIME, 0, false, false));
        }
    }
    
    @Override
    public List<ItemStack> getCurativeItems()
    {
        return new ArrayList<>();
    }
}
