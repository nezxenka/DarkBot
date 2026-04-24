package com.github.nezxenka.darkbot.gui.titlebar;

import com.github.nezxenka.darkbot.gui.MainGui;
import com.github.nezxenka.darkbot.gui.utils.UIUtils;
import com.github.nezxenka.darkbot.utils.I18n;

import java.awt.event.ActionEvent;

public class ConfigButton extends TitleBarToggleButton<MainGui> {

    ConfigButton(MainGui frame) {
        super(UIUtils.getIcon("config"), frame);
        setSelectedIcon(UIUtils.getIcon("config_unloaded"));
        frame.addConfigVisibilityListener(this::setSelected);
        setToolTipText(I18n.get("gui.config_button"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.toggleConfig();
    }

}
