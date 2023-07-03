package com.saber.springmvcdemo.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = {"/","/home"})
    public String homePage(){
        return "home";
    }

    @ModelAttribute(name = "colors")
    public List<String> colors(){

        List<String> colors = new ArrayList<>();
        colors.add("RED");
        colors.add("GREEN");
        colors.add("BLUE");
        colors.add("YELLOW");
        colors.add("ORANGE");
        colors.add("BROWN");
        colors.add("WHITE");
        colors.add("BLACK");
        colors.add("PINK");
        colors.add("CYAN");
        colors.add("GRAY");
        return colors;
    }
}
