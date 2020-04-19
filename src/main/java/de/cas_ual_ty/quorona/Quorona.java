package de.cas_ual_ty.quorona;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Quorona.MOD_ID)
public class Quorona
{
    // Had to rename this for CurseForge for no reason given whatsoever.
    // CurseForge moderators approved the mod but Twitch devs unapproved it.
    public static final String MOD_ID = "the_floo";
    
    public static final int DEFAULT_THE_FLOO_TIME = 224000;
    public static final int DEFAULT_IMMUNITY_TIME = 720000;
    
    public Quorona()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.addListener(this::livingSpawn);
        MinecraftForge.EVENT_BUS.addListener(this::villagerTrades);
    }
    
    private void setup(FMLCommonSetupEvent event)
    {
        BrewingRecipeRegistry.addRecipe(new QuoronaBrewingRecipe(QuoronaPotions.THE_FLOO, Items.REDSTONE, QuoronaPotions.LONG_THE_FLOO));
        BrewingRecipeRegistry.addRecipe(new QuoronaBrewingRecipe(QuoronaPotions.THE_FLOO, Items.GLOWSTONE_DUST, QuoronaPotions.STRONG_THE_FLOO));
        BrewingRecipeRegistry.addRecipe(new QuoronaBrewingRecipe(Potions.AWKWARD, QuoronaItems.DEAD_BAT, QuoronaPotions.THE_FLOO));
    }
    
    private void livingSpawn(LivingSpawnEvent.SpecialSpawn event)
    {
        if((event.getEntity().getType() == EntityType.WITCH) && !event.getWorld().isRemote() && (event.getWorld().getRandom().nextInt(20) == 0))
        {
            event.getEntityLiving().addPotionEffect(QuoronaPotions.createEffectInstance(QuoronaEffects.THE_FLOO, Quorona.DEFAULT_THE_FLOO_TIME, true));
        }
    }
    
    private void villagerTrades(VillagerTradesEvent event)
    {
        if(event.getType() == VillagerProfession.CLERIC)
        {
            ItemStack potion = new ItemStack(Items.POTION);
            PotionUtils.addPotionToItemStack(potion, QuoronaPotions.SHORT_THE_FLOO);
            event.getTrades().get(3).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 12), potion, 4, 10, 0.05F));
        }
    }
}
