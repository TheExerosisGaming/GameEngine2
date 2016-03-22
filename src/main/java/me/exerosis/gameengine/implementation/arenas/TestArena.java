package me.exerosis.gameengine.implementation.arenas;

import me.exerosis.gameengine.arena.Arena;
import me.exerosis.gameengine.component.game.Game;
import me.exerosis.gameengine.component.player.PlayerComponent;
import me.exerosis.gameengine.component.player.SimplePlayerComponent;
import me.exerosis.gameengine.games.ExampleGame;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class TestArena implements Arena {

    private PlayerComponent playerComponent;

    public TestArena()
    {
        playerComponent = new SimplePlayerComponent();

        Game game = new ExampleGame(playerComponent);


    }
}
