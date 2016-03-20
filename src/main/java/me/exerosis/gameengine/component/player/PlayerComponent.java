package me.exerosis.gameengine.component.player;

import me.exerosis.gameengine.utils.player.PlayerHolder;
import org.bukkit.entity.Player;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public interface PlayerComponent extends PlayerHolder {

    boolean canJoin(Player player);

    boolean addPlayer(Player player);

    boolean removePlayer(Player player);

}
