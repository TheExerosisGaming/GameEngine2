package me.exerosis.gameengine.component.gamestate.events;

import me.exerosis.gameengine.component.ComponentEvent;
import me.exerosis.gameengine.component.gamestate.GameState;
import me.exerosis.gameengine.component.gamestate.GameStateComponent;
import org.bukkit.event.HandlerList;

/**
 * Durpped in to existence by Exerosis on 3/20/2016.
 */
public class GameStateChangeEvent extends ComponentEvent<GameStateComponent> {

    private static final HandlerList handlers = new HandlerList();
    private GameState fromGameState;
    private GameState toGameState;

    public GameStateChangeEvent(GameStateComponent component, GameState fromGameState, GameState toGameState)
    {
        super(component);
        this.fromGameState = fromGameState;
        this.toGameState = toGameState;
    }

    public static HandlerList getHandlerList()
    {
        return handlers;
    }

    public GameState getFromGameState()
    {
        return fromGameState;
    }

    public GameState getToGameState()
    {
        return toGameState;
    }

    @Override
    public HandlerList getHandlers()
    {
        return handlers;
    }
}
