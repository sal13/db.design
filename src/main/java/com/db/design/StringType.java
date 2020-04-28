package com.db.design;

public class StringType extends DataType{
    StringType(boolean isUnique, boolean isRequired){
        super(StandardDataType.STRING,isUnique,isRequired);
    }
}
