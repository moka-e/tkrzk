package com.takarazuka.customer.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.takarazuka.customer.model.LoginForm;
import com.takarazuka.customer.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	MessageSource
	messageSource;

	@RequestMapping(value="",method=RequestMethod.GET)
	public String loginPage(Model model) {
		return "/customer/login";
	}

	@RequestMapping(value="/customer/login",method=RequestMethod.POST)
	public String login(Model model,@ModelAttribute("loginForm")LoginForm loginForm) {
		//ログイン認証
		boolean tf = loginService.loginAuthentication(loginForm.getUser_id(), loginForm.getPassword());
		List<String> err_list = new ArrayList<String>();
		err_list.add(messageSource.getMessage("err.login", null, Locale.getDefault()));
		if(tf) {
			return "/customer/index";
		}else {
			model.addAttribute("err_list", err_list);
			return "/customer/login";
		}
	}
}
