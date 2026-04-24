package com.github.nezxenka.darkbot.gui.titlebar;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.gui.components.ApiSettingsPanel;
import com.github.nezxenka.darkbot.gui.utils.UIUtils;
import com.github.nezxenka.darkbot.utils.I18n;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.github.nezxenka.darkbot.Main.API;

public class VisibilityButton extends TitleBarToggleButton<JFrame> {

    private static final Icon SHOW = UIUtils.getIcon("visibility"), HIDE = UIUtils.getIcon("visibility_off");

    private final Main main;

    VisibilityButton(Main main, JFrame frame) {
        super(SHOW, frame);
        this.main = main;

        setSelectedIcon(HIDE);
        setToolTipText(I18n.get("gui.visibility_button"));
        setSelected(API.isInitiallyShown());
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!SwingUtilities.isRightMouseButton(e)) return;
                new ApiSettingsPanel(main, main.config.BOT_SETTINGS.API_CONFIG, VisibilityButton.this);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        API.setVisible(isSelected(), main.config.BOT_SETTINGS.API_CONFIG.FULLY_HIDE_API);
    }

}
