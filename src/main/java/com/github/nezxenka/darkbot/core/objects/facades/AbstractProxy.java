package com.github.nezxenka.darkbot.core.objects.facades;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.core.itf.Updatable;

abstract class AbstractProxy extends Updatable {
    protected long dataAddress;

    @Override
    public long getAddress() {
        return dataAddress;
    }

    @Override
    public void update() {
        this.dataAddress = Main.API.readAtom(address + 48);
        updateProxy();
    }

    protected abstract void updateProxy();
}
