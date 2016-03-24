package me.exerosis.gameengine.component.simple;

import me.exerosis.gameengine.common.item.DefaultPredicate;
import me.exerosis.gameengine.component.ComponentListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class NoPickUpItem extends ComponentListener {

    private Predicate<Player> playerPredicate;

    private Predicate<ItemStack> itemPredicate;

    public NoPickUpItem(Predicate<Player> playerPredicate)
    {
        this(playerPredicate, new DefaultPredicate<>());
    }

    public NoPickUpItem(Predicate<Player> playerPredicate, Predicate<ItemStack> itemPredicate)
    {
        this.playerPredicate = playerPredicate;
        this.itemPredicate = itemPredicate;
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event)
    {
        if (playerPredicate.test(event.getPlayer()) && itemPredicate.test(event.getItem().getItemStack()))
            event.setCancelled(true);
    }
}

