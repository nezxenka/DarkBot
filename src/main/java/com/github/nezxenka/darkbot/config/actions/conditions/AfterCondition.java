package com.github.nezxenka.darkbot.config.actions.conditions;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.config.actions.Condition;
import com.github.nezxenka.darkbot.config.actions.Parser;
import com.github.nezxenka.darkbot.config.actions.SyntaxException;
import com.github.nezxenka.darkbot.config.actions.Value;
import com.github.nezxenka.darkbot.config.actions.ValueData;
import com.github.nezxenka.darkbot.config.actions.parser.ParseResult;
import com.github.nezxenka.darkbot.config.actions.parser.ParseUtil;
import com.github.nezxenka.darkbot.config.actions.parser.ValueParser;
import com.github.nezxenka.darkbot.config.actions.values.NumberConstant;
import com.github.nezxenka.darkbot.core.entities.Ship;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

@ValueData(name = "after", description = "Returns true if inner condition is true after the specified time in seconds", example = "after(7.5, condition)")
public class AfterCondition implements Condition, Parser {

    public long time;
    public Value<Result> condition;

    private transient Long allowTime = null;

    @Override
    public @NotNull Condition.Result get(Main main) {
        Result res = Value.get(condition, main);
        if (res == null) return Result.ABSTAIN;

        allowTime = res.allows() ? allowTime != null ? allowTime : System.currentTimeMillis() + time : null;

        return Result.fromBoolean(allowTime != null && System.currentTimeMillis() > allowTime);
    }


    @Override
    public String toString() {
        return "after(" + NumberConstant.format((double) time / 1000) + ", " + condition + ")";
    }

    @Override
    public String parse(String str) throws SyntaxException {
        String[] params = str.split(" *, *", 2);

        time = (long) (NumberConstant.parseNumber(params[0], str, getClass()).doubleValue() * 1000);

        str = ParseUtil.separate(params, getClass(), ",");

        ParseResult<Result> pr = ValueParser.parse(str, Result.class);
        condition = pr.value;

        return ParseUtil.separate(pr.leftover.trim(), getClass(), ")");
    }
}
