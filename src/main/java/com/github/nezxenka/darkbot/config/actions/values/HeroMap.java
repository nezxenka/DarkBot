package com.github.nezxenka.darkbot.config.actions.values;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.config.actions.Value;
import com.github.nezxenka.darkbot.config.actions.ValueData;
import com.github.nezxenka.darkbot.core.objects.Map;
import org.jetbrains.annotations.Nullable;

@ValueData(name = "hero-map", description = "Gets the current map the hero is in", example = "hero-map()")
public class HeroMap implements Value<Map> {

    @Override
    public @Nullable Map get(Main main) {
        return main.hero.map;
    }

    @Override
    public String toString() {
        return "hero-map()";
    }
}
