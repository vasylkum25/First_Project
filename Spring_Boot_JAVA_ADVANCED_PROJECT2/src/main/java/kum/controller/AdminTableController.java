package kum.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import kum.service.TableService;

@Controller
@RequestMapping("/admin/table")
@SessionAttributes("table")
public class AdminTableController {

	
	@Autowired
	private final TableService tableService;
	 
	@ModelAttribute("table")
	public TableRequest getForm() {
		return new TableRequest();
	}

	@Autowired
	public AdminTableController(TableService tableService) {
		this.tableService = tableService;
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("cafes", tableService.findAllCafes());
		model.addAttribute("tables", tableService.findAllTables());
		return "table_add";
	}
	
	@GetMapping("/{id}")
	public String showTableToDeReserve(Model model, @PathVariable Integer id){
		
		return "table_add";
	}
	
	@PostMapping
	public String save(@ModelAttribute("table") TableRequest request, SessionStatus status){
		tableService.save(request);
		return cancel(status);
	}
	
	@GetMapping("/delete/{id}")
	private String delete(@PathVariable Integer id)
	{tableService.delete(id);
	return "redirect:/admin/table";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("table", tableService.findOne(id));
		return show(model);
	}
		
	@GetMapping("/cancel")
	public String cancel(SessionStatus status){
	status.setComplete();
	return "redirect:/admin/table";
}
}
