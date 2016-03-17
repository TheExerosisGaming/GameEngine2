package me.exerosis.gameengine.arena.component;

import me.exerosis.gameengine.utils.PlayerHolder;
import org.bukkit.entity.Player;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public interface PlayerComponent extends PlayerHolder {

    boolean canJoin(Player player);

    boolean addPlayer(Player player);

    boolean removePlayer(Player player);

}
