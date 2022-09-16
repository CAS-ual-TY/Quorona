package de.cas_ual_ty.quorona;

import net.minecraft.potion.Effect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class QuoronaEffects
{
    private static final DeferredRegister<Effect> DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.POTIONS, Quorona.MOD_ID);
    
    public static final RegistryObject<Effect> THE_FLOO = DEFERRED_REGISTER.register("the_floo", QuoronaEffect::new);
    public static final RegistryObject<Effect> IMMUNITY = DEFERRED_REGISTER.register("immunity", ImmunityEffect::new);
    
    public static void register(IEventBus modBus)
    {
        DEFERRED_REGISTER.register(modBus);
    }
}
