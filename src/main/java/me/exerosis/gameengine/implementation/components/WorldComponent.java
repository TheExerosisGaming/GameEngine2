package me.exerosis.gameengine.implementation.components;

import me.exerosis.gameengine.component.ComponentBase;
import me.exerosis.gameengine.implementation.components.scheduler.SchedulerComponent;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;

import java.io.File;

/**
 * Created by Exerosis.
 */
public class WorldComponent extends ComponentBase {
    private SchedulerComponent schedulerComponent;

    public WorldComponent(SchedulerComponent schedulerComponent) {
        this.schedulerComponent = schedulerComponent;
    }

    public void loadWorld(File file) {
        System.out.println("[WorldComponent]Trying to load world.");

        if (!file.getPath().startsWith(Bukkit.getWorldContainer().getParent()))
            System.err.println("[WorldComponent]Failed to load world! '" + file.getPath() + "' is not in the server folder.");
        if (!file.exists())
            System.err.println("[WorldComponent]Failed to load world! No such file or directory: '" + file.getPath() + "'.");
        if (!file.isDirectory())
            System.err.println("[WorldComponent]Failed to load world! Could not find world at '" + file.getPath() + "'.");

        File worldData = new File(file.getPath() + "/level.dat");

        if (!worldData.exists())
            System.err.println("[WorldComponent]Failed to load world! Could not find expected 'level.dat' in directory '" + file.getPath() + "'.");

        WorldCreator worldCreator = new WorldCreator("");
        worldCreator.type(WorldType.FLAT);
        Bukkit.createWorld(worldCreator);

        System.out.println("[WorldComponent]World can be loaded. Loading world.");
    }

    private void tryUnload(String worldName, String kickMessage, Runnable runWhenUnloaded) {
        System.out.println("[WorldComponent]Trying to unload world!");
        World world = Bukkit.getWorld(worldName);

        if (world == null) {
            runWhenUnloaded.run();
            return;
        }

        //Remove players
        for (Player player : world.getPlayers())
            player.kickPlayer(kickMessage);

        //Wait 1 second before unloading the world
        schedulerComponent.registerTask(() -> {
            if (!Bukkit.unloadWorld(world, false))
                throw new RuntimeException("[WorldComponent]Unable to unload world, please fix the problem!");
            runWhenUnloaded.run();
        }, 20D);
    }
}