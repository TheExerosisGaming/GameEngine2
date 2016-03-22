package me.exerosis.gameengine.component.gamestate;

import me.exerosis.gameengine.component.gamestate.events.GameStateChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

/**
 * Durpped in to existence by Exerosis on 3/20/2016.
 */
public class GameStateComponent implements Listener {

    private GameState gameState;

    public GameState getGameState()
    {
        return gameState;
    }

    public void setGameState(GameState toGameState)
    {
        GameState fromGameState = getGameState();

        this.gameState = toGameState;

        GameStateChangeEvent event = new GameStateChangeEvent(this, fromGameState, toGameState);

        Bukkit.getPluginManager().callEvent(event);

    }
}
