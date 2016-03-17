package me.exerosis.gameengine.arena;

import me.exerosis.gameengine.arena.game.Game;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Collection;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public interface Arena {

    boolean canJoin(Player player);

    boolean addPlayer(Player player);

    boolean removePlayer(Player player);

    Collection<Player> getPlayers();

    boolean hasPlayer(Player player);

    void broadcast(String message);

    Plugin getPlugin();

    Game getGame();

    void endGame();
}
