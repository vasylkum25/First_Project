package kum.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kum.model.view.CafeIndexView;
import kum.service.CafeService;

@Controller
public class MainController {

	@Autowired
	public CafeService service;

	public MainController(CafeService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String show(Model model, Principal principal) {
		List<CafeIndexView> indexViews = service.findAllIndexViews();
		int i = 0;
		if (!indexViews.isEmpty()) {
			for(CafeIndexView cafe : indexViews ){
				if(cafe.getRate()==null){
					cafe.setRate(BigDecimal.ZERO);
				}}
			indexViews.sort((c1, c2) -> c2.getRate().compareTo(c1.getRate()));
			List<CafeIndexView> topFifs = new ArrayList<>();
			if (indexViews.size() > 5) {
				while (i < 5) {
					topFifs.add(indexViews.get(i));
					i++;
				}
				model.addAttribute("topFifse", topFifs);
			} else {
				model.addAttribute("topFifse", indexViews);
			}
		}

		return "index";
	}

	@GetMapping("/admin")
	public String index() {
		return "admin";
	}

}
