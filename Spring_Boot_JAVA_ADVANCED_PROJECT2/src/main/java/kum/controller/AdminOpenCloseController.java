package kum.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kum.entity.OpenClose;
import kum.service.OpenCloseService;

@Controller
@RequestMapping("/admin/open_close")
@SessionAttributes("open_close")
public class AdminOpenCloseController {
	
	private final OpenCloseService service;

	@Autowired
	public AdminOpenCloseController(OpenCloseService service) {
		this.service = service;
	}
	@ModelAttribute("open_close")
	public OpenClose getForm(){
		return new OpenClose();
	}
	
	
	@GetMapping
	public String find(Model model){
		model.addAttribute("opens", service.findAll());
		return "open_close";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/open_close";
	}

	@PostMapping
	public String save(@ModelAttribute("open_close") OpenClose open_close, SessionStatus status){
		service.save(open_close);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id,Model model){
		model.addAttribute("open_close", service.findOne(id));
		return find(model);
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/open_close";
	}
}
