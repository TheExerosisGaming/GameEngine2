package me.exerosis.gameengine.utils;

import org.bukkit.entity.Player;

import java.util.Collection;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public interface PlayerHolder extends Filter<Player> {

    Collection<Player> getPlayers();

    @Override
    default boolean filter(Player player)
    {
        return getPlayers().contains(player);
    }
}