package com.aabushinov.bimcontext.Command;

import com.aabushinov.bimcontext.ConfigurationState;

abstract class Command implements CommandInterface{
    private final String description;

    Command(String description) {
        this.description = description;
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
