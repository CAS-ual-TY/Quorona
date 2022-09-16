package de.cas_ual_ty.quorona;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class QuoronaEffect extends MobEffect
{
    public QuoronaEffect()
    {
        super(MobEffectCategory.HARMFUL, 0xB3E108);
        addAttributeModifier(Attributes.MAX_HEALTH, "A570C5AA-79A5-11EA-BC55-0242AC130003", -0.1D, AttributeModifier.Operation.MULTIPLY_TOTAL);
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
                    target.addEffect(new MobEffectInstance(this, Quorona.DEFAULT_THE_FLOO_TIME, 0, false, false));
                }
            }
        }
        
        MobEffectInstance ef = entityLivingBaseIn.getEffect(this);
        if(ef != null && ef.getDuration() == 1)
        {
            entityLivingBaseIn.addEffect(new MobEffectInstance(QuoronaEffects.IMMUNITY.get(), Quorona.DEFAULT_IMMUNITY_TIME, 0, false, false));
        }
    }
    
    @Override
    public List<ItemStack> getCurativeItems()
    {
        return new ArrayList<>();
    }
}
