package de.cas_ual_ty.quorona;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.potion.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;

@Mod(Quorona.MOD_ID)
public class Quorona
{
    public static final String MOD_ID = "the_floo";
    
    public static final int DEFAULT_THE_FLOO_TIME = 224000;
    public static final int DEFAULT_IMMUNITY_TIME = 720000;
    
    public Quorona()
    {
        QuoronaItems.register(FMLJavaModLoadingContext.get().getModEventBus());
        QuoronaEffects.register(FMLJavaModLoadingContext.get().getModEventBus());
        QuoronaPotions.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.addListener(this::livingSpawn);
        MinecraftForge.EVENT_BUS.addListener(this::villagerTrades);
    }
    
    private void setup(FMLCommonSetupEvent event)
    {
        PotionBrewing.addMix(QuoronaPotions.THE_FLOO.get(), Items.REDSTONE, QuoronaPotions.LONG_THE_FLOO.get());
        PotionBrewing.addMix(QuoronaPotions.THE_FLOO.get(), Items.GLOWSTONE_DUST, QuoronaPotions.STRONG_THE_FLOO.get());
        PotionBrewing.addMix(Potions.AWKWARD, QuoronaItems.DEAD_BAT.get(), QuoronaPotions.THE_FLOO.get());
    }
    
    private void livingSpawn(LivingSpawnEvent.SpecialSpawn event)
    {
        if((event.getEntity().getType() == EntityType.WITCH) && !event.getWorld().isClientSide() && (event.getWorld().getRandom().nextInt(20) == 0))
        {
            event.getEntityLiving().addEffect(createEffectInstance(QuoronaEffects.THE_FLOO.get(), Quorona.DEFAULT_THE_FLOO_TIME, true));
        }
    }
    
    private void villagerTrades(VillagerTradesEvent event)
    {
        if(event.getType() == VillagerProfession.CLERIC)
        {
            ItemStack potion = new ItemStack(Items.POTION);
            PotionUtils.setPotion(potion, QuoronaPotions.SHORT_THE_FLOO.get());
            event.getTrades().get(3).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 12), potion, 4, 10, 0.05F));
        }
    }
    
    public static EffectInstance createEffectInstance(Effect effect, int duration, boolean particles)
    {
        return createEffectInstance(effect, duration, 0, particles);
    }
    
    public static EffectInstance createEffectInstance(Effect effect, int duration, int amplifier, boolean particles)
    {
        EffectInstance ef = new EffectInstance(effect, duration, amplifier, false, particles);
        ef.setCurativeItems(new ArrayList<>());
        return ef;
    }
}
