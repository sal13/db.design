package com.db.design;

public class Column {
        String name;
        DataType dataType;

        public Column(String name, DataType dataType) {
                this.name = name;
                this.dataType = dataType;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public DataType getDataType() {
                return dataType;
        }

        public void setDataType(DataType dataType) {
                this.dataType = dataType;
        }

}
