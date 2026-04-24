package com.github.nezxenka.darkbot.core.entities.bases;


import eu.darkbot.api.game.entities.Station;

public class BaseStation extends BaseSpot implements Station.HomeBase {
    public BaseStation(int id, long address) {
        super(id, address);
    }
}
