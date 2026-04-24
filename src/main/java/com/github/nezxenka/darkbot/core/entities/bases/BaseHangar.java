package com.github.nezxenka.darkbot.core.entities.bases;


import eu.darkbot.api.game.entities.Station;

public class BaseHangar extends BaseSpot implements Station.Hangar {
    public BaseHangar(int id, long address) {
        super(id, address);
    }
}
