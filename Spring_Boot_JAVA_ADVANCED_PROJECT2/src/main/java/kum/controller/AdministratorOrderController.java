package kum.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kum.entity.Order;
import kum.model.filter.SimpleFilter;
import kum.service.IngredientService;
import kum.service.MealService;
import kum.service.OrderService;
import kum.service.TableService;

@Controller
@RequestMapping("/profile")
@SessionAttributes("order")
public class AdministratorOrderController {

	private final MealService mealService;
	private final IngredientService ingredientService;
	private final TableService tableService;
	private final OrderService orderService;
	
	@Autowired
	public AdministratorOrderController(MealService mealService, IngredientService ingredientService, TableService tableService,
			OrderService orderService) {
		this.mealService = mealService;
		this.ingredientService = ingredientService;
		this.tableService = tableService;
		this.orderService = orderService;
	}


	@ModelAttribute("order")
	public Order getForm(){
		return new Order();
	}
	
	
	@GetMapping("/ownCafe/{cafeId}/table/{tableId}/order")
	public String addOrder(Model model, Principal principal, @PageableDefault Pageable pageable, @PathVariable Integer tableId, @PathVariable Integer cafeId){
		model.addAttribute("meals", orderService.saveTableInOrder(pageable, tableId, cafeId));
		model.addAttribute("table", tableService.findOne(tableId));
		return "order";
	}
	
	@GetMapping("/ownCafe/{cafeId}/table/{tableId}/order/{mealId}")
	public String saveMealInOrder(Model model, @PageableDefault Pageable pageable, @PathVariable Integer cafeId, @PathVariable Integer mealId, @PathVariable Integer tableId){
		orderService.saveMealInOrder(tableId, mealId);
		model.addAttribute("meals", mealService.findAllMealsByCafeId(cafeId, pageable));
		model.addAttribute("table", tableService.findOne(tableId));
		System.out.println("Save");
		return "order";
	}
	
	@GetMapping("/orders")
	public String show(Model model, Principal principal, @PageableDefault Pageable pageable){
		model.addAttribute("orders", orderService.findAll());
//		model.addAttribute("meals", mealService.findAllMealsByUser(principal.getName(), pageable));
		return "orders";
	}
	
	
	private String buildParams(Pageable pageable, SimpleFilter filter) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!= Direction.ASC)
				buffer.append(",desc");
			});
		}
		buffer.append("&search=");
		buffer.append(filter.getSearch());
		return buffer.toString();
	}
	
	
	
	
}
