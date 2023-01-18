package com.aabushinov.bimcontext;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Objects;

public class Configuration implements SearchableConfigurable {
    private ConfigurationGUI myMainComponent;
    private final ConfigurationState config;

    Configuration () {
        config = ConfigurationState.getInstance();
    }

    @Override
    public @NotNull @NonNls String getId() {
        return getDisplayName();
    }

    @Override
    public String getDisplayName() {
        return "Bim Plugin";
    }

    @NotNull
    @Override
    public JComponent createComponent() {
        if (myMainComponent == null) {
            myMainComponent = new ConfigurationGUI(config);
        }

        return myMainComponent;
    }

    @Override
    public boolean isModified() {
        return !Objects.equals(config.getExec(), myMainComponent.getExec());
    }

    @Override
    public void apply() throws ConfigurationException {
        config.setExec(myMainComponent.getExec());
    }
}
