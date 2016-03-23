package me.exerosis.gameengine.implementation.components.interaction;

import me.exerosis.gameengine.component.ComponentPlayerListener;
import me.exerosis.gameengine.common.utils.BlockUtilities;
import me.exerosis.gameengine.common.utils.Filter;
import me.exerosis.gameengine.common.utils.ItemFilter;
import me.exerosis.gameengine.common.playerholder.PlayerHolder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class NoBlockBreak extends ComponentPlayerListener {

    private Filter<ItemStack> filter;

    public NoBlockBreak(PlayerHolder playerHolder)
    {
        this(playerHolder, null);
    }

    public NoBlockBreak(PlayerHolder playerHolder, Filter<ItemStack> filter)
    {
        super(playerHolder);
        if (filter == null)
            filter = new ItemFilter(true);
        this.filter = filter;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event)
    {
        if (hasPlayer(event.getPlayer()) && filter.filter(BlockUtilities.toItemStack(event.getBlock())))
            event.setCancelled(true);
    }
}
