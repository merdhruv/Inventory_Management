package com.cdac.training.inventory.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.training.inventory.model.Product;
import com.cdac.training.inventory.model.User;
import com.cdac.training.inventory.service.ProductService;
import com.cdac.training.inventory.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private ProductService pService;
	
	// Request --> Controller ---> Response(views- jsp)
		@GetMapping("/register")
		public String viewRegisterPage(Model model) {
			 User u = new User();
			    model.addAttribute("user", u);
			      return "register"; //model+view   
		}
		
		// Request --> Controller ---> Service--> UserRepository--> JPA Repository -->
		// UserRepository-->Service ---> Controller ---> Response(views- jsp)
		@PostMapping("/saveUser")
		public String saveDealer(@ModelAttribute("user") User u) {
						
			uService.saveUser(u); // interacts with service layer for db logic implementation
			return "index";
		}
		
		@GetMapping("/login")
		public String showLoginForm(Model theModel) {
			
			return "login";
		}
		
		@PostMapping("/loginUser")
		public ModelAndView loginDealer(HttpServletRequest req,@ModelAttribute("euser") User user) {
			String email=req.getParameter("email");
			String pass=req.getParameter("password");
			String pass2=encryptPass(pass);  //invokes encryptPass() method
			
			StringTokenizer st = new StringTokenizer(email, "@"); // breaks the email id based on '@' token
			String s2 = st.nextToken(); //email id without domain
			
			 ModelAndView mav=null;
			User u= uService.findByEmail(email); // Checks user exists or not
			 
			 if(u==null) {
				 mav= new ModelAndView("login");
					mav.addObject("error", "User Doesn't Exists");
			 }
			 else  if(email.equals(u.getEmail()) && pass2.equals(u.getPassword()))
			 {
						 
			 req.getSession().setAttribute("user", s2);	// creating a session
			 
			  mav = new ModelAndView("products");
			 mav.addObject("user", u);
			 
			 List<Product> listProducts = pService.listAll();
			    mav.addObject("listProducts", listProducts);
		     		    
			 } 
			 
			 else
			 {mav= new ModelAndView("login");
				mav.addObject("error", "Invalid  Password");
			 }
			 
			 return mav;
		}
		
		private String encryptPass(String pass) {
			Base64.Encoder encoder = Base64.getEncoder();
			String normalString = pass;
			String encodedString = encoder.encodeToString(
		    normalString.getBytes(StandardCharsets.UTF_8) );
			return encodedString;
		}

		@GetMapping("/logout")
		public String logout(HttpServletRequest req) {
			req.getSession().removeAttribute("euser");
			req.getSession().invalidate();
			return  "index";
		}
}
