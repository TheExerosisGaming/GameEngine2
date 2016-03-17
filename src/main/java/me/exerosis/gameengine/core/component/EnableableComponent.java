package me.exerosis.gameengine.core.component;

/**
 * Created by Exerosis.
 */
public class EnableableComponent implements Enableable, Component {
    private boolean enabled = false;

    public void enable() {
        if (isEnabled())
            return;
        onEnable();
        enabled = true;
    }

    public void disable() {
        if (!isEnabled())
            return;
        onDisable();
        enabled = false;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}