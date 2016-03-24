package me.exerosis.gameengine;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/*
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class Main extends JavaPlugin {


    private static Main plugin;

    public static void main(String[] args)
    {
        String[] s = new String[]{"moo"};

        s instanceof Iterable

        System.out.println();
    }

    public static void test()
    {
        System.out.println("Oooo fancy!");
    }

    //Stuuuuuuffff
    public static Main getPlugin()
    {
        return plugin;
    }

    public static void registerEvents(Listener listener)
    {
        Bukkit.getPluginManager().registerEvents(listener, getPlugin());
    }

    public static void unregisterEvents(Listener listener)
    {
        HandlerList.unregisterAll(listener);
    }

    @Override
    public void onEnable()
    {
        plugin = this;
    }


}