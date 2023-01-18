package com.aabushinov.bimcontext.Command;

import com.aabushinov.bimcontext.Type.Field;

public class IBlockPropertyCommand extends Command {

    private Field iBlockCodeField;
    private Field propertyCodeField;

    public IBlockPropertyCommand (String description, Field iBlockCodeField, Field propertyCodeField) {
        super(description);
        this.iBlockCodeField = iBlockCodeField;
        this.propertyCodeField = propertyCodeField;
    }
    @Override
    String getArgs() {
        return "IblockProperty:add --code=%IBLOCK_CODE% --propertyCode=%PROPERTY_CODE%"
                .replace("%IBLOCK_CODE%", iBlockCodeField.getInput().getText())
                .replace("%PROPERTY_CODE%", propertyCodeField.getInput().getText());
    }
}
