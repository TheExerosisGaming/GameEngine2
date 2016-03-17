package me.exerosis.gameengine.modules;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Exerosis.
 */
public class ExecutorModule {
    private ExecutorService executor;

    public ExecutorModule(int threads) {
        executor = Executors.newFixedThreadPool(threads);
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public void setExecutor(ExecutorService executor) {
        this.executor = executor;
    }
}