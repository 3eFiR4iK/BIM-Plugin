package com.aabushinov.bimcontext.Service;

import com.aabushinov.bimcontext.Command.CommandInterface;
import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.plugins.terminal.ShellTerminalWidget;
import org.jetbrains.plugins.terminal.TerminalView;

import java.io.IOException;

public class TerminalService {
    private static ShellTerminalWidget terminal;

    public static TerminalService getInstance() {
        return ApplicationManager.getApplication().getService(TerminalService.class);
    }

    public ShellTerminalWidget getTerminal() {
        if (terminal == null) {
            createTerminal();
        }

        return terminal;
    }

    public void exec(CommandInterface command) {
        if (!getTerminal().isSessionRunning()) {
            createTerminal();
        }

        try {
            getTerminal().executeCommand(command.build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createTerminal() {
        DataContext dataContext = DataManager.getInstance().getDataContext();
        Project project = (Project) dataContext.getData(CommonDataKeys.PROJECT);

        TerminalView terminalView = TerminalView.getInstance(project);

        terminal = terminalView.createLocalShellWidget(project.getBasePath(), "Bim migration");
    }
}
