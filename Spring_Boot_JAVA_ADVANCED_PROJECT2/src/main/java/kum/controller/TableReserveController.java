package kum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import kum.model.request.ReserveRequest;
import kum.service.TableService;

@Controller
@RequestMapping("/cafe")
public class TableReserveController {

	private final TableService tableService;
	
	@Autowired
	public TableReserveController(TableService tableService) {
		this.tableService = tableService;
	}
	//	For form to reserve table
	
	@ModelAttribute("user")
	public ReserveRequest getFormUser() {
		return new ReserveRequest();
	}
	
	@PostMapping("/{idCafe}/tables/{idTable}")
	public String reserveTable(@ModelAttribute("user") @Valid ReserveRequest reserveRequest, BindingResult br, Model model, @PathVariable Integer idTable, @PathVariable Integer idCafe, @PageableDefault Pageable pageable, SessionStatus session){
		if(br.hasErrors()) return showOneTableByCafeId(idTable, idCafe, model);
		tableService.saveUserInTable(reserveRequest, idTable);
		return  cancelReserve(session);
	}
	
	@GetMapping("/{idCafe}/tables/{idTable}")
	public String showOneTableByCafeId(@PathVariable Integer idTable, @PathVariable Integer idCafe, Model model){
		model.addAttribute("tableId", idTable);
		model.addAttribute("cafeId", idCafe);
		return "form_to_reserve_table";
	}
	
	@GetMapping("/{idCafe}/tables")
	public String showTableByCafeId(@PathVariable Integer idCafe, Model model,  @PageableDefault Pageable pageable){
		model.addAttribute("tables", tableService.findTablesBycafeId(idCafe, pageable));
		return "table";
	}
	
	@GetMapping("/{idCafe}/tables/cancel")
	public String cancelReserve(SessionStatus session){
		session.setComplete();
		return "redirect:/cafe/{idCafe}/tables";
	}
	
}
