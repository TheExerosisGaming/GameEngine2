package me.exerosis.gameengine.component.spectate.events;

import me.exerosis.gameengine.utils.player.PlayerHolder;
import me.exerosis.gameengine.utils.player.events.PlayerAddEvent;
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
