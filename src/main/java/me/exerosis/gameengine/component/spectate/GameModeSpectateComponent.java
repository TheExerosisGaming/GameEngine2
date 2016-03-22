package me.exerosis.gameengine.component.spectate;

import me.exerosis.gameengine.component.player.PlayerComponent;
import me.exerosis.gameengine.component.spectate.events.DisableSpectateEvent;
import me.exerosis.gameengine.component.spectate.events.EnableSpectateEvent;
import me.exerosis.gameengine.utils.player.PlayerHolder;
import me.exerosis.gameengine.utils.player.events.PlayerAddEvent;
import me.exerosis.gameengine.utils.player.events.PlayerRemoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Durpped in to existence by Exerosis on 3/20/2016.
 */
public class GameModeSpectateComponent implements SpectateComponent {

    private PlayerComponent playerComponent;

    private List<Player> spectaters = new ArrayList<Player>();

    private SpectateHolder spectateHolder;

    private NonSpectateHolder nonSpectateHolder;

    public GameModeSpectateComponent(PlayerComponent playerComponent)
    {
        this.playerComponent = playerComponent;
        this.spectateHolder = new SpectateHolder();
        this.nonSpectateHolder = new NonSpectateHolder();
    }


    @Override
    public boolean enableSpectate(Player player)
    {
        if (spectaters.contains(player))
            return false;

        EnableSpectateEvent addEvent = new EnableSpectateEvent(getSpectateHolder(), player);
        PlayerRemoveEvent removeEvent = new PlayerRemoveEvent(getNonSpectateHolder(), player);

        Bukkit.getPluginManager().callEvent(removeEvent);
        Bukkit.getPluginManager().callEvent(addEvent);

        player.getInventory().clear();
        for (PotionEffect effect : player.getActivePotionEffects())
            player.removePotionEffect(effect.getType());
        player.setFallDistance(0);
        player.resetMaxHealth();
        player.setGameMode(GameMode.SPECTATOR);

        this.spectaters.add(player);

        return true;
    }

    @Override
    public boolean disableSpectate(Player player)
    {
        if (!spectaters.contains(player))
            return false;

        DisableSpectateEvent removeEvent = new DisableSpectateEvent(getSpectateHolder(), player);
        PlayerAddEvent addEvent = new PlayerAddEvent(getNonSpectateHolder(), player);

        Bukkit.getPluginManager().callEvent(removeEvent);
        Bukkit.getPluginManager().callEvent(addEvent);

        this.spectaters.remove(player);

        return true;
    }


    @Override
    public PlayerHolder getSpectateHolder()
    {
        return this.spectateHolder;
    }

    @Override
    public PlayerHolder getNonSpectateHolder()
    {
        return this.nonSpectateHolder;
    }


    class SpectateHolder implements PlayerHolder {
        @Override
        public Collection<Player> getPlayers()
        {
            return spectaters;
        }
    }

    class NonSpectateHolder implements PlayerHolder {
        @Override
        public Collection<Player> getPlayers()
        {
            List<Player> players = new ArrayList<Player>(playerComponent.getPlayers());
            players.removeAll(spectaters);
            return players;
        }

        @Override
        public boolean filter(Player player)
        {
            return playerComponent.filter(player) && !spectaters.contains(player);
        }
    }

}
