package com.github.nezxenka.darkbot.core.itf;

public interface Tickable {
    void tick();
    default void tickStopped() {}
}
