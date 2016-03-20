package me.exerosis.gameengine.component.player.events;

import me.exerosis.gameengine.component.player.PlayerComponent;
import me.exerosis.gameengine.utils.player.events.PlayerAddEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class PlayerComponentJoinEvent extends PlayerAddEvent {

    private static final HandlerList handlers = new HandlerList();

    public PlayerComponentJoinEvent(PlayerComponent playerComponent, Player player)
    {
        super(playerComponent, player);
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

    @Override
    public PlayerComponent getPlayerHolder()
    {
        return (PlayerComponent) super.getPlayerHolder();
    }
}
