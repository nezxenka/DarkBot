package com.github.nezxenka.darkbot.core.objects.gui;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.core.objects.Gui;
import com.github.nezxenka.darkbot.core.objects.facades.SettingsProxy;

public class LogoutGui extends Gui {

    private final SettingsProxy settingsProxy;
    private long lastShown;

    public long getLastShown() {
        return lastShown;
    }

    public LogoutGui(SettingsProxy settingsProxy) {
        this.settingsProxy = settingsProxy;
    }

    @Override
    public void update() {
        super.update();
        // Due to bugs in logout gui, make it so isAnimationDone will only be
        // true a while after tweening, instead of instantly, by updating time
        if (isTweening) time = System.currentTimeMillis();
    }

    @Override
    public boolean show(boolean value) {
        if (value) lastShown = System.currentTimeMillis();
        return super.show(value);
    }

    @Override
    protected void legacyToggle(boolean show) {
        if (show) {
            Character charCode = settingsProxy.getCharCode(SettingsProxy.KeyBind.LOGOUT);
            if (charCode != null) {
                Main.API.keyboardClick(charCode);
                return;
            }
        }

        super.legacyToggle(show);
    }
}
