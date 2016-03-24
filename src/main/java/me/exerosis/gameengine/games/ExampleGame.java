package me.exerosis.gameengine.games;

import me.exerosis.gameengine.component.Component;
import me.exerosis.gameengine.component.game.Game;
import me.exerosis.gameengine.component.game.GameComponent;
import me.exerosis.gameengine.component.gamestate.GameState;
import me.exerosis.gameengine.component.gamestate.GameStateComponent;
import me.exerosis.gameengine.component.player.PlayerComponent;
import me.exerosis.gameengine.implementation.components.interaction.NoBlockBreak;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



        NoBlockBreak noBlockBreak0 = new NoBlockBreak();

        NoBlockBreak noBlockBreak1 = new NoBlockBreak();

        NoBlockBreak noBlockBreak2 = new NoBlockBreak();

        NoBlockBreak noBlockBreak3 = new NoBlockBreak();

        NoBlockBreak noBlockBreak4 = new NoBlockBreak();

        Map<GameState, List<Component>> map = new HashMap<>();

        map.put(GameState.LOBBY, Arrays.asList(noBlockBreak0, noBlockBreak1, noBlockBreak3));

        map.put(GameState.PRE_GAME, Arrays.asList(noBlockBreak0, noBlockBreak1, noBlockBreak4));

        map.put(GameState.IN_GAME, Arrays.asList(noBlockBreak1, noBlockBreak2, noBlockBreak3));

        map.put(GameState.POST_GAME, Arrays.asList(noBlockBreak0, noBlockBreak3, noBlockBreak4));



        Map<Component, List<GameState>> map = new HashMap<>();

        map.put(new NoBlockBreak(), Arrays.asList(GameState.PRE_GAME, GameState.POST_GAME));

        map.put(new NoBlockBreak(), Arrays.asList(GameState.LOBBY, GameState.POST_GAME));

        map.put(new NoBlockBreak(), Arrays.asList(GameState.PRE_GAME, GameState.IN_GAME));

        map.put(new NoBlockBreak(), Arrays.asList(GameState.PRE_GAME, GameState.POST_GAME));

        map.put(new NoBlockBreak(), Arrays.asList(GameState.PRE_GAME, GameState.POST_GAME));

    }
}
