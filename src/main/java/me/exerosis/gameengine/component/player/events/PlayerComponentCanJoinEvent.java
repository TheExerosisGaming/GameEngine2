package me.exerosis.gameengine.component.player.events;

import me.exerosis.gameengine.component.ComponentEvent;
import me.exerosis.gameengine.component.player.PlayerComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class PlayerComponentCanJoinEvent extends ComponentEvent<PlayerComponent> implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean isCancelled;
    private Player player;


    public PlayerComponentCanJoinEvent(PlayerComponent playerComponent, Player player)
    {
        super(playerComponent);
        this.player = player;
    }

    public static HandlerList getHandlerList()
    {
        return handlers;
    }

    @Override
    public HandlerList getHandlers()
    {
        return handlers;
    }

    public Player getPlayer()
    {
        return player;
    }

    @Override
    public boolean isCancelled()
    {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled)
    {
        this.isCancelled = isCancelled;
    }
}
