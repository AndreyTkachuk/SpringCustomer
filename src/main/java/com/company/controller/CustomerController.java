package com.company.controller;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.company.model.Customer;
import com.company.service.CustomerService;




@Controller
public class CustomerController {
	
	@Autowired
	public CustomerService service;
	
	
	@RequestMapping("/index")
	public String viewHomePage(Model model) {
		List<Customer> listCustomers = service.listAll();
		model.addAttribute("listCustomers", listCustomers);
		
		
	return "index";
	
	

   }
	
	@RequestMapping("/new")
	public String showNewCustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "new_customer";

	}
	
	
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute ("customer") Customer customer) {
		service.save(customer);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showNewCustomerForm(@PathVariable (name = "id") Long id) {
		ModelAndView nav = new ModelAndView("edit_customer");
		Customer customer = service.get(id);
		nav.addObject("customer", customer);
		
		return nav;
  }
	
	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable (name = "id") Long id) {
		service.delete(id);
		
		
		return "redirect:/";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		ModelAndView nav = new ModelAndView("search");
		List<Customer> result = service.search(keyword);
		nav.addObject("result", result);
		
		
		return nav;
	
	}
	
	

}