package com.shabbir.springMVC.project.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shabbir.springMVC.project.Model.Entity.RegisterBean;
import com.shabbir.springMVC.project.Model.Entity.StudentBean;
import com.shabbir.springMVC.project.Model.Service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String stud(@ModelAttribute StudentBean bean , Model model) {
		boolean save = service.save(bean);
		if(save) {
			
			return "fetchAll";
		}
		
		else {
			model.addAttribute("save","You Alrady Add Your Data Go & check in Student detail");
			return "home";
		}

	}

	@RequestMapping(value = "/main")
	public String main() {

		return "student";
	}

	@RequestMapping(value = "/fetch")
	public String fecthall() {
		return "fetchAll";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "register";
	}

	@GetMapping("/delete/{id}")
	public String delete(HttpSession session, Model model, @PathVariable("id") int id) {
		System.out.println("inside delete method");
		RegisterBean attribute = (RegisterBean) session.getAttribute("ses");
		boolean del = service.deleteByE(attribute.getEmail(), id);
		if (del) {
			session.invalidate();
			return "login";
		} else {
			return "redirect:/home?messa='You can't Delete Other person'";
		}
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(/* @PathVariable("id") int id, */ Model model,@RequestParam("id") int id) {
	    StudentBean bean = service.findById(id);
	    model.addAttribute("bean12", bean);
	    return "edit";
	}
	
	@RequestMapping(value = "/updated12", method = RequestMethod.POST)
	public String update(@ModelAttribute StudentBean bean , Model model , HttpSession session) {
		boolean update = false;
		RegisterBean attribute = (RegisterBean) session.getAttribute("ses");
		if(attribute.getEmail().equals(bean.getEmail())) {
			
		 update = service.update(bean);
		 if(update) {
			 model.addAttribute("message","Updated Success fully");
		 }
		 else {
			 model.addAttribute("message","Something went wrong");
		 }
		}
		else {
			model.addAttribute("up", "You can't Update another student");
		}
		return "home";
	}
	public StudentService getService() {
		return service;
	}

	public void setService(StudentService service) {
		this.service = service;
	}
}