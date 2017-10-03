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

import kum.model.filter.SimpleFilter;
import kum.model.request.CommentRequest;
import kum.service.CommentService;
import kum.service.MealService;

@Controller
@RequestMapping("/meal")
@SessionAttributes("meal")
public class MealController {

	private final MealService mealService;
	
	@Autowired
	private CommentService commentService;
	
	
	@Autowired
	public MealController(MealService mealService) {
		this.mealService = mealService;
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("meals", mealService.findAllViews(pageable, filter));
		return "meals";
	}
	
	@GetMapping("/{id}")
	public String showIndexMeal(Model model, @PathVariable Integer id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
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