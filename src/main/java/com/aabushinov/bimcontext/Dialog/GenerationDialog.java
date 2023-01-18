package com.aabushinov.bimcontext.Dialog;

import com.aabushinov.bimcontext.GUI.GenerateGUI;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GenerationDialog extends DialogWrapper {
    private GenerateGUI GUI;

    public GenerationDialog() {
        super(true);
        setTitle("Generate Migration");
        setSize(400, 400);
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        GUI = new GenerateGUI();
        return GUI;
    }

    public GenerateGUI getGUI() {
        return GUI;
    }
}
