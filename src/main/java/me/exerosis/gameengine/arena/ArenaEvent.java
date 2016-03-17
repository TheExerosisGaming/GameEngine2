package me.exerosis.gameengine.arena;

import org.bukkit.event.Event;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public abstract class ArenaEvent extends Event {

    private Arena arena;

    public ArenaEvent(Arena arena)
    {
        this.arena = arena;
    }

    public Arena getArena()
    {
        return arena;
    }

    public void setArena(Arena arena)
    {
        this.arena = arena;
    }
}
