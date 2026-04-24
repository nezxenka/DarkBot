package com.github.nezxenka.darkbot.gui.conditions;

import com.github.nezxenka.darkbot.config.actions.Value;

import javax.swing.*;

public class ValueEditor<T> extends JPanel {

    private Value<T> value;


    public ValueEditor() {

    }

    public void display(Value<T> condition) {
        removeAll();

    }


}
