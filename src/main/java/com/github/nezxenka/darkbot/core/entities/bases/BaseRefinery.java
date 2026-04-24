package com.github.nezxenka.darkbot.core.entities.bases;


import eu.darkbot.api.game.entities.Station;

public class BaseRefinery extends BaseSpot implements Station.Refinery {
    public BaseRefinery(int id, long address) {
        super(id, address);
    }
}
