package com.github.nezxenka.darkbot.config.actions.values;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.config.actions.Value;
import com.github.nezxenka.darkbot.config.actions.ValueData;
import com.github.nezxenka.darkbot.core.entities.Ship;

@ValueData(name = "target", description = "Gets the ship or npc that you're shooting at", example = "target()")
public class TargetValue implements Value<Ship> {

    @Override
    public Ship get(Main main) {
        return main.hero.target;
    }

    @Override
    public String toString() {
        return "target()";
    }
}
