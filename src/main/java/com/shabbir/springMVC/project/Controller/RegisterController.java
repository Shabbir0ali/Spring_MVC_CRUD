package com.shabbir.springMVC.project.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shabbir.springMVC.project.Model.Entity.RegisterBean;
import com.shabbir.springMVC.project.Model.Entity.StudentBean;
import com.shabbir.springMVC.project.Model.Service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	@RequestMapping(path = "/home")
	public String home() {
		return "home";
	}

	@RequestMapping(path = "/register")
	public String register() {
		return "register";
	}

	/* timesstamp */
	@RequestMapping(path = "/reg", method = RequestMethod.POST)
	public String regSave(@ModelAttribute RegisterBean bean, Model model, HttpSession httpSession) {
		if (bean.getConfirmPassword().equals(bean.getPassword())) {

			this.registerService.register(bean);
		} else {
			model.addAttribute("message", "Both Password don't match please Enter again");
			return "register";
		}

		model.addAttribute("secess", "Registered Successfully");
		return "login";
	}

	@RequestMapping(path = "/login")
	public String login() {
		return "login";
	}

	@PostMapping("/log")
	public String log(@ModelAttribute RegisterBean bean, Model model, HttpSession session) {
		boolean b = registerService.login(bean);
		if (b) {
			RegisterBean value = registerService.getValue(bean.getEmail());
			session.setAttribute("ses", value);
			return "home";
		} else {
			model.addAttribute("fail", "Enter Valid Email Or Password");
			return "login";
		}
	}
}