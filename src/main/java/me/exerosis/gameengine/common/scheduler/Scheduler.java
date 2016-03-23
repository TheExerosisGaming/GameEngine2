package me.exerosis.gameengine.common.scheduler;

import me.exerosis.gameengine.implementation.components.scheduler.TaskData;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Durpped in to existence by Exerosis on 3/22/2016.
 */
public class Scheduler  {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

    public Runnable registerTask(Runnable task, double delay) {

        return ;
    }

    public Runnable registerTask(Runnable task) {
        scheduler.scheduleWithFixedDelay();
        scheduler.scheduleAtFixedRate();
    }

    public TaskData getTaskData(Runnable task) {
        synchronized (tasks) {
            return tasks.get(task);
        }
    }

    public void setTaskData(Runnable task, TaskData taskData) {
        synchronized (tasks) {
            tasks.put(task, taskData);
        }
    }

    public void setTaskDelay(Runnable task, double delay) {
        getTaskData(task).delay = delay;
    }

    public double getTaskDelay(Runnable task) {
        return getTaskData(task).getDelay();
    }

    public int getTaskRepeatTimes(Runnable task) {
        return getTaskData(task).getRepeatTimes();
    }

    public void cancelTask(Runnable task) {
        synchronized (tasks) {
            tasks.remove(task);
        }
    }
}