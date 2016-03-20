package me.exerosis.gameengine.component.game;

import me.exerosis.gameengine.component.game.events.GameEndEvent;
import me.exerosis.gameengine.component.game.events.GameStartEvent;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;

/**
 * Durpped in to existence by Exerosis on 3/20/2016.
 */
public abstract class BaseGameComponent implements GameComponent {

    private Game game;

    @Override
    public void endGame()
    {
        //TODO better
        System.out.println("Game Ended");
        Bukkit.getServer().getPluginManager().callEvent(new GameEndEvent(this));
        this.game = null;
    }

    protected boolean startGame(Game game)
    {
        Validate.notNull(game, "Game cannot be null!");

        if (this.game != null)
            return false;

        this.game = game;
        game.start(this);
        Bukkit.getPluginManager().callEvent(new GameStartEvent(this));
        return true;
    }

    @Override
    public Game getGame()
    {
        return game;
    }
}
