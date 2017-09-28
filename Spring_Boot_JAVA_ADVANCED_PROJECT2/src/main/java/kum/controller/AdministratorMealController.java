package kum.controller;

import java.security.Principal;

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

import kum.model.request.MealRequest;
import kum.service.CafeService;
import kum.service.CuisineService;
import kum.service.IngredientService;
import kum.service.MealService;

@Controller
@RequestMapping("/profile/ownMeal")
@SessionAttributes("meal")
public class AdministratorMealController {
	
	private final CafeService cafeService;
	
	private final MealService mealService;
	
	private final IngredientService ingredientService;
	
	private final CuisineService cuisineService;
	@Autowired
	public AdministratorMealController(CafeService cafeService, MealService mealService, IngredientService ingredientService, CuisineService cuisineService) {
		this.cafeService = cafeService;
		this.mealService = mealService;
		this.ingredientService = ingredientService;
		this.cuisineService = cuisineService;
	}
	
	/* Meal operation */
	
	@ModelAttribute("meal")
	public MealRequest getFormMeal(){
		return new MealRequest();
	}
	
	@GetMapping
	public String showOwnMeals(Model model, Principal principal){
		if(principal!=null){
		model.addAttribute("ownMeals", mealService.findAllMealsByUser(principal.getName()));
		}
		return "ownMeals";
}
	@GetMapping("/add")
	public String addMeal(Model model, Principal principal){
		model.addAttribute("ingredients", ingredientService.findAllIngredients());
		model.addAttribute("cuisines", cuisineService.findAllCuisines());
		if(principal!=null){
		model.addAttribute("cafes", cafeService.findAllCafesByUser(principal.getName()));
		}
		return "new_meal";
	}
	
	@PostMapping("/add")
	public String save(@ModelAttribute("meal") @Valid MealRequest request, BindingResult br, Model model, SessionStatus sessionStatus){
		mealService.save(request);
		return cancel(sessionStatus);
	} 
	@GetMapping("/cancel")
	public String cancel(SessionStatus sessionStatus){
		sessionStatus.setComplete();
	return "redirect:/profile/ownMeal/add";
}
	@GetMapping("/delete/{id}") 
	public String delete(@PathVariable Integer id){
		mealService.delete(id);
		return "redirect:/profile/ownMeal";
	}
	
	@GetMapping("/update/{id}") 
	public String update(@PathVariable Integer id, Model model, Principal principal){
		model.addAttribute("meal", mealService.findOne(id));
		return addMeal(model, principal);
	}
}