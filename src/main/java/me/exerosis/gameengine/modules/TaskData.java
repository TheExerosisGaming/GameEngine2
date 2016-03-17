package me.exerosis.gameengine.modules;

/**
 * Written by Exerosis!
 *
 * @author BlockServer Team
 * @see SchedulerModule
 */
public class TaskData {
    protected long lastTickTime;
    protected double delay;
    protected int repeatTimes;

    public TaskData(double delay, int repeatTimes) {
        this.delay = delay;
        this.repeatTimes = repeatTimes;
    }

    public long getNextTickTime() {
        return lastTickTime + (long) delay;
    }

    public long getLastTickTime() {
        return lastTickTime;
    }

    public double getDelay() {
        return delay;
    }

    public int getRepeatTimes() {
        return repeatTimes;
    }
}