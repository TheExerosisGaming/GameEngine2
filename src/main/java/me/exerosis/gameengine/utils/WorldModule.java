package me.exerosis.gameengine.utils;

import me.exerosis.gameengine.modules.SchedulerModule;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;

import java.io.File;

/**
 * Created by Exerosis.
 */
public class WorldModule {
    private SchedulerModule schedulerModule;

    public WorldModule(SchedulerModule schedulerModule) {
        this.schedulerModule = schedulerModule;
    }

    public void loadWorld(File file) {
        System.out.println("[WorldModule]Trying to load world.");
        if (!file.getPath().startsWith(Bukkit.getWorldContainer().getParent()))
            System.err.println("[WorldModule]Failed to load world! '" + file.getPath() + "' is not in the server folder.");
        if (!file.exists())
            System.err.println("[WorldModule]Failed to load world! No such file or directory: '" + file.getPath() + "'.");
        if (!file.isDirectory())
            System.err.println("[WorldModule]Failed to load world! Could not find world at '" + file.getPath() + "'.");

        File worldData = new File(file.getPath() + "/level.dat");

        if (!worldData.exists())
            System.err.println("[WorldModule]Failed to load world! Could not find expected 'level.dat' in directory '"file.getPath() + "'.");

        WorldCreator worldCreator = new WorldCreator("");
        worldCreator.type(WorldType.FLAT);
        Bukkit.createWorld(worldCreator);

        System.out.println("[WorldModule]World can be loaded. Loading world.");
    }

    private void tryUnload(String worldName, String kickMessage, Runnable runWhenUnloaded) {
        System.out.println("[WorldModule]Trying to unload world!");
        World world = Bukkit.getWorld(worldName);

        if (world == null) {
            runWhenUnloaded.run();
            return;
        }

        //Remove players
        for (Player player : world.getPlayers())
            player.kickPlayer(kickMessage);

        //Wait 1 second before unloading the world
        schedulerModule.registerTask(() -> {
            if (!Bukkit.unloadWorld(world, false))
                throw new RuntimeException("[WorldModule]Unable to unload world, please fix the problem!");
            runWhenUnloaded.run();
        }, 20D);
    }
}