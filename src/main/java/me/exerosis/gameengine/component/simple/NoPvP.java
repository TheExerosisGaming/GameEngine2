package me.exerosis.gameengine.component.simple;

import me.exerosis.gameengine.common.item.DefaultPredicate;
import me.exerosis.gameengine.component.ComponentListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.function.Predicate;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class NoPvP extends ComponentListener {

    private Predicate<Player> playerPredicate;

    private Predicate<Player> attackerPredicate;

    public NoPvP(Predicate<Player> playerPredicate)
    {
        this(playerPredicate, new DefaultPredicate<>());
    }

    public NoPvP(Predicate<Player> playerPredicate, Predicate<Player> attackerPredicate)
    {
        this.attackerPredicate = attackerPredicate;
        this.playerPredicate = playerPredicate;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event)
    {
        if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player))
            return;

        Player player = (Player) event.getEntity();

        Player attacker = (Player) event.getDamager();

        if (playerPredicate.test(player) && attackerPredicate.test(attacker))
            event.setCancelled(true);
    }
}
