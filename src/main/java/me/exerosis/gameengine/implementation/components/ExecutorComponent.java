package me.exerosis.gameengine.implementation.components;

import me.exerosis.gameengine.component.ComponentBase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Exerosis.
 */
public class ExecutorComponent extends ComponentBase {
    private ExecutorService executor;

    public ExecutorComponent(int threads) {
        executor = Executors.newFixedThreadPool(threads);
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public void setExecutor(ExecutorService executor) {
        this.executor = executor;
    }
}