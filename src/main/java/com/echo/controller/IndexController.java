package com.echo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping({"/","/index"})
    public String index(Model model){
        return "index";
    }

    @GetMapping("/fail")
    public String error(){
        return "page-500";
    }

    @GetMapping("/toLogin")
    public String doLogin(){
        return "login";
    }

    @GetMapping("/imageFail")
    public String imageFail(){
        return "image-500";
    }
}
