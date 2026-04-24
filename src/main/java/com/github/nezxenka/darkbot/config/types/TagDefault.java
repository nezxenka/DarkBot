package com.github.nezxenka.darkbot.config.types;

import com.github.nezxenka.darkbot.utils.I18n;

import java.util.Locale;

public enum TagDefault {
    UNSET,
    ALL,
    NONE;

    @Override
    public String toString() {
        return I18n.get("players.tag_default." + name().toLowerCase(Locale.ROOT));
    }
}
