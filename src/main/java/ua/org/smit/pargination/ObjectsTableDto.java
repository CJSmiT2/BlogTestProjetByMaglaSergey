/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.pargination;

import java.util.ArrayList;

/**
 *
 * @author smit
 */
public class ObjectsTableDto {
    private final ArrayList<Row> rows = new ArrayList();
    
    public ObjectsTableDto(ArrayList<?> objects, int rows){
        ArrayList<Object> selectedObjects = new ArrayList();
        
        for (Object object:objects){
            if (selectedObjects.size()==rows){
                Row row = new Row(selectedObjects);
                this.rows.add(row);
                selectedObjects = new ArrayList(); 
                selectedObjects.add(object);
            }else{
                selectedObjects.add(object);
            }
        }
        
        if (!selectedObjects.isEmpty()) {
            Row row = new Row(selectedObjects);
            this.rows.add(row);
        }
    }

    public ArrayList<Row> getRows() {
        return rows;
    }
    
    public class Row {
        private final ArrayList<?> objects;

        public Row(ArrayList<?> objects) {
            this.objects = objects;
        }

        public ArrayList<?> getObjects() {
            return objects;
        }
    }
}
