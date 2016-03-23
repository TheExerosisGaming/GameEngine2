package me.exerosis.gameengine.component.spectate.events;

import me.exerosis.gameengine.common.playerholder.PlayerHolder;
import me.exerosis.gameengine.common.playerholder.events.PlayerRemoveEvent;
import org.bukkit.entity.Player;

/**
 * Durpped in to existence by Exerosis on 3/20/2016.
 */
public class DisableSpectateEvent extends PlayerRemoveEvent {

    public DisableSpectateEvent(PlayerHolder playerHolder, Player player)
    {
        super(playerHolder, player);
    }

}
