package me.exerosis.gameengine.modules;

import lombok.Getter;
import lombok.Setter;

/**
 * Written by Exerosis!
 *
 * @author BlockServer Team
 * @see SchedulerModule
 */
public class TaskData {
    @Getter @Setter protected long lastTickTime;
    @Getter @Setter protected double delay;
    @Getter @Setter protected int repeatTimes;

    public TaskData(double delay, int repeatTimes) {
        this.delay = delay;
        this.repeatTimes = repeatTimes;
    }

    public long getNextTickTime() {
        return lastTickTime + (long) delay;
    }
}