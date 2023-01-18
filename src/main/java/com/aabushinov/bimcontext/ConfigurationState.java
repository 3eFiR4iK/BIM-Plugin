package com.aabushinov.bimcontext;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.util.xmlb.XmlSerializerUtil;


@State(
        name = "ConfigurationState",
        storages = {@Storage("ConfigurationState.xml")}
)
public class ConfigurationState implements PersistentStateComponent<ConfigurationState> {
    private String exec;
    ConfigurationState () {}

    public static ConfigurationState getInstance() {
        return ApplicationManager.getApplication().getService(ConfigurationState.class);
    }

    @Override
    public @Nullable ConfigurationState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull ConfigurationState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public void setExec(String exec) {
        this.exec = exec;
    }

    public String getExec() {
        if (exec == null) {
            return "";
        }

        return exec;
    }
}
