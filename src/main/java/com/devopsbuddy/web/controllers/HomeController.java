package com.devopsbuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by drsantos on 5/25/17.
 */

@Controller
public class HomeController {

    public static final String HOME_VIEW_NAME = "index";

    @RequestMapping("/home")
    public String home() { return HOME_VIEW_NAME;}
}
