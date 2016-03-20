package me.exerosis.gameengine.arena;

import me.exerosis.gameengine.component.game.GameComponent;
import me.exerosis.gameengine.component.game.SingleGameComponent;
import me.exerosis.gameengine.component.player.PlayerComponent;
import me.exerosis.gameengine.component.player.SimplePlayerComponent;
import me.exerosis.gameengine.games.ExampleGame;

/**
 * Durpped in to existence by Exerosis on 3/20/2016.
 */
public class GameArena {

    private PlayerComponent playerComponent;

    private GameComponent gameComponent;

    public GameArena()
    {
        this.playerComponent = new SimplePlayerComponent();


        this.gameComponent = new SingleGameComponent(new ExampleGame());


    }
}
