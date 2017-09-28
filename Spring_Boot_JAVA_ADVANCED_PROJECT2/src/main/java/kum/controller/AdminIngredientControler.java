package kum.controller;


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

import kum.entity.Ingredient;
import kum.service.IngredientService;
import kum.validation.flag.IngredientFlag;
@Controller
@RequestMapping("/admin/ingredient")
@SessionAttributes("ingredient")
public class AdminIngredientControler {

	private final IngredientService service;

	@Autowired
	public AdminIngredientControler(IngredientService service) {
		this.service = service;
	}
	
	@ModelAttribute("ingredient")
	public Ingredient getForm(){
		return new Ingredient();
	}
	
	
	@GetMapping
	public String find(Model model, @PageableDefault Pageable pageable){
		model.addAttribute("ingredients", service.findAll(pageable));
		return "ingredient";
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/ingredient";
		
	}
	
	@PostMapping
	public String save(@ModelAttribute("ingredient") @Validated (IngredientFlag.class) Ingredient ingredient, BindingResult br, Model model, SessionStatus status, Pageable pageable){
		if(br.hasErrors()) return find(model, pageable);
		service.save(ingredient);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id,Model model, Pageable pageable){
		model.addAttribute("ingredient", service.findOne(id));
		return find(model, pageable);
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/ingredient";
	}
}
