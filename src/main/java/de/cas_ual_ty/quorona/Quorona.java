package de.cas_ual_ty.quorona;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Quorona.MOD_ID)
public class Quorona
{
    public static final String MOD_ID = "quorona";
    
    public static final int DEFAULT_QUORONA_TIME = 224000;
    public static final int DEFAULT_IMMUNITY_TIME = 720000;
    
    public Quorona()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.addListener(this::livingSpawn);
    }
    
    private void setup(FMLCommonSetupEvent event)
    {
        BrewingRecipeRegistry.addRecipe(new QuoronaBrewingRecipe(QuoronaPotions.QUORONA, Items.REDSTONE, QuoronaPotions.LONG_QUORONA));
        BrewingRecipeRegistry.addRecipe(new QuoronaBrewingRecipe(QuoronaPotions.QUORONA, Items.GLOWSTONE_DUST, QuoronaPotions.STRONG_QUORONA));
        BrewingRecipeRegistry.addRecipe(new QuoronaBrewingRecipe(Potions.AWKWARD, QuoronaItems.DEAD_BAT, QuoronaPotions.QUORONA));
    }
    
    private void livingSpawn(LivingSpawnEvent.SpecialSpawn event)
    {
        if((event.getEntity().getType() == EntityType.WITCH) && !event.getWorld().isRemote() && (event.getWorld().getRandom().nextInt(20) == 0))
        {
            event.getEntityLiving().addPotionEffect(QuoronaPotions.createEffectInstance(QuoronaEffects.QUORONA, Quorona.DEFAULT_QUORONA_TIME, true));
        }
    }
}
