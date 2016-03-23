package me.exerosis.gameengine.component.spectate;

import me.exerosis.gameengine.common.playerholder.PlayerHolder;
import org.bukkit.entity.Player;

import java.util.Collection;

/**
 * Durpped in to existence by Exerosis on 3/20/2016.
 */
public interface SpectateComponent {

    boolean enableSpectate(Player player);

    boolean disableSpectate(Player player);

    default boolean isSpectating(Player player)
    {
        return getSpectateHolder().filter(player);
    }

    default boolean isNotSpectating(Player player)
    {
        return getNonSpectateHolder().filter(player);
    }

    default Collection<Player> getSpectators()
    {
        return getSpectateHolder().getPlayers();
    }

    default Collection<Player> getNonSpectators()
    {
        return getNonSpectateHolder().getPlayers();
    }

    PlayerHolder getSpectateHolder();

    PlayerHolder getNonSpectateHolder();
}