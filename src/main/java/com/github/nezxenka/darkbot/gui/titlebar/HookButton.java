package com.github.nezxenka.darkbot.gui.titlebar;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.core.api.adapters.DarkMemAdapter;
import com.github.nezxenka.darkbot.gui.utils.UIUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class HookButton extends TitleBarButton<JFrame> {

    HookButton(JFrame frame) {
        super(UIUtils.getIcon("plug"), frame);

        setVisible(Main.API instanceof DarkMemAdapter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.API.createWindow();
    }

}
