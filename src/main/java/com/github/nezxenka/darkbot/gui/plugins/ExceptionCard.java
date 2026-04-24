package com.github.nezxenka.darkbot.gui.plugins;

import com.github.nezxenka.darkbot.extensions.plugins.PluginException;
import com.github.nezxenka.darkbot.gui.utils.UIUtils;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ExceptionCard extends JPanel {

    private static final Border ERROR_BORDER = BorderFactory.createLineBorder(UIUtils.RED);
    private static int ALPHA = 96 << 24;
    private static final Color ERROR_COLOR = new Color(UIUtils.RED.getRGB() + ALPHA, true);

    public ExceptionCard(PluginException exception) {
        super(new MigLayout("", "[grow]10px[]", ""));
        setBorder(ERROR_BORDER);
        setBackground(ERROR_COLOR);

        if (exception.getPlugin() != null) add(new JLabel(exception.getPlugin().getName()));
        JLabel label = new JLabel(exception.getMessage());
        if (exception.getCause() != null) {
            label.setToolTipText(exception.getCause().toString());
        }
        add(label);
    }

}
