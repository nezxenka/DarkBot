package com.github.nezxenka.darkbot.config.actions.conditions;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.config.actions.ValueData;
import org.jetbrains.annotations.NotNull;

@ValueData(name = "one", description = "Returns true if exactly one child condition return true", example = "one(a, b)")
public class OneCondition extends AbstractCondition {

    @Override
    public @NotNull Result get(Main main) {
        return super.getValue(main, 1, 1);
    }

}
