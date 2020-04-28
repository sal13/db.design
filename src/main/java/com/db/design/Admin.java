package com.db.design;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum  Admin {
    INSTANCE;
    ConcurrentMap<String,DataBase> dataBaseHashMap = new ConcurrentHashMap<>();
    public void createDatabase(DataBase db) throws Exception {
        if(db==null){
            throw new Exception("databse cant be null");
        }
        if(dataBaseHashMap.containsKey(db.getName())){
            throw new Exception("databse already exists");
        }
        dataBaseHashMap.put(db.getName(), db);
        System.out.println("database created with  name "+ db.getName());
    }

    public void createTable(String dbNanme,Table tb) throws Exception {
        if(tb==null){
            throw new Exception("table cant be null");
        }
        if(!dataBaseHashMap.containsKey(dbNanme)){
            throw new Exception("databse does not exists");
        }
        DataBase db = dataBaseHashMap.get(dbNanme);
        if(!db.getTables().containsKey(tb.getName())) {
            db.getTables().put(tb.getName(), tb);
            System.out.println("table create with table name "+ tb.getName());
        }else{
            throw new Exception("table already exists in db");
        }
    }

    public void deleteTable(String dbNanme,String tbName) throws Exception {
        if(!dataBaseHashMap.containsKey(dbNanme)){
            throw new Exception("databse does not exists");
        }
        DataBase db = dataBaseHashMap.get(dbNanme);
        if(!db.getTables().containsKey(tbName)) {
            throw new Exception("cant delete empty tables");
        }else{
            db.getTables().remove(tbName);
        }
    }

    public void printAllDatabases(){
        System.out.println("printling all dbs");
        for(String name:dataBaseHashMap.keySet()){
            System.out.println(name);
        }
    }
    public void printAllTables(String db) throws Exception {
        System.out.println("printling all table");
        if(!dataBaseHashMap.containsKey(db)){
            throw new Exception("databse does not exists");
        }
        for(String tableName:dataBaseHashMap.get(db).getTables().keySet()) {
            System.out.println(tableName);
        }
    }
}
