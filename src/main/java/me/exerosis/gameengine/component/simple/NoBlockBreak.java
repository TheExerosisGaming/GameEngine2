package me.exerosis.gameengine.component.simple;

import me.exerosis.gameengine.common.item.DefaultPredicate;
import me.exerosis.gameengine.common.utils.BlockUtilities;
import me.exerosis.gameengine.component.ComponentListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class NoBlockBreak extends ComponentListener {

    private Predicate<Player> playerPredicate;

    private Predicate<ItemStack> itemPredicate;

    public NoBlockBreak(Predicate<Player> playerPredicate)
    {
        this(playerPredicate, new DefaultPredicate<>());
    }

    public NoBlockBreak(Predicate<Player> playerPredicate, Predicate<ItemStack> itemPredicate)
    {
        this.playerPredicate = playerPredicate;
        this.itemPredicate = itemPredicate;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event)
    {
        if (playerPredicate.test(event.getPlayer()) && itemPredicate.test(BlockUtilities.toItemStack(event.getBlock())))
            event.setCancelled(true);

    }
}
