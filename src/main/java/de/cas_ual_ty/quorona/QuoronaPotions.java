package de.cas_ual_ty.quorona;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = Quorona.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Quorona.MOD_ID)
public class QuoronaPotions
{
    public static final Potion THE_FLOO = null;
    public static final Potion LONG_THE_FLOO = null;
    public static final Potion STRONG_THE_FLOO = null;
    public static final Potion SHORT_THE_FLOO = null;
    
    @SubscribeEvent
    public static void register(RegistryEvent.Register<Potion> event)
    {
        event.getRegistry().register(new Potion(QuoronaPotions.createEffectInstance(QuoronaEffects.THE_FLOO, Quorona.DEFAULT_THE_FLOO_TIME, false)).setRegistryName(Quorona.MOD_ID, "the_floo"));
        event.getRegistry().register(new Potion("the_floo", QuoronaPotions.createEffectInstance(QuoronaEffects.THE_FLOO, Quorona.DEFAULT_THE_FLOO_TIME * 3 / 2, false)).setRegistryName(Quorona.MOD_ID, "long_the_floo"));
        event.getRegistry().register(new Potion("the_floo", QuoronaPotions.createEffectInstance(QuoronaEffects.THE_FLOO, Quorona.DEFAULT_THE_FLOO_TIME / 2, 1, false)).setRegistryName(Quorona.MOD_ID, "strong_the_floo"));
        event.getRegistry().register(new Potion("the_floo", QuoronaPotions.createEffectInstance(QuoronaEffects.THE_FLOO, Quorona.DEFAULT_THE_FLOO_TIME / 100, 1, false)).setRegistryName(Quorona.MOD_ID, "short_the_floo"));
    }
    
    public static EffectInstance createEffectInstance(Effect effect, int duration, boolean particles)
    {
        return QuoronaPotions.createEffectInstance(effect, duration, 0, particles);
    }
    
    public static EffectInstance createEffectInstance(Effect effect, int duration, int amplifier, boolean particles)
    {
        EffectInstance ef = new EffectInstance(effect, duration, amplifier, false, particles);
        ef.setCurativeItems(new ArrayList<ItemStack>());
        return ef;
    }
}
