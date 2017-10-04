package kum.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import kum.model.filter.CafeFilter;
import kum.model.request.CafeRequest;
import kum.service.CafeService;
import kum.service.MealService;
import kum.service.OpenCloseService;
import kum.validation.flag.CafeFlag;

@Controller
@RequestMapping("/profile")
@SessionAttributes("cafe")
public class AdministratorCafeController {
	
	private final CafeService cafeService;
	private final OpenCloseService openService;
	private final MealService mealService;
	
	@Autowired
	public AdministratorCafeController(CafeService cafeService, OpenCloseService openService, MealService mealService) {
		this.cafeService = cafeService;
		this.openService = openService;
		this.mealService = mealService;
	}
	@ModelAttribute("cafe")
	public CafeRequest getForm(){
		return new CafeRequest();
	}
	
	@ModelAttribute("cafeFilter")
	public CafeFilter getFilter(){
		return new CafeFilter();
	}
	
	@GetMapping
	public String show(){
		return "profile";
	}
	
	@GetMapping("/ownCafe")
	public String showOwnCafes(Model model, Principal principal, @PageableDefault Pageable pageable, @ModelAttribute("cafeFilter") CafeFilter cafeFilter){
		if(principal!=null){
		model.addAttribute("meals", mealService.findAll());
		model.addAttribute("ownCafes", cafeService.findAll(cafeFilter, pageable, principal));
		
		}
		return "ownCafes";
	}
	@GetMapping("/ownCafe/add")
	public String addMyCafe(Model model, Principal principal){
		model.addAttribute("types", Type.values());
		model.addAttribute("times", openService.findAllTimes());
		return "new_cafe";
	}
	@PostMapping("/ownCafe/add")
	public String save(@ModelAttribute("cafe") @Validated (CafeFlag.class) CafeRequest request, BindingResult br, Model model, SessionStatus status, Principal principal){
		if(br.hasErrors()) return addMyCafe(model, principal);
		cafeService.save(request, principal);
		return cancel(status);
	}
	
	@GetMapping("/ownCafe/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("types", Type.values());
		model.addAttribute("times", openService.findAllTimes());
		model.addAttribute("cafe", cafeService.findOneCafe(id));
		return "new_cafe";
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