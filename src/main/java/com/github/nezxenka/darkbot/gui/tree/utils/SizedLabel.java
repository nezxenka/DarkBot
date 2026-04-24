package com.github.nezxenka.darkbot.gui.tree.utils;

import com.github.nezxenka.darkbot.gui.AdvancedConfig;

import javax.swing.*;
import java.awt.*;

public class SizedLabel extends JLabel {
    public SizedLabel(String text) {
        super(text);
    }
    @Override
    public Dimension getPreferredSize() {
        return AdvancedConfig.forcePreferredHeight(super.getPreferredSize());
    }
}
