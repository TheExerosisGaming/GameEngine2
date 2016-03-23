package me.exerosis.gameengine.common.scheduler;

import me.exerosis.gameengine.Main;
import org.bukkit.Bukkit;

/**
 * Durpped in to existence by Exerosis on 3/22/2016.
 */
public interface SyncRunnable extends Runnable {

    @Override
    default void run()
    {
        Bukkit.getScheduler().runTask(Main.getPlugin(), this::syncRun);
    }

    void syncRun();
}
