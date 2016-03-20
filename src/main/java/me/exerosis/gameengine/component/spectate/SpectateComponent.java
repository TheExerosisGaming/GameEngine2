package me.exerosis.gameengine.component.spectate;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Collection;

/**
 * Durpped in to existence by Exerosis on 3/20/2016.
 */
public interface SpectateComponent {

    boolean enableSpectate(Player player);

    boolean enableSpectateWithLoc(Player player, Location location);

    boolean disableSpectate(Player player);

    boolean disableSpectateWithLoc(Player player, Location location);

    boolean isSpectating(Player player);

    boolean isNotSpectating(Player player);

    Collection<Player> getSpectators();

    Collection<Player> getNonPlayers();
}
