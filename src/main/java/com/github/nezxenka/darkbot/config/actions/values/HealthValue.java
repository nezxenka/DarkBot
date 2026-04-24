package com.github.nezxenka.darkbot.config.actions.values;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.config.actions.Value;
import com.github.nezxenka.darkbot.config.actions.ValueData;
import com.github.nezxenka.darkbot.core.entities.Ship;
import com.github.nezxenka.darkbot.core.objects.Health;

@ValueData(name = "health", description = "Gets the health of a ship", example = "health(a)")
public class HealthValue implements Value<Health> {

    public Value<Ship> ship;

    @Override
    public Health get(Main main) {
        Ship sh = Value.get(ship, main);
        return sh == null ? null : sh.health;
    }

    @Override
    public String toString() {
        return "health(" + ship + ")";
    }
}
