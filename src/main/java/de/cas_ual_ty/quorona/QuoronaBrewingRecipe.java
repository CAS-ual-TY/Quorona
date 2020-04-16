package de.cas_ual_ty.quorona;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;

public class QuoronaBrewingRecipe implements IBrewingRecipe
{
    private final Potion input;
    private final Item ingredient;
    private final Potion output;
    
    public QuoronaBrewingRecipe(Potion input, Item ingredient, Potion output)
    {
        this.input = input;
        this.ingredient = ingredient;
        this.output = output;
    }
    
    @Override
    public boolean isInput(ItemStack input)
    {
        return PotionUtils.getPotionFromItem(input) == this.input;
    }
    
    @Override
    public boolean isIngredient(ItemStack ingredient)
    {
        return ingredient.getItem() == this.ingredient;
    }
    
    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient)
    {
        if(!this.isInput(input) || !this.isIngredient(ingredient))
        {
            return ItemStack.EMPTY;
        }
        
        ItemStack itemStack = new ItemStack(Items.POTION);
        itemStack.setTag(new CompoundNBT());
        PotionUtils.addPotionToItemStack(itemStack, this.output);
        return itemStack;
    }
}
