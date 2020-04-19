package de.cas_ual_ty.quorona;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

public class QuoronaEffect extends Effect
{
    public QuoronaEffect()
    {
        super(EffectType.HARMFUL, 0xB3E108);
        this.addAttributesModifier(SharedMonsterAttributes.MAX_HEALTH, "A570C5AA-79A5-11EA-BC55-0242AC130003", -0.08D, Operation.MULTIPLY_TOTAL);
    }
    
    @Override
    public boolean isReady(int duration, int amplifier)
    {
        return true;
    }
    
    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier)
    {
        if(entityLivingBaseIn.isPotionActive(QuoronaEffects.IMMUNITY))
        {
            entityLivingBaseIn.removePotionEffect(this);
            return;
        }
        
        LivingEntity target;
        for(Entity entity : entityLivingBaseIn.getEntityWorld().getEntitiesInAABBexcluding(entityLivingBaseIn, entityLivingBaseIn.getBoundingBox().grow(1.5D), (entity) -> true))
        {
            if(entity instanceof LivingEntity)
            {
                target = (LivingEntity)entity;
                
                if(!target.isPotionActive(QuoronaEffects.IMMUNITY) && !target.isPotionActive(this) && !target.isEntityUndead())
                {
                    target.addPotionEffect(new EffectInstance(this, Quorona.DEFAULT_THE_FLOO_TIME, 0, false, false));
                }
            }
        }
        
        EffectInstance ef = entityLivingBaseIn.getActivePotionEffect(this);
        if(ef != null && ef.getDuration() == 1)
        {
            entityLivingBaseIn.addPotionEffect(new EffectInstance(QuoronaEffects.IMMUNITY, Quorona.DEFAULT_IMMUNITY_TIME, 0, false, false));
        }
    }
    
    @Override
    public List<ItemStack> getCurativeItems()
    {
        return new ArrayList<>();
    }
}
