package kum.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kum.model.request.TableRequest;
import kum.service.CafeService;
import kum.service.TableService;

@Controller
@RequestMapping("/profile/ownCafe/{idCafe}/tables")
@SessionAttributes("table")
public class AdministratorTableController {

	
	private final TableService tableService;
	private final CafeService cafeService;
	 
	
	@Autowired
	public AdministratorTableController(TableService tableService, CafeService cafeService) {
		this.tableService = tableService;
		this.cafeService = cafeService;
	}
	
	@ModelAttribute("table")
	public TableRequest getForm() {
		return new TableRequest();
	}
	@GetMapping
	public String showOwnTables(Model model, @PathVariable Integer idCafe, Principal principal, Pageable pageable){
		model.addAttribute("cafe", cafeService.findOneCafe(idCafe));
		model.addAttribute("tables", tableService.findTablesBycafeId(idCafe, pageable));
		model.addAttribute("ownCafes", cafeService.findAllCafesByUser(principal.getName()));
		return "table_add";
	}
	
	@PostMapping
	public String save(@ModelAttribute("table") TableRequest request, SessionStatus status){
		tableService.save(request);
		return cancel(status);
	}
	
	@GetMapping("/{idTable}")
	public String showTableToDeReserve(@PathVariable Integer idTable){
		tableService.deSaveUserInTable(idTable);
		return "redirect:/profile/ownCafe/{idCafe}/tables";
	}
	
	@GetMapping("/{idTable}/delete")
	private String delete(@PathVariable Integer idTable)
	{tableService.delete(idTable);
	return "redirect:/profile/ownCafe/{idCafe}/tables";
	}
	
	@GetMapping("/update/{idTable}")
	public String update(@PathVariable Integer idCafe, @PathVariable Integer idTable, Model model, Principal principal, Pageable pageable) {
		model.addAttribute("table", tableService.findOne(idTable));
		return showOwnTables(model, idCafe, principal, pageable);
	}
		
	@GetMapping("/cancel")
	public String cancel(SessionStatus status){
	status.setComplete();
	return "redirect:/profile/ownCafe/{idCafe}/tables";
	}
	
}
