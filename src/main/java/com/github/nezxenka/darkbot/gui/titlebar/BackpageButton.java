package com.github.nezxenka.darkbot.gui.titlebar;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.gui.MainGui;
import com.github.nezxenka.darkbot.gui.utils.UIUtils;
import com.github.nezxenka.darkbot.utils.I18n;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class BackpageButton extends TitleBarButton<MainGui> {

    private final Main main;
    private final JProgressBar progressBar = new JProgressBar(0, 50);

    BackpageButton(Main main, MainGui frame) {
        super(UIUtils.getIcon("home"), frame);
        this.main = main;

        setToolTipText(I18n.get("gui.backpage_button"));
        setLayout(new BorderLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isEnabled()) return;

        setEnabled(false);
        new BackpageTask(main, this).start();
    }

    public JProgressBar addProgressBar() {
        SwingUtilities.invokeLater(() -> {
            progressBar.setValue(0);
            progressBar.setIndeterminate(true);
            add(progressBar, BorderLayout.SOUTH);
            repaint();
        });
        return progressBar;
    }

    public void removeProgressBar() {
        SwingUtilities.invokeLater(() -> {
            remove(progressBar);
            repaint();
        });
    }
}
