package me.exerosis.gameengine.game.events;

import me.exerosis.gameengine.component.ComponentEvent;
import me.exerosis.gameengine.game.GameComponent;
import org.bukkit.event.HandlerList;

/**
 * Durpped in to existence by Exerosis on 3/19/2016.
 */
public class GameStartEvent extends ComponentEvent<GameComponent> {

    private static final HandlerList handlers = new HandlerList();

    public GameStartEvent(GameComponent component)
    {
        super(component);
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