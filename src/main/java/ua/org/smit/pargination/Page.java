/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.pargination;

import java.util.ArrayList;
import ua.org.smit.model.BlogEntity;

/**
 *
 * @author smit
 */
public class Page {
    
    private final int pageNumber;
    private ArrayList<BlogEntity> array = new ArrayList();

    public Page(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }
    
    public ArrayList<BlogEntity> getArray() {
        return array;
    }

    public void setArray(ArrayList<BlogEntity> array) {
        this.array = array;
    }
    
}
