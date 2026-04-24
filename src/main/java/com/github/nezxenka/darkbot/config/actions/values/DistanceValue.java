package com.github.nezxenka.darkbot.config.actions.values;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.config.actions.Value;
import com.github.nezxenka.darkbot.config.actions.ValueData;
import com.github.nezxenka.darkbot.core.utils.Location;
import org.jetbrains.annotations.Nullable;

@ValueData(name = "distance", description = "Returns the distance between two locations", example = "distance(a, b)")
public class DistanceValue implements Value<Number> {

    public Value<Location> a, b;

    @Override
    public @Nullable Number get(Main main) {
        Location locA = Value.get(a, main), locB = Value.get(b, main);
        return locA == null || locB == null ? null : locA.distance(locB);
    }

    @Override
    public String toString() {
        return "distance(" + a + ", " + b + ")";
    }
}
