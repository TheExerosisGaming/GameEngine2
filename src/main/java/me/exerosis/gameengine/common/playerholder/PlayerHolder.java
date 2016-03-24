package me.exerosis.gameengine.common.playerholder;

import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public interface PlayerHolder extends Predicate<Player> {

    Collection<Player> getPlayers();

    @Override
    default boolean test(Player player)
    {
        return getPlayers().contains(player);
    }


}