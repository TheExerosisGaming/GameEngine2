package me.exerosis.gameengine.game.games.runner.components;

import me.exerosis.gameengine.common.playerholder.PlayerHolder;
import me.exerosis.gameengine.common.scheduler.SyncRunnable;
import me.exerosis.gameengine.component.ComponentBase;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class RunnerComponent extends ComponentBase implements SyncRunnable {

    //not static in case I want to have it per-map at some point in the future
    private MaterialData[] blocks = new MaterialData[]{
        new MaterialData(Material.STAINED_CLAY, (byte) 5),
        new MaterialData(Material.STAINED_CLAY, (byte) 4),
        new MaterialData(Material.STAINED_CLAY, (byte) 1),
        new MaterialData(Material.STAINED_CLAY, (byte) 14)
    };

    private PlayerHolder playerHolder;
    private ScheduledExecutorService scheduledExecutorService;
    private ScheduledFuture scheduledFuture;

    private List<FallingBlockData> blockDatas = new ArrayList<>();

    public RunnerComponent(PlayerHolder playerHolder, ScheduledExecutorService scheduledExecutorService)
    {
        this.playerHolder = playerHolder;
        this.scheduledExecutorService = scheduledExecutorService;
    }

    @Override
    public void onEnable()
    {
        this.scheduledFuture = getScheduledExecutorService().scheduleAtFixedRate(this, 200, 200, TimeUnit.MILLISECONDS);
    }

    @Override
    public void onDisable()
    {
        this.scheduledFuture.cancel(true);
    }

    @Override
    public void syncRun()
    {

    }





    public MaterialData[] getBlocks()
    {
        return blocks;
    }

    public PlayerHolder getPlayerHolder()
    {
        return playerHolder;
    }

    public ScheduledExecutorService getScheduledExecutorService()
    {
        return scheduledExecutorService;
    }

    public ScheduledFuture getScheduledFuture()
    {
        return scheduledFuture;
    }

    public List<FallingBlockData> getBlockDatas()
    {
        return blockDatas;
    }
}
