package com.github.nezxenka.darkbot.core.objects.facades;

import com.github.nezxenka.darkbot.core.itf.Updatable;
import com.github.nezxenka.darkbot.core.utils.ByteUtils;
import eu.darkbot.api.managers.ChrominAPI;

import static com.github.nezxenka.darkbot.Main.API;

public class ChrominProxy extends Updatable implements ChrominAPI {

    public double currAmt, maxAmt;

    @Override
    public void update() {
        if (address == 0) return;

        long data = API.readLong(address + 48) & ByteUtils.ATOM_MASK;

        this.maxAmt = API.readDouble(data + 48);
        this.currAmt = API.readDouble(data + 40);
    }

    @Override
    public double getCurrentAmount() {
        return currAmt;
    }

    @Override
    public double getMaxAmount() {
        return maxAmt;
    }
}
