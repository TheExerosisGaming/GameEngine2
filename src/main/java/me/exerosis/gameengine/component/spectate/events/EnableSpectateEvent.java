package me.exerosis.gameengine.component.spectate.events;

import me.exerosis.gameengine.common.playerholder.PlayerHolder;
import me.exerosis.gameengine.common.playerholder.events.PlayerAddEvent;
import org.bukkit.entity.Player;

/**
 * Durpped in to existence by Exerosis on 3/20/2016.
 */
public class EnableSpectateEvent extends PlayerAddEvent {

    public EnableSpectateEvent(PlayerHolder playerHolder, Player player)
    {
        super(playerHolder, player);
    }

}
