package com.db.design;

public abstract class DataType {
    StandardDataType type;

    boolean isUnique;
    boolean isRequired;

    public DataType(StandardDataType type, boolean isUnique, boolean isRequired) {
        this.type = type;
        this.isUnique = isUnique;
        this.isRequired = isRequired;
    }

    public boolean validate(){
        return  true;
    }
}