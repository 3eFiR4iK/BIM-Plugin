package com.aabushinov.bimcontext.Action;

import com.aabushinov.bimcontext.Command.UpCommand;
import com.aabushinov.bimcontext.Service.TerminalService;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class UpAllAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        TerminalService.getInstance().exec(new UpCommand(null));
    }
}
