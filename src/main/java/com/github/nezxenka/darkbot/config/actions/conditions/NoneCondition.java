package com.github.nezxenka.darkbot.config.actions.conditions;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.config.actions.ValueData;
import org.jetbrains.annotations.NotNull;

@ValueData(name = "none", description = "Returns true if no child conditions return true", example = "none(a, b)")
public class NoneCondition extends AbstractCondition {

    public NoneCondition() {}

    @Override
    public @NotNull Result get(Main main) {
        return super.getValue(main, 0, 0);
    }

}
