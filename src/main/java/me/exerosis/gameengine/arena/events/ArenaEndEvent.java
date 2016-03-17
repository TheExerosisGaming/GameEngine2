package me.exerosis.gameengine.arena.events;

import me.exerosis.gameengine.arena.Arena;
import me.exerosis.gameengine.arena.ArenaEvent;
import org.bukkit.event.HandlerList;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class ArenaEndEvent extends ArenaEvent {

    private static final HandlerList handlers = new HandlerList();

    public ArenaEndEvent(Arena arena)
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
