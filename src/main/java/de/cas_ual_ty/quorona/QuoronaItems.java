package de.cas_ual_ty.quorona;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class QuoronaItems
{
    private static final DeferredRegister<Item> DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Quorona.MOD_ID);
    
    public static final RegistryObject<Item> DEAD_BAT = DEFERRED_REGISTER.register("dead_bat", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.8F).meat().build())));
    
    public static void register(IEventBus modBus)
    {
        DEFERRED_REGISTER.register(modBus);
        modBus.addListener(QuoronaItems::creativeModeTabs);
    }
    
    public static void creativeModeTabs(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
        {
            event.accept(DEAD_BAT);
        }
    }
}
