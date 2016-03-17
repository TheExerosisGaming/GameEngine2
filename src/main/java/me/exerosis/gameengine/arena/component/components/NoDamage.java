package me.exerosis.gameengine.arena.component.components;

import me.exerosis.gameengine.arena.Arena;
import me.exerosis.gameengine.arena.component.ComponentListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class NoDamage extends ComponentListener {

    public NoDamage(Arena arena)
    {
        super(arena);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event)
    {
        if (getArena().hasPlayer(event.getEntity()))
            return;
        event.setCancelled(true);
    }
}
