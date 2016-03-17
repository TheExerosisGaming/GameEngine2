package me.exerosis.gameengine.arena;

import me.exerosis.gameengine.arena.events.*;
import me.exerosis.gameengine.arena.game.Game;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public abstract class BassArena implements Arena, Listener {

    private List<Player> players;

    private Plugin plugin;

    private Game game;

    public BassArena(Plugin plugin)
    {
        this.plugin = plugin;
        this.players = new ArrayList<Player>();
        getPlugin().getServer().getPluginManager().registerEvents(this, getPlugin());
    }


    //Game start & end
    @Override
    public void endGame()
    {
        //TODO better
        System.out.println("Game Ended");
        Bukkit.getServer().getPluginManager().callEvent(new ArenaEndEvent(this));
    }

    protected boolean startGame(Game game)
    {
        Validate.notNull(game, "Game cannot be null!");

        if (this.game != null)
            return false;

        this.game = game;
        game.start(this);
        Bukkit.getPluginManager().callEvent(new ArenaStartEvent(this));
        return true;
    }


    //Broadcast
    @Override
    public void broadcast(String message)
    {
        for (Player p : getPlayers())
        {
            p.sendMessage(message);
        }
    }

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

    //Listeners
    public void onQuit(PlayerQuitEvent event)
    {
        this.removePlayer(event.getPlayer());
    }


    //Getters & Setters etc.
    @Override
    public Plugin getPlugin()
    {
        return plugin;
    }

    @Override
    public Collection<Player> getPlayers()
    {
        return this.players;
    }

    @Override
    public boolean hasPlayer(Player player)
    {
        return getPlayers().contains(player);
    }

    @Override
    public Game getGame()
    {
        return this.game;
    }
}
