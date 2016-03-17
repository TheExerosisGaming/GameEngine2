package me.exerosis.gameengine.implementation.events.arena;

import me.exerosis.gameengine.core.arena.Arena;
import org.bukkit.event.HandlerList;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class ArenaStartEvent extends ArenaEvent {

    private static final HandlerList handlers = new HandlerList();

    public ArenaStartEvent(Arena arena)
    {
        super(arena);
    }

    public static HandlerList getHandlerList()
    {
        return handlers;
    }

    @Override
    public HandlerList getHandlers()
    {
        return handlers;
    }
}
