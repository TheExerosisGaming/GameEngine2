package me.exerosis.gameengine.common.item;

import java.util.function.Predicate;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class DefaultPredicate<T> implements Predicate<T> {
    @Override
    public boolean test(T t)
    {
        return true;
    }
}
