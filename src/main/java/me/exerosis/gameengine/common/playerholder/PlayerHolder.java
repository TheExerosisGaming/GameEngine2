package me.exerosis.gameengine.common.playerholder;

import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public interface PlayerHolder extends Predicate<Player>, Iterable<Player> {

    Collection<Player> getPlayers();

    @Override
    default Iterator<Player> iterator()
    {
        return getPlayers().iterator();
    }

    @Override
    default boolean test(Player player)
    {
        return getPlayers().contains(player);
    }

    default void broadcast(String message)
    {
        for (Player player : getPlayers())
            player.sendMessage(message);
    }
}