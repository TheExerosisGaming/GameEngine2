package me.exerosis.gameengine;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/*
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class Main extends JavaPlugin {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
    private static Main plugin;

    public static void main(String[] args)
    {
        Runnable beeper = () -> {
            System.out.println(Thread.currentThread().getId());
        };

        final ScheduledFuture<?> beepHandle = scheduler.scheduleAtFixedRate(beeper, 10, 10, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            beepHandle.cancel(true);
        }, 60 * 6, TimeUnit.SECONDS);

        System.out.println();
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