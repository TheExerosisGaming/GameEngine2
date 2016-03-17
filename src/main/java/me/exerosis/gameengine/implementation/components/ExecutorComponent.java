package me.exerosis.gameengine.implementation.components;

import me.exerosis.gameengine.core.component.EnableableComponent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Exerosis.
 */
public class ExecutorComponent extends EnableableComponent {
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