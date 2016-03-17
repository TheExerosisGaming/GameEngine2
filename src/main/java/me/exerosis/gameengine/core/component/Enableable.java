package me.exerosis.gameengine.core.component;

public interface Enableable {
    void onEnable();

    boolean isEnabled();

    void onDisable();
}