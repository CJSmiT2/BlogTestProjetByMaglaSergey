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
public class Pagination {
    
    private final int currentPageNumber;
    private final int pageSize;
    private final ArrayList<BlogEntity> objectsArray;
    private final ArrayList<Page> pages = new ArrayList();

    public Pagination(String pageNumber, ArrayList<BlogEntity> dtos, int pageSize) {
        int currentPage = 1;
        if (pageNumber!=null && !pageNumber.isEmpty()){
            currentPage = Integer.valueOf(pageNumber);
        }
        this.currentPageNumber = currentPage;
        this.objectsArray = dtos;
        this.pageSize = pageSize;
        
        
        Page page = null;
        int pageNumberCount = 0;
        for (BlogEntity album:objectsArray){
            if (page==null || page.getArray().size()==pageSize){
                pageNumberCount++;
                page = new Page(pageNumberCount);
                pages.add(page);
            }
            page.getArray().add(album);
        }
    }
    

    public ArrayList<BlogEntity> getItemsByPage() {
        return pages.get(currentPageNumber - 1).getArray();
    }
    
    public ArrayList<Integer> getPagesSize(){
        ArrayList<Integer> size = new ArrayList();
        for (int i=1;i<=pages.size();i++){
            size.add(i);
        }
        return size;
    }
    
    public String getNextPageNumber(){
        try{
            for (int i=0;i<pages.size();i++){
                if (pages.get(i).getPageNumber()==currentPageNumber) {
                    return String.valueOf(pages.get(i + 1).getPageNumber());
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
        }catch (IndexOutOfBoundsException e){
        }
        return null;
    }
    
    public String getPreviosPageNumber(){
        try{
            for (int i=0;i<pages.size();i++){
                if (pages.get(i).getPageNumber()==currentPageNumber) {
                    return String.valueOf(pages.get(i - 1).getPageNumber());
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
        }catch (IndexOutOfBoundsException e){
        }
        return null;
    }

    
}
