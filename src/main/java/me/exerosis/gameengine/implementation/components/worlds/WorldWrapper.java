package me.exerosis.gameengine.implementation.components.worlds;

import me.exerosis.gameengine.utils.StreamUtil;
import net.minecraft.server.v1_9_R1.MinecraftServer;
import net.minecraft.server.v1_9_R1.World;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.zip.ZipOutputStream;

/**
 * Created by Exerosis.
 */
public class WorldWrapper {
    private File worldFile;
    private File backupFile;

    public WorldWrapper(File worldFile, String kickMessage) {
        this.worldFile = worldFile;
        backupFile = new File(worldFile.getPath() + "/backup.tmp");
    }


    public void load() {
        System.out.println("[WorldComponent]Trying to load world.");

        if (!worldFile.getPath().startsWith(Bukkit.getWorldContainer().getParent()))
            System.err.println("[WorldComponent]Failed to load world! '" + worldFile.getPath() + "' is not in the server folder.");
        if (!worldFile.exists())
            System.err.println("[WorldComponent]Failed to load world! No such file or directory: '" + worldFile.getPath() + "'.");
        if (!worldFile.isDirectory())
            System.err.println("[WorldComponent]Failed to load world! Could not find world at '" + worldFile.getPath() + "'.");

        File worldData = new File(worldFile.getPath() + "/level.dat");

        if (!worldData.exists())
            System.err.println("[WorldComponent]Failed to load world! Could not find expected 'level.dat' in directory '" + worldFile.getPath() + "'.");

        WorldCreator worldCreator = new WorldCreator("");
        worldCreator.type(WorldType.FLAT);
        Bukkit.createWorld(worldCreator);

        System.out.println("[WorldComponent]WorldWrapper can be loaded. Loading world.");
    }

    public void backup() {
        try {
            backupFile = File.createTempFile("backup", ".tmp", worldFile);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void revert() {
        if(!backupFile.isFile())
            return;

        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(backupFile);
            outputStream = new BufferedOutputStream(outputStream);
            outputStream = new ZipOutputStream(outputStream);
            MinecraftServer
            outputStream
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            StreamUtil.closeQuietly(outputStream);
        }

    }

    public void unload() {
        System.out.println("[WorldComponent]Trying to unload world!");
        WorldWrapper world = Bukkit.getWorld(worldName);

        if (world == null)
            return;

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
