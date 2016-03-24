package me.exerosis.gameengine.game.games.runner;

import me.exerosis.gameengine.common.utils.ListUtilities;
import me.exerosis.gameengine.component.player.PlayerComponent;
import me.exerosis.gameengine.component.simple.NoBlockBreak;
import me.exerosis.gameengine.game.Game;
import me.exerosis.gameengine.game.GameComponent;
import me.exerosis.gameengine.game.gamestate.GameState;
import me.exerosis.gameengine.game.gamestate.GameStateComponent;
import me.exerosis.gameengine.game.gamestate.GameStateComponentManager;

import java.util.List;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class RunnerGame implements Game {

    private PlayerComponent playerComponent;

    public RunnerGame(PlayerComponent playerComponent)
    {
        this.playerComponent = playerComponent;
    }

    @Override
    public void start(GameComponent gameComponent)
    {

        GameStateComponent gameStateComponent = new GameStateComponent(gameComponent);


        GameStateComponentManager gameStateComponentManager = new GameStateComponentManager(gameComponent, gameStateComponent);



        gameStateComponentManager.addComponents(GameState.LOBBY, );








    }
}
