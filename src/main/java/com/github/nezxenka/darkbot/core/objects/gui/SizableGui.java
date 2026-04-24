package com.github.nezxenka.darkbot.core.objects.gui;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.core.objects.Gui;

public class SizableGui extends Gui {
    public void update() {
        if (address == 0) return;
        super.update();
        width = (int) Main.API.readDouble(address + 0x1F8);
        height = (int) Main.API.readDouble(address + 0x200);
    }
}
