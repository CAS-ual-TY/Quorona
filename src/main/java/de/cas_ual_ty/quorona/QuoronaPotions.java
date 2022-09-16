package de.cas_ual_ty.quorona;

import net.minecraft.potion.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class QuoronaPotions
{
    private static final DeferredRegister<Potion> DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.POTION_TYPES, Quorona.MOD_ID);
    
    public static final RegistryObject<Potion> THE_FLOO = DEFERRED_REGISTER.register("the_floo", () -> new Potion(Quorona.createEffectInstance(QuoronaEffects.THE_FLOO.get(), Quorona.DEFAULT_THE_FLOO_TIME, false)));
    public static final RegistryObject<Potion> LONG_THE_FLOO = DEFERRED_REGISTER.register("long_the_floo", () -> new Potion("the_floo", Quorona.createEffectInstance(QuoronaEffects.THE_FLOO.get(), Quorona.DEFAULT_THE_FLOO_TIME * 3 / 2, false)));
    public static final RegistryObject<Potion> STRONG_THE_FLOO = DEFERRED_REGISTER.register("strong_the_floo", () -> new Potion("the_floo", Quorona.createEffectInstance(QuoronaEffects.THE_FLOO.get(), Quorona.DEFAULT_THE_FLOO_TIME / 2, 1, false)));
    public static final RegistryObject<Potion> SHORT_THE_FLOO = DEFERRED_REGISTER.register("short_the_floo", () -> new Potion("the_floo", Quorona.createEffectInstance(QuoronaEffects.THE_FLOO.get(), Quorona.DEFAULT_THE_FLOO_TIME / 100, 1, false)));
    
    public static void register(IEventBus modBus)
    {
        DEFERRED_REGISTER.register(modBus);
    }
    
}
