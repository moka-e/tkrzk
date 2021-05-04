package com.takarazuka.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	@Autowired
	MessageSource
	messageSource;

	@RequestMapping(value="/customer/register",method=RequestMethod.GET)
	public String register(Model model) {
		return "customer/register";
	}

}
