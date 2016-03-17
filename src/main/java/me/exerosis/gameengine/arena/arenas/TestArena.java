package me.exerosis.gameengine.arena.arenas;

import me.exerosis.gameengine.arena.ArenaBase;
import me.exerosis.gameengine.arena.game.Game;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class TestArena extends ArenaBase {

    public TestArena(Plugin plugin, Game game)
    {
        super(plugin);
        startGame(game);
    }

    @Override
    public boolean removePlayer(Player player)
    {
        if (super.removePlayer(player))
        {
            player.kickPlayer("Lol bye!");
            return true;
        }

        return false;
    }
}
