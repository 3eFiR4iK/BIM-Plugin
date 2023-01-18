package com.aabushinov.bimcontext.Command;

public class LIstCommand extends Command{
    public LIstCommand() {
        super(null);
    }

    @Override
    public String build() {
        return getConfig()
                .getExec()
                .replace("%ARGS%", "ls");
    }

    @Override
    String getArgs() {
        return null;
    }
}
