package com.cdac.training.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BitPayController {
	
	@GetMapping("/bitpay")
	 public String viewProducts() {
	      return "bit_pay"; // returns logical name of View
	   }
	
	// Request -->FC-> Controller ---> Response(views- jsp)
		@GetMapping("/") // Mapping to root of Web App
		public String viewHomePage() {
		        
		    return "index"; // return jsp views
		}
	
}
