package me.exerosis.gameengine.implementation.components.interaction;

import me.exerosis.gameengine.core.arena.Arena;
import me.exerosis.gameengine.core.component.ComponentListener;
import me.exerosis.gameengine.utils.ItemFilter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class NoBlockBreak extends ComponentListener {

    private ItemFilter filter;

    public NoBlockBreak(Arena arena, ItemFilter filter)
    {
        super(arena);
        this.filter = filter;
    }

    public boolean contains(ItemStack item)
    {
        return this.whitelist && this.data.contains(item.getData());
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event)
    {
        if (!getArena().hasPlayer(event.getPlayer()) || !this.filter.filter(event. (filter).))
        return;
        event.setCancelled(true);
    }
}
