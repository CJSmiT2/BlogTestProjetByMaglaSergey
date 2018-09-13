/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.controller;

import ua.org.smit.service.BlogService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.org.smit.model.BlogEntity;
import ua.org.smit.pargination.ObjectsTableDto;
import ua.org.smit.pargination.Pagination;

/**
 *
 * @author smit
 */
@Controller
public class MainController {
    @Autowired
    private BlogService blogService;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    
    @RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
    public String home(
            @RequestParam(name="page", required=false, defaultValue="1") String page, 
            @RequestParam(name="search", required=false, defaultValue="none") String search,
            Model model) {
        
        List<BlogEntity> blogsList = new ArrayList();
        if (search.equalsIgnoreCase("none")){
            blogsList = blogService.getAll();
        } else {
            blogsList = blogService.findAll(search);
        }
        
        if (!blogsList.isEmpty()){
            Collections.reverse(blogsList);
            Pagination pagination = new Pagination(page, (ArrayList)blogsList, 10);
            model.addAttribute("pagination", pagination);
            ObjectsTableDto itemsList = new ObjectsTableDto(pagination.getItemsByPage(), 1);
            model.addAttribute("itemsList", itemsList);
        }
        
        return "home";
    }
    
    @RequestMapping(value = "/item_manager", method = RequestMethod.GET)
    public String itemManager(@RequestParam(name="id", required=false, defaultValue="") String idParam, Model model) {

        if (!idParam.isEmpty()){
            try{
                int id = Integer.valueOf(idParam);
                model.addAttribute("item", blogService.get(id));
            } catch (NumberFormatException ex){
            }
        } 

        return "item_manager";
    }
    
    @RequestMapping(value = "/item_manager_action", method = RequestMethod.POST)
    public String itemManagerAction(
            @RequestParam(name="id", required=false, defaultValue="") String idParam, 
            @RequestParam(name="title", required=true) String title, 
            @RequestParam(name="description", required=true) String description, 
            @RequestParam(name="category", required=true) String category, 
            @RequestParam("myImg") MultipartFile inputFile,
            Model model) {
        
        
        int id = 0;
        if (idParam.isEmpty()){
            id = blogService.create(category, title, description);
        } else {
            try{
                id = Integer.valueOf(idParam);
                blogService.update(id, category, title, description);
            } catch (NumberFormatException ex){
            }
        }
        
        try {
            byte[] bytes = inputFile.getBytes();
            Path path = Paths.get("/tmp/" + inputFile.getOriginalFilename());
            Files.write(path, bytes);
            File img = new File(path.toString());
            blogService.uploadImg(id, img);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return "redirect:home";
    }
    
    @RequestMapping(value = "/insert_test_data_to_db", method = RequestMethod.GET)
    public String initTestData() {
        blogService.insertTestDataToDb();
        return "redirect:home";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(name="id") int id) {
        blogService.delete(id);
        return "redirect:home";
    }

}
