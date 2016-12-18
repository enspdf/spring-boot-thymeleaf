package me.shackox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by SHACKOX on 18/12/16.
 */

@Controller
public class ViewController {
    // @Value("${app-mode}") inject by value property set in the application.properties
    private String appMode;

    @Autowired // dependency injection by environment properties
    public ViewController(Environment environment) {
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Shackox");
        model.addAttribute("mode", appMode);
        return "index";
    }
}
