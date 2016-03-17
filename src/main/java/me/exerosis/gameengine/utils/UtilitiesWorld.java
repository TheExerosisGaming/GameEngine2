package me.exerosis.gameengine.utils;

import java.io.File;

/**
 * Created by Exerosis.
 */
public class UtilitiesWorld {
    public static void loadWorld(File file) {
        System.out.println("[UtilitiesWorld]Trying to load world.");

        if(!file.exists())
            System.err.println("[UtilitiesWorld]Failed to load world! No such file or directory: '" + file.getPath() + "'.");
        if(!file.isDirectory())
            System.err.println("[UtilitiesWorld]Failed to load world! Could not find world at '" + file.getPath() + "'.");

        File worldData = new File(file.getPath() + "/level.dat");

        if(!worldData.exists())
            System.err.println("[UtilitiesWorld]Failed to load world! Could not find expected 'level.dat' in directory '" file.getPath() + "'.");

        WorldCreator worldCreator = new WorldCreator(getName());
        worldCreator.type(WorldType.FLAT);
        Bukkit.createWorld(worldCreator);
    }

    private void tryUnload(Runnable runWhenUnloaded) {
        print("Trying to unload world!");
        _gameWorld = Bukkit.getWorld(getName());

        if (_gameWorld == null) {
            runWhenUnloaded.run();
            return;
        }

        //Remove players
        for (Player player : _gameWorld.getPlayers())
            player.teleport(getLobbyWorld().getSpawnLocation().add(0, 4, 0));

        //Wait 1 second before unloading the world
        Bukkit.getScheduler().runTaskLater(getPlugin(), () -> {
            if (!Bukkit.unloadWorld(_gameWorld, false)) {
                print("Unable to unload world, please fix the problem!");
                shutdown();
                return;
            }
            //Wait 4 seconds before trying to remove the world folder
            Bukkit.getScheduler().runTaskLater(getPlugin(), new Runnable() {
                final File toDelete = new File(getName());

                @Override
                public void run() {
                    print("World unloaded.");
                    try {
                        print("Removing world folder.");
                        FileUtils.deleteDirectory(toDelete);
                    } catch (IOException e) {
                        e.printStackTrace();
                        print("Failed to remove the world directory, shutting down server!", true);
                        shutdown();
                        return;
                    }

                    print("Folder removed.");
                    if (runWhenUnloaded != null)
                        runWhenUnloaded.run();
                }
            }, 60);
        }, 20);
    }

}
