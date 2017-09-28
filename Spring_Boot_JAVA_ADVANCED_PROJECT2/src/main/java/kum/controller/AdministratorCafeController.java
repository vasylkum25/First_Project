package kum.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kum.entity.Type;
import kum.model.request.CafeRequest;
import kum.service.CafeService;
import kum.service.OpenCloseService;
import kum.validation.flag.CafeFlag;

@Controller
@RequestMapping("/profile")
@SessionAttributes("cafe")
public class AdministratorCafeController {
	
	private final CafeService cafeService;
	private final OpenCloseService openService;
	
	@Autowired
	public AdministratorCafeController(CafeService cafeService, OpenCloseService openService) {
		this.cafeService = cafeService;
		this.openService = openService;
	}
	@ModelAttribute("cafe")
	public CafeRequest getForm(){
		return new CafeRequest();
	}
	
	@GetMapping
	public String show(){
		return "profile";
	}
	
	@GetMapping("/ownCafe")
	public String showOwnCafes(Model model, Principal principal){
		if(principal!=null){
		model.addAttribute("ownCafes", cafeService.findAllCafesByUser(principal.getName()));
		}
		return "ownCafes";
	}
	@GetMapping("/ownCafe/add")
	public String addMyCafe(Model model, Principal principal){
		model.addAttribute("types", Type.values());
		model.addAttribute("times", openService.findAllTimes());
		return "new_cafe";
	}
	@GetMapping("/ownCafe/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("types", Type.values());
		model.addAttribute("times", openService.findAllTimes());
		model.addAttribute("cafe", cafeService.findOneCafe(id));
		return "new_cafe";
	}
	
	@PostMapping("/ownCafe/add")
	public String save(@ModelAttribute("cafe") @Validated (CafeFlag.class) CafeRequest request, BindingResult br, Model model, SessionStatus status, Principal principal){
	if(br.hasErrors()) return addMyCafe(model, principal);
		cafeService.save(request, principal);
		return cancel(status);
	}
	
	@GetMapping("/ownCafe/delete/{id}")
	private String delete(@PathVariable Integer id)
	{cafeService.delete(id);
	return "redirect:/profile/ownCafe";
	}
	
	@GetMapping("/ownCafe/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/profile/ownCafe/add";
	}
	
}