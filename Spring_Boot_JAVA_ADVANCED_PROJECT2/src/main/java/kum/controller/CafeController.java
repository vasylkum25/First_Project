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
public class CafeController {

	private final CafeService cafeService;
	private final CommentService commentService;
	private final OpenCloseService openService;
	private final TableService tableService;
	
	@Autowired
	public CafeController(CafeService cafeService, CommentService commentService, OpenCloseService openService,
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

	//	For form to reserve table
	
	@ModelAttribute("user")
	public TableRequest getFormUser() {
		return new TableRequest();
	}
	
	@PostMapping("/{idCafe}/tables/{idTable}")
	public String reserveTable(@ModelAttribute("user") @Valid TableRequest tableRequest, BindingResult br, Model model, @PathVariable Integer idTable, @PathVariable Integer idCafe){
		if(br.hasErrors()) return showOneTableByCafeId(idTable, model);
		tableService.saveUserInTable(tableRequest, idTable);
		return  showTableByCafeId(idCafe, model);
	}
	
	@GetMapping("/{idCafe}/tables/{idTable}")
	public String showOneTableByCafeId(@PathVariable Integer idTable, Model model){
		model.addAttribute("tables", tableService.findOne(idTable));
		model.addAttribute("table", tableService.reserveOneTableByCafeId(idTable));
		return "form_to_reserve_table";
	}
	
	@GetMapping("/{id}/tables")
	public String showTableByCafeId(@PathVariable Integer id, Model model){
		model.addAttribute("tables", tableService.findTablesBycafeId(id));
		return "table";
	}
}
