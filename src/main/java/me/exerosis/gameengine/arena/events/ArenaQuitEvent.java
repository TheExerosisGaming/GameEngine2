package me.exerosis.gameengine.arena.events;

import me.exerosis.gameengine.arena.Arena;
import me.exerosis.gameengine.arena.ArenaEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class ArenaQuitEvent extends ArenaEvent {

    private static final HandlerList handlers = new HandlerList();

    private Player player;

    public ArenaQuitEvent(Arena arena, Player player)
    {
        super(arena);
        this.player = player;
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

    public Player getPlayer()
    {
        return player;
    }
}
