package de.cas_ual_ty.quorona;

import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = Quorona.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Quorona.MOD_ID)
public class QuoronaEffects
{
    public static final Effect THE_FLOO = null;
    public static final Effect IMMUNITY = null;
    
    @SubscribeEvent
    public static void register(RegistryEvent.Register<Effect> event)
    {
        event.getRegistry().register(new QuoronaEffect().setRegistryName(Quorona.MOD_ID, "the_floo"));
        event.getRegistry().register(new ImmunityEffect().setRegistryName(Quorona.MOD_ID, "immunity"));
    }
}
