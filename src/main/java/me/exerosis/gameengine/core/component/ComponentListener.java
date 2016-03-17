package me.exerosis.gameengine.core.component;

import me.exerosis.gameengine.Main;
import org.bukkit.event.Listener;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public abstract class ComponentListener extends ComponentBase implements Listener {

    @Override
    public void onEnable()
    {
        Main.registerEvents(this);
    }

    @Override
    public void onDisable()
    {
        Main.unregisterEvents(this);
    }
}
