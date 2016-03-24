package me.exerosis.gameengine.game.gamestate;

import me.exerosis.gameengine.Main;
import me.exerosis.gameengine.game.GameComponent;
import me.exerosis.gameengine.game.events.GameEndEvent;
import me.exerosis.gameengine.game.events.GameStartEvent;
import me.exerosis.gameengine.game.gamestate.events.GameStateChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/**
 * Durpped in to existence by Exerosis on 3/20/2016.
 */
public class GameStateComponent implements Listener {

    private GameState gameState;

    private GameComponent gameComponent;

    public GameStateComponent(GameComponent gameComponent)
    {
        this.gameComponent = gameComponent;
        Main.registerEvents(this);
    }

    //Listeners
    @EventHandler
    public void onStart(GameStartEvent event)
    {
        if (event.getComponent() != this.gameComponent)
            return;
        this.setGameState(GameState.LOBBY);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onEnd(GameEndEvent event)
    {
        if (event.getComponent() != this.gameComponent)
            return;
        this.setGameState(GameState.RESTARTING);
        Main.unregisterEvents(this);
    }


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
