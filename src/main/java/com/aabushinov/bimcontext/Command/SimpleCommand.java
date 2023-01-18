package com.aabushinov.bimcontext.Command;

public class SimpleCommand extends Command {
    public SimpleCommand(String description) {
        super(description);
    }

    @Override
    String getArgs() {
        return "";
    }
}
