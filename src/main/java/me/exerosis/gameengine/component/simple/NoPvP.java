package me.exerosis.gameengine.component.simple;

import me.exerosis.gameengine.component.ComponentListener;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.function.Predicate;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class NoPvP extends ComponentListener {

    private Predicate<Player> playerPredicate;


    public NoPvP(Predicate<Player> playerPredicate, Predicate<Player> attackerPredicate)
    {
        this.playerPredicate = playerPredicate;
    }

    public void onDamage(EntityDamageByEntityEvent event)
    {
        if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player))
            return;


        Player damagee = (Player) event.getEntity();

        Player damager = (Player) event.getDamager();


        if (event.getEntity() instanceof Player && playerPredicate.test((Player) event.getEntity()))
            event.setCancelled(true);


    }
}
