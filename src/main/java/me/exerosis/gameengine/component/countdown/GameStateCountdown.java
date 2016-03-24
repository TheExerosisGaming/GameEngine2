package me.exerosis.gameengine.component.countdown;

import me.exerosis.gameengine.common.playerholder.PlayerHolder;
import me.exerosis.gameengine.component.gamestate.GameState;
import me.exerosis.gameengine.component.gamestate.GameStateComponent;
import org.bukkit.ChatColor;

import java.util.concurrent.ScheduledExecutorService;

/**
 * Durpped in to existence by Exerosis on 3/23/2016.
 */
public class GameStateCountdown extends CountdownBase {

    private GameStateComponent gameStateComponent;
    private GameState gameStateToSet;

    private PlayerHolder playerHolder;

    public GameStateCountdown(ScheduledExecutorService scheduler, int startTime, GameStateComponent gameStateComponent, GameState gameStateToSet, PlayerHolder playerHolder)
    {
        super(scheduler, startTime);
        this.gameStateComponent = gameStateComponent;
        this.gameStateToSet = gameStateToSet;
        this.playerHolder = playerHolder;
    }

    @Override
    public void onStart()
    {
    }

    @Override
    public void onStop()
    {
    }

    @Override
    public void onFinish()
    {
        this.getGameStateComponent().setGameState(this.getGameStateToSet());
    }

    @Override
    public void count(int counter)
    {
        getPlayerHolder().broadcast(ChatColor.GREEN + "GameStarting in " + ChatColor.RED + counter + ChatColor.GREEN + " second" + (counter > 0 ? "s" : "") + ".");
    }

    public GameStateComponent getGameStateComponent()
    {
        return gameStateComponent;
    }

    public GameState getGameStateToSet()
    {
        return gameStateToSet;
    }

    public PlayerHolder getPlayerHolder()
    {
        return playerHolder;
    }
}
