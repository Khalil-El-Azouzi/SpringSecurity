package com.ensa.tp1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.intercept.aopalliance.MethodSecurityMetadataSourceAdvisor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping

public class TestController {



	@RequestMapping("/")
	public ModelAndView defaultHome() {
		return new ModelAndView("login");
	}

	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@Secured("ROLE_USER")
	@RequestMapping("/user/dashboard")
	public ModelAndView userDashboard() {
		return new ModelAndView("user/dashboard");
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/admin/dashboard")
	public ModelAndView admindashboard() {
		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping("/accessdenied")
	public ModelAndView accessdenied() {
		return new ModelAndView("accessdenied");
	}
}

