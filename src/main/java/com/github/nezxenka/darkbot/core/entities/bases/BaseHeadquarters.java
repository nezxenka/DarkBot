package com.github.nezxenka.darkbot.core.entities.bases;

import eu.darkbot.api.game.entities.Station;

public class BaseHeadquarters extends BaseSpot implements Station.Headquarter {
    public BaseHeadquarters(int id, long address) {
        super(id, address);
    }
}
