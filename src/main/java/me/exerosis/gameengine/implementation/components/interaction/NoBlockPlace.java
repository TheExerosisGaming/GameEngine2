package me.exerosis.gameengine.implementation.components.interaction;

import me.exerosis.gameengine.component.ComponentPlayerListener;
import me.exerosis.gameengine.common.utils.BlockUtilities;
import me.exerosis.gameengine.common.playerholder.PlayerHolder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class NoBlockPlace extends ComponentPlayerListener {

    private Filter<ItemStack> filter;

    public NoBlockPlace(PlayerHolder playerHolder, Filter<ItemStack> filter)
    {
        super(playerHolder);
        this.filter = filter;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event)
    {
        if (hasPlayer(event.getPlayer()) && filter.test(BlockUtilities.toItemStack(event.getBlock())))
            event.setCancelled(true);
    }
}
