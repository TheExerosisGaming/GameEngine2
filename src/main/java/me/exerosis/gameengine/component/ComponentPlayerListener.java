package me.exerosis.gameengine.component;


import me.exerosis.gameengine.common.playerholder.PlayerHolder;
import org.bukkit.entity.Player;

import java.util.Collection;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class ComponentPlayerListener extends ComponentListener {

    private PlayerHolder playerHolder;

    public ComponentPlayerListener(PlayerHolder playerHolder)
    {
        this.playerHolder = playerHolder;
    }

    public Collection<Player> getPlayers()
    {
        return getPlayerHolder().getPlayers();
    }

    public boolean hasPlayer(Player player)
    {
        return getPlayerHolder().filter(player);
    }

    public PlayerHolder getPlayerHolder()
    {
        return playerHolder;
    }
}
