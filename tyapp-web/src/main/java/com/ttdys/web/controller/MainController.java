package com.ttdys.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class MainController {


    @RequestMapping("/")
    public String index(HttpServletResponse response) {
        return "hello";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/dashboard")
    public String dashboard() {

        return "dash";
    }

}
