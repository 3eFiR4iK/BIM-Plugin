package com.aabushinov.bimcontext.Command;

public class UpCommand extends Command {
    private String migrationName;

    public UpCommand(String migrationName) {
        super(null);
        this.migrationName = migrationName;
    }

    @Override
    public String build() {
        return getConfig()
                .getExec()
                .replace("%ARGS%", "up " + migrationName + " --force");
    }

    @Override
    String getArgs() {
        return null;
    }
}
