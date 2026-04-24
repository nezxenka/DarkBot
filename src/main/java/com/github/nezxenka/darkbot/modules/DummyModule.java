package com.github.nezxenka.darkbot.modules;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.core.itf.Module;

public class DummyModule implements Module {

    @Override
    public void install(Main main) {}

    @Override
    public boolean canRefresh() {
        return false;
    }

    @Override
    public void tick() {}

    @Override
    public String status() {
        return "Waiting module - Select a module in config";
    }
}
