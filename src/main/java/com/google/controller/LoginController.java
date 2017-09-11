package com.google.controller;

import com.google.pojo.Person;
import com.imac.json.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/index")
	@Json(type = Person.class, include = "id")
    public Person index(HttpServletRequest request, HttpServletResponse response) {
        return new Person();
    }
}
