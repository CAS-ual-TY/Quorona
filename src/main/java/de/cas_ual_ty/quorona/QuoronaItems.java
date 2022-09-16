package de.cas_ual_ty.quorona;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class QuoronaItems
{
    private static final DeferredRegister<Item> DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Quorona.MOD_ID);
    
    public static final RegistryObject<Item> DEAD_BAT = DEFERRED_REGISTER.register("dead_bat", () -> new Item(new Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().saturationMod(0.1F).effect(() -> new EffectInstance(Effects.HUNGER, 600, 0), 0.8F).meat().build())));
    
    public static void register(IEventBus modBus)
    {
        DEFERRED_REGISTER.register(modBus);
    }
}
