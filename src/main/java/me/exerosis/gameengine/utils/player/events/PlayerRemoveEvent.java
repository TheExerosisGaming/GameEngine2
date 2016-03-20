package me.exerosis.gameengine.utils.player.events;

import me.exerosis.gameengine.utils.player.PlayerHolder;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Durpped in to existence by Exerosis on 3/20/2016.
 */
public class PlayerRemoveEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private PlayerHolder playerHolder;
    private Player player;

    public PlayerRemoveEvent(PlayerHolder playerHolder, Player player)
    {
        this.playerHolder = playerHolder;
        this.player = player;
    }

    public static HandlerList getHandlerList()
    {
        return handlers;
    }

    public PlayerHolder getPlayerHolder()
    {
        return this.playerHolder;
    }

    public Player getPlayer()
    {
        return player;
    }

    @Override
    public HandlerList getHandlers()
    {
        return handlers;
    }


}
