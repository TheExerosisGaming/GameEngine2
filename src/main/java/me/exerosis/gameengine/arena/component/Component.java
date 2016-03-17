package me.exerosis.gameengine.arena.component;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public interface Component {

    default boolean enable()
    {
        if (!isEnabled())
        {
            this.enable();
            return true;
        }
        return false;
    }

    default boolean disable()
    {
        if (isEnabled())
        {
            this.disable();
            return true;
        }
        return false;
    }

    boolean isEnabled();

    void onEnable();

    void onDisable();
}
