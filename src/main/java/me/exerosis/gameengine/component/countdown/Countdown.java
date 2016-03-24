package me.exerosis.gameengine.component.countdown;

import me.exerosis.gameengine.common.playerholder.PlayerHolder;
import me.exerosis.gameengine.common.scheduler.SyncRunnable;
import me.exerosis.gameengine.component.ComponentBase;

import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Durpped in to existence by Exerosis on 3/23/2016.
 */
public class Countdown extends ComponentBase implements Runnable {

    private final int startTime;

    private ScheduledExecutorService scheduler;
    private ScheduledFuture<?> futureTask;
    private int counter;

    private Runnable returnCommand;

    public Countdown(ScheduledExecutorService scheduler, Runnable returnCommand, int startTime)
    {
        this.startTime = startTime;
        this.counter = startTime;
        this.returnCommand = returnCommand;
        this.scheduler = scheduler;
    }

    public void restart()
    {
        stop();
        counter = startTime;
        start();
    }

    public boolean start()
    {
        if (futureTask != null || counter <= 0)
            return false;
        futureTask = scheduler.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS);
        return true;
    }

    public boolean stop()
    {
        if (futureTask == null)
            return false;
        futureTask.cancel(true);
        futureTask = null;
        return true;
    }

    @Override
    public void run()
    {
        if (counter > 0)
            System.out.println("Game starting in: " + counter);
        else
        {
            returnCommand.run();
            stop();
        }
        counter--;

    }

    public int getCounter()
    {
        return counter;
    }

    public int getStartTime()
    {
        return startTime;
    }

    @Override
    public void onEnable()
    {
        start();
    }

    @Override
    public void onDisable()
    {
        stop();
    }
}
