package com.db.design;

public class ColumnValue {
    String columnName;
    Object value;

    public ColumnValue(String columnName, Object value) {
        this.columnName = columnName;
        this.value = value;
    }
}
