package edu.wctc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String showHomePage() {return "index";}

    @RequestMapping("/genres")
    public String showGenres() {return "genre-list";}

    @RequestMapping("/recommendations")
    public String showRecommendations() {return "action";}

    @RequestMapping("/login")
    public String showLogin() {return "login";}
}
