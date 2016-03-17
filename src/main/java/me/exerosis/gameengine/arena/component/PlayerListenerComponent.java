package me.exerosis.gameengine.arena.component;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public abstract class PlayerListenerComponent extends ListenerComponent {

    public PlayerListenerComponent(Plugin plugin)
    {
        super(plugin);
        Player p;
        p.setDisplayName();
    }
}