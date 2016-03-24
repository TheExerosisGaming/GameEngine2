package me.exerosis.gameengine.component.simple;

import me.exerosis.gameengine.common.item.DefaultItemPredicate;
import me.exerosis.gameengine.common.utils.BlockUtilities;
import me.exerosis.gameengine.component.ComponentListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class NoBlockPlace extends ComponentListener {

    private Predicate<Player> playerPredicate;

    private Predicate<ItemStack> itemPredicate;

    public NoBlockPlace(Predicate<Player> playerPredicate)
    {
        this(playerPredicate, new DefaultItemPredicate());
    }

    public NoBlockPlace(Predicate<Player> playerPredicate, Predicate<ItemStack> itemPredicate)
    {
        this.playerPredicate = playerPredicate;
        this.itemPredicate = itemPredicate;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event)
    {
        if (playerPredicate.test(event.getPlayer()) && itemPredicate.test(BlockUtilities.toItemStack(event.getBlock())))
            event.setCancelled(true);
    }
}
