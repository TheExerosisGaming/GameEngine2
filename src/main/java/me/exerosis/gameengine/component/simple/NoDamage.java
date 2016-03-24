package me.exerosis.gameengine.component.simple;

import me.exerosis.gameengine.component.ComponentListener;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.function.Predicate;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class NoDamage extends ComponentListener {

    private Predicate<Player> playerPredicate;

    public NoDamage(Predicate<Player> playerPredicate)
    {
        this.playerPredicate = playerPredicate;
    }

    public void onDamage(EntityDamageEvent event)
    {
        if (event.getEntity() instanceof Player && playerPredicate.test((Player) event.getEntity()))
            event.setCancelled(true);
    }
}
