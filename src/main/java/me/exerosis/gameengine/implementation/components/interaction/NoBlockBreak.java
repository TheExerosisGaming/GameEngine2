package me.exerosis.gameengine.implementation.components.interaction;

import me.exerosis.gameengine.component.ComponentPlayerListener;
import me.exerosis.gameengine.common.utils.BlockUtilities;
import me.exerosis.gameengine.common.utils.ItemPredicate;
import me.exerosis.gameengine.common.playerholder.PlayerHolder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class NoBlockBreak extends ComponentPlayerListener {

    private Predicate<ItemStack> predicate;

    public NoBlockBreak(PlayerHolder playerHolder)
    {
        this(playerHolder, null);
    }

    public NoBlockBreak(PlayerHolder playerHolder, Predicate<ItemStack> Predicate)
    {
        super(playerHolder);
        if (Predicate == null)
            Predicate = new ItemPredicate(true);
        this.predicate = Predicate;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event)
    {
        if (hasPlayer(event.getPlayer()) && predicate.test(BlockUtilities.toItemStack(event.getBlock())))
            event.setCancelled(true);
    }
}
