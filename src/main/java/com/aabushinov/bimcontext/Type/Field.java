package com.aabushinov.bimcontext.Type;

import javax.swing.*;

public class Field {
    private final JLabel label;
    private final JTextField input;

    public Field(JLabel label, JTextField input) {
        this.input = input;
        this.label = label;
    }

    public JLabel getLabel() {
        return label;
    }

    public JTextField getInput() {
        return input;
    }
}
