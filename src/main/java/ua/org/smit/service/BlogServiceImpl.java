/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.service;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.org.smit.model.BlogEntity;

/**
 *
 * @author smit
 */
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private Dao dao;

    @Override
    public int create(String category, String title, String description) {
        return dao.write(new BlogEntity("fileNotExist", category, title, description));
    }

    @Override
    public BlogEntity get(int id) {
        return dao.getById(id);
    }

    @Override
    public List<BlogEntity> getAll() {
        return dao.getAll();
    }

    @Override
    public void update(int id, String category, String title, String description) {
        BlogEntity item = dao.getById(id);
        item.setCategory(category);
        item.setTitle(title);
        item.setDescription(description);
        dao.update(item);
    }

    @Override
    public void delete(int id) {
        BlogEntity item = dao.getById(id);
        dao.delete(item);
    }
    
    @Override
    public void uploadImg(int id, File img){
        String imgFileName = new ImgUtil(img).move();
        BlogEntity item = dao.getById(id);
        item.setImgFileName(imgFileName);
        dao.update(item);
    }

    @Override
    public void insertTestDataToDb() {
        new TestData(dao);
    }

    @Override
    public List<BlogEntity> findAll(String search) {
        return dao.findAll(search);
    }

    
}
