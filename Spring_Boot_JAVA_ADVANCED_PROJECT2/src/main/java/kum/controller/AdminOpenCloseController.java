package kum.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kum.model.request.OpenCloseRequest;
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
	public OpenCloseRequest getForm(){
		return new OpenCloseRequest();
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
	public String save(@ModelAttribute("open_close")@Valid OpenCloseRequest openCloseRequest, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()) return find(model);
		service.save(openCloseRequest);
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
