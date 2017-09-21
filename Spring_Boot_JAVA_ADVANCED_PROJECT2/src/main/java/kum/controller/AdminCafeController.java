package kum.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kum.entity.Type;
import kum.model.request.CafeRequest;
import kum.model.request.CommentRequest;
import kum.service.CafeService;
import kum.service.CommentService;
import kum.service.OpenCloseService;

@Controller
@RequestMapping("/cafe")
@SessionAttributes("cafe")
public class AdminCafeController {

	@Autowired
	private CafeService cafeService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private OpenCloseService openService;

	
	@ModelAttribute("cafe")
	public CafeRequest getForm(){
		return new CafeRequest();
	}
	
	@GetMapping("/my")
	public String showMyCafe(Model model, Principal principal){
		model.addAttribute("cafes", cafeService.findAllViews());
		return "cafe";
	}
	
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("types", Type.values());
		model.addAttribute("times", openService.findAllTimes());
		model.addAttribute("cafes", cafeService.findAllIndexViews());
		return "cafe";
	}
	@GetMapping("/{id}")
	public String showIndex(@PathVariable Integer id, Model model){
		model.addAttribute("cafesId", cafeService.findCafeViewId(id));
		model.addAttribute("comments", commentService.findCommentByCafeId(id));
		return "cafeindex";
		}
	 

	
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
