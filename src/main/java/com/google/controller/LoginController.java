package com.google.controller;

import com.google.pojo.Person;
import com.imac.json.Json;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @RequestMapping("/index")
	@Json(type = Person.class, include = "id")
    public Person index(HttpServletRequest request, HttpServletResponse response) {

		LOGGER.info("login");

        return new Person();
    }

    @RequestMapping("/index2")
	@ResponseBody
    public Person index2(HttpServletRequest request, HttpServletResponse response) {
    	return new Person();
	}
}
