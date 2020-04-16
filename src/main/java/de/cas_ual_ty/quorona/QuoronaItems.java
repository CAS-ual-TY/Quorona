package de.cas_ual_ty.quorona;

import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = Quorona.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Quorona.MOD_ID)
public class QuoronaItems
{
    public static final Item DEAD_BAT = null;
    
    @SubscribeEvent
    public static void register(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new Item(new Properties().group(ItemGroup.FOOD).food(QuoronaFoods.DEAD_BAT)).setRegistryName(Quorona.MOD_ID, "dead_bat"));
    }
}
