package com.github.nezxenka.darkbot.gui.titlebar;

import com.github.nezxenka.darkbot.extensions.plugins.PluginHandler;
import com.github.nezxenka.darkbot.extensions.plugins.PluginListener;
import com.github.nezxenka.darkbot.gui.utils.UIUtils;
import com.github.nezxenka.darkbot.utils.I18n;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PluginReloadButton extends TitleBarButton<JFrame> implements PluginListener {

    private final PluginHandler pluginHandler;

    PluginReloadButton(JFrame frame, PluginHandler pluginHandler) {
        super(UIUtils.getIcon("reload"), frame);
        setToolTipText(I18n.get("plugins.reload"));
        this.pluginHandler = pluginHandler;
        pluginHandler.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setEnabled(false);
        pluginHandler.updatePlugins();
    }

    @Override
    public void afterLoadCompleteUI() {
        setEnabled(true);
    }
}
