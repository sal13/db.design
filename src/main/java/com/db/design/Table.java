package com.db.design;
import java.util.*;

public class Table {
    String name;
    String description;
    HashMap<String,Column> colummnDir = new LinkedHashMap<>();
    List<List<ColumnValue>> rows;

    public Table(String name, String description, Set<Column> columnList) {
        this.name = name;
        this.description = description;
        for (Column c:columnList) {
            colummnDir.put(c.getName(),c);
        }
        rows= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getColummnDir(){
        return colummnDir.keySet();
    }

    public boolean validateFroUniquenss(){
        return true;
    }

    public void insert(HashMap<String,ColumnValue> tmpColumns){
        List row = new ArrayList();
        for (ColumnValue cm:tmpColumns.values()) {
            //if(colummnDir.get(cm.columnName)) {
            row.add(cm);
            //}
        }
        rows.add(row);
    }

    public void printAll(){
        System.out.println("printing select * from the table;");
        for (List<ColumnValue> cvs:rows) {

            printOne(cvs);
        }
    }

    public void printOne(List<ColumnValue> cvs){
        for(ColumnValue cv:cvs){
            System.out.print("["+cv.columnName+" "+cv.value+"] ");
        }
        System.out.println();

    }

    public List<ColumnValue> selectOne(ColumnValue searchCv){
        System.out.println("printing for row match for ----"+searchCv.columnName+"= "+searchCv.value);
        for (List<ColumnValue> cvs:rows) {
            for(ColumnValue cv:cvs){
                if(cv.columnName.equals(searchCv.columnName) && cv.value.equals(searchCv.value)){
                    printOne(cvs);
                    return cvs;
                }
            }
        }
        return null;
    }

}
