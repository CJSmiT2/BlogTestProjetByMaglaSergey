/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.service;

import java.io.File;
import java.net.URL;
import java.util.UUID;

/**
 *
 * @author smit
 */
public class ImgUtil {
    
    private final File imgFile;

    public ImgUtil(File imgFile) {
        this.imgFile = imgFile;
    }

    String move() {
        if (imgFile.exists()){
            URL fileUrl = getClass().getResource("/../../resources/");
            File file = new File(fileUrl.getFile() + "/img/");
            file.mkdir();
            
            String randomName = UUID.randomUUID().toString();
            String extension = getFileExtension(imgFile);

            File f2 = new File(file.getAbsolutePath() + "/" + randomName + "." + extension );

            boolean result = imgFile.renameTo(f2);
            if (result & f2.exists()) {
                imgFile.delete();
            } else {
                throw new RuntimeException("Cannot move file to: " + f2.getAbsolutePath());
            }

            return f2.getName();
        } else {
            return "fileNotExist";
        }

    }
    
    
    private String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
            return fileName.substring(fileName.lastIndexOf(".")+1);
        } else {
            throw new RuntimeException("Extension not found in file name! " + file.getName());
        }
    }
    
    
}
