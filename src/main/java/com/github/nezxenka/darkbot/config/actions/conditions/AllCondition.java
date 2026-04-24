package com.github.nezxenka.darkbot.config.actions.conditions;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.config.actions.ValueData;
import org.jetbrains.annotations.NotNull;

@ValueData(name = "all", description = "Returns true if all child conditions return true", example = "all(a, b)")
public class AllCondition extends AbstractCondition {

    @Override
    public @NotNull Result get(Main main) {
        return super.getValue(main, children.size(), children.size());
    }

}
