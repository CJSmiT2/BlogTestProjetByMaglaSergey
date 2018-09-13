/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author smit
 */
@Entity
@Table(name = "blog")
public class BlogEntity implements Serializable{
    public static final long serialVersionUID = 41564637451902963L;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imgFileName;
    private String category;
    private String title;
    private String description;

    public BlogEntity() {
    }
    

    public BlogEntity(String imgFileName, String category, String title, String description) {
        this.imgFileName = imgFileName;
        this.category = category;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean imgFileExist(){
        return !imgFileName.equalsIgnoreCase("fileNotExist") && !imgFileName.isEmpty();
    }

    @Override
    public String toString() {
        return "BlogEntity{" + "id=" + id + ", imgFileName=" + imgFileName + ", category=" + category + ", title=" + title + ", description=" + description + '}';
    }
    
    
}
