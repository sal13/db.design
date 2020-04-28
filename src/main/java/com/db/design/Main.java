package com.db.design;

import java.util.*;

public class Main {


    public static void main(String args[] ) throws Exception {
        Admin.INSTANCE.createDatabase(new DataBase("Company", ""));
        Set<Column> columns = new HashSet<>();
        columns.add(new Column("name",new StringType(true,true)));
        columns.add(new Column("age",new StringType(true,true)));
        Table tb = new Table("Employee","",columns);
        Admin.INSTANCE.createTable("Company",tb);
        addColumns(tb);
        tb.printAll();
        tb.selectOne(new ColumnValue("age","123"));
    }

    public static void addColumns(Table tb){
        Set<String> columnDir = tb.getColummnDir();
        Scanner sc = new Scanner(System.in);
        String values[] = {"1","123"};
        HashMap<String, ColumnValue> hm = new HashMap<>();
        int i=0;
        for(String col:columnDir){
            ColumnValue cm = new ColumnValue(col,values[i++]);
            hm.put(col,cm);
        }
        tb.insert(hm);
    }


}
