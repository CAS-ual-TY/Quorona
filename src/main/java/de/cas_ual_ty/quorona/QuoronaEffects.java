package de.cas_ual_ty.quorona;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class QuoronaEffects
{
    private static final DeferredRegister<MobEffect> DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Quorona.MOD_ID);
    
    public static final RegistryObject<MobEffect> THE_FLOO = DEFERRED_REGISTER.register("the_floo", QuoronaEffect::new);
    public static final RegistryObject<MobEffect> IMMUNITY = DEFERRED_REGISTER.register("immunity", ImmunityEffect::new);
    
    public static void register(IEventBus modBus)
    {
        DEFERRED_REGISTER.register(modBus);
    }
}
