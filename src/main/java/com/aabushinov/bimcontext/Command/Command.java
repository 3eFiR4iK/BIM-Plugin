package com.aabushinov.bimcontext.Command;

import com.aabushinov.bimcontext.ConfigurationState;

import java.util.Objects;

abstract class Command implements CommandInterface{
    private final String description;

    Command(String description) {
        this.description = Objects.equals(description, "") ? " " : description;
    }
    public String build() {
        String exec = getConfig().getExec();
        return exec.replace("%ARGS%", "gen " + getArgs() + " --d=\""+ description +"\"");
    }

    public ConfigurationState getConfig() {
        return ConfigurationState.getInstance();
    }

    abstract String getArgs();
}
