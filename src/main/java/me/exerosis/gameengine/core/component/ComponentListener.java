package me.exerosis.gameengine.core.component;

import me.exerosis.gameengine.core.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class ComponentListener implements Component, Listener {

    private boolean enabled = false;

    private Arena arena;

    public ComponentListener(Arena arena)
    {
        this.arena = arena;
    }

    @Override
    public boolean isEnabled()
    {
        return this.enabled;
    }

    @Override
    public void onEnable()
    {
        this.enabled = true;
        Bukkit.getPluginManager().registerEvents(this, getArena().getPlugin());
    }

    @Override
    public void onDisable()
    {
        this.enabled = false;
        HandlerList.unregisterAll(this);
    }

    public Arena getArena()
    {
        return arena;
    }
}
