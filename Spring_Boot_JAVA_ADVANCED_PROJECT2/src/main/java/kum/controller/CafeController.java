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

import kum.model.filter.CafeFilter;
import kum.model.filter.SimpleFilter;
import kum.model.request.CommentRequest;
import kum.repository.CafeViewRepository;
import kum.repository.MealRepository;
import kum.service.CafeService;
import kum.service.CommentService;
import kum.service.MealService;

@Controller
@RequestMapping("/cafe")
@SessionAttributes("cafe")
public class CafeController {

	private final CafeService cafeService;
	private final CommentService commentService;
	private final MealService mealService;
	
	@Autowired
	public CafeController(CafeService cafeService, CommentService commentService, MealService mealService) {
		this.cafeService = cafeService;
		this.commentService = commentService;
		this.mealService = mealService;
	}

	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@ModelAttribute("cafeFilter")
	public CafeFilter getCafeFilter(){
		return new CafeFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter, @ModelAttribute("cafeFilter") CafeFilter cafeFilter){
		model.addAttribute("meals", mealService.findAll());
		model.addAttribute("cafes", cafeService.findAll(cafeFilter, pageable));
		return "cafe";
	}
	@GetMapping("/{id}")
	public String showIndex(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("cafesId", cafeService.findCafeViewId(id));
		model.addAttribute("comments", commentService.findCommentByCafeId(id));
		return "cafeindex";
		}

	
//	For comment
	
	@ModelAttribute("comment")
	public CommentRequest getFormComment() {
		return new CommentRequest();
	}
	
	@PostMapping("/{id}")
	public String saveComment(@ModelAttribute("comment") CommentRequest commentRequest, @PathVariable Integer id){
		commentService.saveCommentToCafe(commentRequest, id);
		return "redirect:/cafe/{id}";
	}

	
}









