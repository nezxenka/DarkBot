package com.github.nezxenka.darkbot.core.objects.facades;

import com.github.nezxenka.darkbot.core.itf.Updatable;
import com.github.nezxenka.darkbot.core.utils.ByteUtils;
import eu.darkbot.api.managers.EscortAPI;

import static com.github.nezxenka.darkbot.Main.API;

public class EscortProxy extends Updatable implements EscortAPI {
    public double time;
    public double keys;

    public void update() {
        long data = API.readLong(address + 48) & ByteUtils.ATOM_MASK;

        this.keys = API.readDouble(API.readLong(data + 88) + 56);
        this.time = API.readDouble(API.readLong(data + 72) + 56);
    }

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public double getKeys() {
        return keys;
    }
}
