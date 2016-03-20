package me.exerosis.gameengine.games;

import me.exerosis.gameengine.component.game.Game;
import me.exerosis.gameengine.component.game.GameComponent;
import me.exerosis.gameengine.component.player.PlayerComponent;

/**
 * Durpped in to existence by Exerosis on 3/20/2016.
 */
public class ExampleGame implements Game {

    private PlayerComponent playerComponent;

    public ExampleGame(PlayerComponent playerComponent)
    {
        this.playerComponent = playerComponent;
    }

    @Override
    public void start(GameComponent gameComponent)
    {

    }
}
