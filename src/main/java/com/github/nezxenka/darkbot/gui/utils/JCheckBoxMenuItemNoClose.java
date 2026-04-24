package com.github.nezxenka.darkbot.gui.utils;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class JCheckBoxMenuItemNoClose extends JCheckBoxMenuItem {

    public JCheckBoxMenuItemNoClose(String text) {
        super(text);
    }

    @Override
    protected void processMouseEvent(MouseEvent evt) {
        if (evt.getID() == MouseEvent.MOUSE_RELEASED && contains(evt.getPoint())) {
            doClick();
            setArmed(true);
        } else {
            super.processMouseEvent(evt);
        }
    }
}
