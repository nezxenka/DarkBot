package com.github.nezxenka.darkbot.core.itf;

import com.github.nezxenka.darkbot.core.utils.pathfinder.AreaImpl;

public interface Obstacle extends eu.darkbot.api.game.other.Obstacle {

    AreaImpl getArea();

    boolean isRemoved();

    boolean use();
}
