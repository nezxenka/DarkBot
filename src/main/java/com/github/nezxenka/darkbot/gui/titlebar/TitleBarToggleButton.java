package com.github.nezxenka.darkbot.gui.titlebar;

import com.github.nezxenka.darkbot.gui.components.MainToggleButton;

import javax.swing.*;
import java.awt.event.ActionListener;

abstract class TitleBarToggleButton<T extends JFrame> extends MainToggleButton implements ActionListener {

    protected T frame;

    TitleBarToggleButton(Icon icon, T frame) {
        super(icon);
        this.frame = frame;

        TitleBarButton.configureButton(this);
    }

}
