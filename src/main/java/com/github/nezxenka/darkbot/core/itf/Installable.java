package com.github.nezxenka.darkbot.core.itf;

import com.github.nezxenka.darkbot.Main;
import eu.darkbot.api.PluginAPI;

public interface Installable extends eu.darkbot.api.extensions.Installable {
    void install(Main main);
    default void uninstall() {}

    @Override
    default void install(PluginAPI pluginAPI) {
        install(pluginAPI.requireInstance(Main.class));
    }
}
