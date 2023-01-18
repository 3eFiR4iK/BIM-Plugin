package com.aabushinov.bimcontext.Command;

import com.aabushinov.bimcontext.Type.Field;

public class IBlockCommand extends Command{
    private Field iBlockCodeField;

    public IBlockCommand(String description, Field iBlockCodeField) {
        super(description);
        this.iBlockCodeField = iBlockCodeField;
    }
    @Override
    String getArgs() {
        return "Iblock:add --code=" + iBlockCodeField.getInput().getText();
    }
}
