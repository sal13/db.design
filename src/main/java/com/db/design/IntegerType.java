package com.db.design;

class IntegerType extends DataType{
    Object rangeStart;
    Object rangeEnd;
    IntegerType(boolean isUnique, boolean isRequired){
        super(StandardDataType.INT,isUnique,isRequired);
    }

    public boolean validate(){
        if(!super.validate()){
            return false;
        }

        return true;
    }

}
