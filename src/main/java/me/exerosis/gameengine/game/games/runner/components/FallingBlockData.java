package me.exerosis.gameengine.game.games.runner.components;

import org.bukkit.block.Block;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class FallingBlockData {

    private Block block;
    private int cycle = 0;

    public FallingBlockData(Block block)
    {
        this.block = block;
    }

    public Block getBlock()
    {
        return block;
    }

    public int getCycle()
    {
        return cycle;
    }

    public void setCycle(int cycle)
    {
        this.cycle = cycle;
    }
}
