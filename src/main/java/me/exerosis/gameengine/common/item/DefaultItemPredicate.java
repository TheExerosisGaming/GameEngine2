package me.exerosis.gameengine.common.item;

import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class DefaultItemPredicate implements Predicate<ItemStack> {
    @Override
    public boolean test(ItemStack itemStack)
    {
        return true;
    }
}
