package com.github.nezxenka.darkbot.core.entities.bases;


import eu.darkbot.api.game.entities.Station;

public class QuestGiver extends BaseSpot implements Station.QuestGiver {
    public QuestGiver(int id, long address) {
        super(id, address);
    }
}
