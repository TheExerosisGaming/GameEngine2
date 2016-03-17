package me.exerosis.gameengine.arena.component;

import me.exerosis.gameengine.arena.events.ArenaCanJoinEvent;
import me.exerosis.gameengine.arena.events.ArenaJoinEvent;
import me.exerosis.gameengine.arena.events.ArenaQuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class SimplePlayerComponent implements PlayerComponent {

    private ArrayList<Player> players;


    //Players joining & leaving
    @Override
    public boolean canJoin(Player player)
    {
        ArenaCanJoinEvent event = new ArenaCanJoinEvent(this, player);
        Bukkit.getPluginManager().callEvent(event);
        return !event.isCancelled();
    }


    @Override
    public boolean addPlayer(Player player)
    {
        if (!hasPlayer(player))
        {
            Bukkit.getPluginManager().callEvent(new ArenaJoinEvent(this, player));
            players.add(player);
            return true;
        }
        return false;
    }

    @Override
    public boolean removePlayer(Player player)
    {
        if (hasPlayer(player))
        {
            Bukkit.getPluginManager().callEvent(new ArenaQuitEvent(this, player));
            players.remove(player);
            return true;
        }
        return false;
    }

}
