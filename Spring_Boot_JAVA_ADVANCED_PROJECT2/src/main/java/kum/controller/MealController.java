package kum.controller;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kum.model.filter.MealFilter;
import kum.model.request.CommentRequest;
import kum.repository.MealViewRepository;
import kum.service.CafeService;
import kum.service.CommentService;
import kum.service.CuisineService;
import kum.service.IngredientService;
import kum.service.MealService;

@Controller
@RequestMapping("/meal")
@SessionAttributes("meal")
public class MealController {

	private final MealService mealService;
	
	@Autowired
	private CafeService cafeService;
	
	@Autowired
	private CuisineService cuisineService;
	
	@Autowired
	private CommentService commentService;
	
	
	@Autowired
	public MealController(MealService mealService) {
		this.mealService = mealService;
	}
	
	@ModelAttribute("mealFilter")
	public MealFilter getFilter(){
		return new MealFilter();
	}
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("mealFilter") MealFilter mealFilter){
		model.addAttribute("meals", mealService.findAll(pageable, mealFilter));
		model.addAttribute("cafes", cafeService.findAllIndexViews());
		model.addAttribute("cuisines", cuisineService.findAll());
		return "meals";
	}
	
	@GetMapping("/{id}")
	public String showIndexMeal(Model model, @PathVariable Integer id, @PageableDefault Pageable pageable){
		model.addAttribute("oneMeal", mealService.findOne(id));
		model.addAttribute("comments", commentService.findCommentByMealId(id));
		return "meal";
	}
	
//	Action to commment
	
	
	@ModelAttribute("comment")
	public CommentRequest getFormComment() {
		return new CommentRequest();
	}
	
	@PostMapping("/{id}")
	public String saveComment(@ModelAttribute("comment") CommentRequest commentRequest, @PathVariable Integer id){
		commentService.saveCommentToMeal(commentRequest, id);
		return "redirect:/meal/{id}";
	}
}