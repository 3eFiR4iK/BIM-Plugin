package com.aabushinov.bimcontext.Command;

import com.aabushinov.bimcontext.Type.Field;

public class IBlockTypeCommand extends Command {
    private Field iBlockTypeCode;

    public IBlockTypeCommand(String description, Field iBlockTypeCode) {
        super(description);
        this.iBlockTypeCode = iBlockTypeCode;
    }

    @Override
    String getArgs() {
        return "IblockType:add --typeId=" + iBlockTypeCode.getInput().getText();
    }
}
