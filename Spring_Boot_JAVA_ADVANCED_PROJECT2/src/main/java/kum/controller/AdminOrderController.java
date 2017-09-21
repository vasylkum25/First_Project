package kum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kum.entity.Order;
import kum.service.IngredientService;
import kum.service.MealService;

@Controller
@RequestMapping("/admin/order")
@SessionAttributes("order")
public class AdminOrderController {

	
	private final MealService mealService;
	
	private final IngredientService ingredientService;
	
	@Autowired
	public AdminOrderController(MealService mealService, IngredientService ingredientService) {
		this.mealService = mealService;
		this.ingredientService = ingredientService;
	}


	@ModelAttribute("order")
	public Order getForm(){
		return new Order();
	}
	
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("ingredients", ingredientService.findAllIngredients());
		model.addAttribute("meals", mealService.findAllViews());
		return "order";
	}
	
}
