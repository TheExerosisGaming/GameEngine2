
package me.exerosis.gameengine.implementation.components.scheduler;

import me.exerosis.gameengine.core.component.EnableableComponent;
import me.exerosis.gameengine.implementation.components.ExecutorComponent;

import java.util.HashMap;
import java.util.Map;

/**
 * Written by Exerosis!
 *
 */
public class SchedulerComponent extends EnableableComponent {
    private final Map<Runnable, TaskData> tasks = new HashMap<>();
    private final ExecutorComponent executorComponent;

    public SchedulerComponent(ExecutorComponent executorComponent) {
        this.executorComponent = executorComponent;
    }

    //TODO maybe make this better!
    @Override
    public void onEnable() {
        executorComponent.getExecutor().execute(() -> {
            while (isEnabled()) {
                for (Map.Entry<Runnable, TaskData> entry : tasks.entrySet()) {
                    TaskData taskData = entry.getValue();
                    if (taskData.getNextTickTime() > System.currentTimeMillis())
                        continue;
                    taskData.repeatTimes--;
                    //So by doing this every task will be run at the same time... not in series... is that ok?
                    executorComponent.getExecutor().execute(() -> entry.getKey().run());
                    //
                    if (taskData.repeatTimes <= 0)
                        tasks.remove(entry.getKey());
                    taskData.lastTickTime = System.currentTimeMillis();
                }
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        super.onEnable();
    }

    @Override
    public void onDisable() {
        tasks.clear();
        super.onDisable();
    }

    public void registerTask(Runnable task, double delay) {
        registerTask(task, delay, 1);
    }

    public void registerTask(Runnable task, int repeatTimes) {
        registerTask(task, 1, repeatTimes);
    }

    public void registerTask(Runnable task, double delay, int repeatTimes) {
        registerTask(task, new TaskData(delay, repeatTimes));
    }

    public void registerTask(Runnable task, TaskData taskData) {
        synchronized (tasks) {
            tasks.put(task, taskData);
        }
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

    public void setTaskRepeatTimes(Runnable task, int repeatTimes) {
        getTaskData(task).repeatTimes = repeatTimes;
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