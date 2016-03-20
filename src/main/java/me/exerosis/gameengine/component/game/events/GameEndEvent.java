package me.exerosis.gameengine.component.game.events;

import me.exerosis.gameengine.component.ComponentEvent;
import me.exerosis.gameengine.component.game.GameComponent;
import org.bukkit.event.HandlerList;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class GameEndEvent extends ComponentEvent<GameComponent> {

    private static final HandlerList handlers = new HandlerList();

    public GameEndEvent(GameComponent component)
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
