package com.github.nezxenka.darkbot.config.actions.conditions;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.config.actions.ValueData;
import org.jetbrains.annotations.NotNull;

@ValueData(name = "any", description = "Returns true if any child conditions return true", example = "any(a, b)")
public class AnyCondition extends AbstractCondition {

    @Override
    public @NotNull Result get(Main main) {
        return super.getValue(main, 1, children.size());
    }

}
