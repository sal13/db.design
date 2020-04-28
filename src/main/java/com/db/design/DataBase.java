package com.db.design;

import java.util.HashMap;

public  class DataBase {
    String name;
    String description;
    HashMap<String,Table>  tables = new HashMap<>();

    public DataBase(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, Table> getTables() {
        return tables;
    }
}
