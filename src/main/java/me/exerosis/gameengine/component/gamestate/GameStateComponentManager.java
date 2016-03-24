package me.exerosis.gameengine.component.gamestate;

import me.exerosis.gameengine.Main;
import me.exerosis.gameengine.component.Component;
import me.exerosis.gameengine.component.game.GameComponent;
import me.exerosis.gameengine.component.game.events.GameEndEvent;
import me.exerosis.gameengine.component.gamestate.events.GameStateChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.*;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class GameStateComponentManager implements Listener {

    private GameStateComponent gameStateComponent;

    private GameComponent gameComponent;

    private Map<GameState, Set<Component>> components = new HashMap<>();

    public GameStateComponentManager(GameComponent gameComponent, GameStateComponent gameStateComponent)
    {
        this.gameStateComponent = gameStateComponent;
        this.gameComponent = gameComponent;

        for (GameState gameState : GameState.values())
        {
            components.put(gameState, new HashSet<>());
        }
        components.remove(GameState.RESTARTING);

        Main.registerEvents(this);
    }

    @EventHandler
    public void onGameStateChange(GameStateChangeEvent event)
    {
        if (event.getComponent() != this.gameStateComponent)
            return;


        //Set last
        Set<Component> lastComponents = this.components.get(event.getFromGameState());

        if (lastComponents == null)
            lastComponents = Collections.emptySet();


        //Set next
        Set<Component> nextComponents = this.components.get(event.getToGameState());

        if (nextComponents == null)
            nextComponents = Collections.emptySet();

        //Disable
        Set<Component> toDisable = new HashSet<>(lastComponents);
        toDisable.removeAll(nextComponents);
        toDisable.forEach(Component::disable);


        //Enable
        Set<Component> toEnable = new HashSet<>(nextComponents);
        toEnable.removeAll(lastComponents);
        toEnable.forEach(Component::enable);

    }



    @EventHandler
    public void onEndGame(GameEndEvent event)
    {
        if (event.getComponent() != this.gameComponent)
            return;

        for (Set<Component> set : this.components.values())
            set.forEach(Component::disable);

        Main.unregisterEvents(this);
    }





    //Add & Remove Component
    public boolean addComponent(Component component, GameState... gameStates)
    {
        return addComponents(Arrays.asList(gameStates), Collections.singleton(component));
    }

    public boolean addComponent(GameState gameState, Component component)
    {
        return addComponents(Collections.singleton(gameState), Collections.singleton(component));
    }

    public boolean addComponents(GameState gameState, Component... componentsToAdd)
    {
        return addComponents(Collections.singleton(gameState), Arrays.asList(componentsToAdd));
    }

    public boolean addComponents(GameState[] gameStates, Component... componentsToAdd)
    {
        return addComponents(Arrays.asList(gameStates), Arrays.asList(componentsToAdd));
    }

    public boolean addComponents(Collection<GameState> gameStates, Collection<Component> componentsToAdd)
    {
        boolean modified = false;

        for (GameState gameState : gameStates)
        {
            if (gameState.equals(GameState.RESTARTING))
                continue;

            if (components.get(gameState).addAll(componentsToAdd))
                modified = true;
        }
        return  modified;
    }

    public boolean removeComponent(Collection<Component> componentsToRemove)
    {
        boolean modified = false;

        for (Set<Component> set : components.values())
        {
            if (set.removeAll(componentsToRemove))
                modified = true;
        }

        return  modified;
    }


}
