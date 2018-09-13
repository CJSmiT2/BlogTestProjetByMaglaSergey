/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.service;

import java.io.File;
import java.util.List;
import ua.org.smit.model.BlogEntity;

/**
 *
 * @author smit
 */
public interface BlogService {
    
    int create(String category, String title, String description);
    
    BlogEntity get(int id);
    
    List<BlogEntity> getAll();
    
    void update(int id, String category, String title, String description);
    
    void delete(int id);
    
    void uploadImg(int id, File img);

    public void insertTestDataToDb();

    public List<BlogEntity> findAll(String search);

    
}
