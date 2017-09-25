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
import kum.model.request.TableRequest;
import kum.service.CafeService;
import kum.service.CommentService;
import kum.service.OpenCloseService;
import kum.service.TableService;

@Controller
@RequestMapping("/cafe")
@SessionAttributes("cafe")
public class AdminCafeController {

	private final CafeService cafeService;
	private final CommentService commentService;
	private final OpenCloseService openService;
	private final TableService tableService;
	
	@Autowired
	public AdminCafeController(CafeService cafeService, CommentService commentService, OpenCloseService openService,
			TableService tableService) {
		this.cafeService = cafeService;
		this.commentService = commentService;
		this.openService = openService;
		this.tableService = tableService;
	}

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
	 
	@GetMapping("/{id}/tables")
	public String showTableByCafeId(@PathVariable Integer id, Model model){
		model.addAttribute("tables", tableService.findTablesBycafeId(id));
		return "table";
	}
	
	@GetMapping("/{id}/tables/{id}")
	public String showOneTableByCafeId(@PathVariable Integer id, Model model){
		model.addAttribute("table", tableService.reserveOneTableByCafeId(id));
			return "form_to_reserve_table";
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

	//	For form to reserv table
	
	@ModelAttribute("user")
	public TableRequest getFormUser() {
		return new TableRequest();
	}
	
	@PostMapping("/{id}/tables/{id}")
	public String reserveTable(@ModelAttribute("user") TableRequest tableRequest, Model model, @PathVariable Integer id){
		tableService.saveUserInTable(tableRequest, id);
		return  showTableByCafeId(tableService.findOneCafeByTableId(id).getCafe().getId(), model);
	}
}
