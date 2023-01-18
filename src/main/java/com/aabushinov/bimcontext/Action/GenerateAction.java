package com.aabushinov.bimcontext.Action;

import com.aabushinov.bimcontext.Command.IBlockCommand;
import com.aabushinov.bimcontext.Command.IBlockPropertyCommand;
import com.aabushinov.bimcontext.Command.IBlockTypeCommand;
import com.aabushinov.bimcontext.Command.SimpleCommand;
import com.aabushinov.bimcontext.Dialog.GenerationDialog;
import com.aabushinov.bimcontext.Service.TerminalService;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.NotNull;

public class GenerateAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        TerminalService terminalService = TerminalService.getInstance();
        GenerationDialog dlgWrapper = new GenerationDialog();
        dlgWrapper.show();

        if (dlgWrapper.getExitCode() == DialogWrapper.OK_EXIT_CODE) {
            switch (dlgWrapper.getGUI().getCommandName()) {
                case "simple":
                    terminalService.exec(new SimpleCommand(dlgWrapper.getGUI().getDescription()));
                    break;
                case "IBlock property":
                    terminalService.exec(new IBlockPropertyCommand(
                            dlgWrapper.getGUI().getDescription(),
                            dlgWrapper.getGUI().getCurrentField().get(0),
                            dlgWrapper.getGUI().getCurrentField().get(1)
                    ));
                    break;
                case "IBlock":
                    terminalService.exec(new IBlockCommand(
                            dlgWrapper.getGUI().getDescription(),
                            dlgWrapper.getGUI().getCurrentField().get(0)
                    ));
                    break;
                case "IBlock type":
                    terminalService.exec(new IBlockTypeCommand(
                            dlgWrapper.getGUI().getDescription(),
                            dlgWrapper.getGUI().getCurrentField().get(0)
                    ));
                    break;
            }
        }
    }
}
