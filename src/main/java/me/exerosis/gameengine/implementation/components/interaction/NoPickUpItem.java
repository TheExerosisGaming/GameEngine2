package me.exerosis.gameengine.implementation.components.interaction;

import me.exerosis.gameengine.arena.Arena;
import me.exerosis.gameengine.component.ComponentListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import java.util.Collection;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class NoPickUpItem extends ComponentListener {

    private boolean whitelist;

    private Collection<MaterialData> data;

    public NoPickUpItem(Arena arena, boolean whitelist, Collection<MaterialData> data)
    {
        super(arena);
        this.whitelist = whitelist;
        this.data = data;
    }

    public boolean contains(ItemStack item)
    {
        return this.whitelist && this.data.contains(item.getData());
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event)
    {
        if (!getArena().hasPlayer(event.getPlayer()))
            return;
        event.setCancelled(true);
    }
}
