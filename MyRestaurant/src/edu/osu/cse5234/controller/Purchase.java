package edu.osu.cse5234.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.osu.cse5234.model.*;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	//ITEMS
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order ord = new Order();
		Item[] items = new Item[5];
		
		items[0] = new Item();
		items[0].setName("Pumpkin pie");
		items[0].setPrice("5.00");
		
		items[1] = new Item();
		items[1].setName("Apple pie");
		items[1].setPrice("4.00");
		
		items[2] = new Item();
		items[2].setName("Double chocolate chunk cake");
		items[2].setPrice("7.00");
		
		items[3] = new Item();
		items[3].setName("Deluxe granola bar");
		items[3].setPrice("10.00");
		
		items[4] = new Item();
		items[4].setName("Hardtack");
		items[4].setPrice("0.20");
		
		ArrayList<Item> lst = new ArrayList<>();
		
		for (Item i : items) {
			lst.add(i);
		}
		
		ord.setItems(lst);
		
		request.setAttribute("order", ord);
		
		return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}
	
	//PAYMENT
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());	
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/shippingEntry";
	}
	
	//SHIPPING
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("shipping", new ShippingInfo());	
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/viewOrder";
	}
	
	//ORDER
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrderPage(HttpServletRequest request, HttpServletResponse response) {
		//request.setAttribute("shipping", new ShippingInfo());	
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(@ModelAttribute("order") Order order, HttpServletRequest request) {
		//request.getSession().setAttribute("order", order);
		return "redirect:/purchase/viewConfirmation";
	}

	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(@ModelAttribute("order") Order order, HttpServletRequest request) {
		//request.getSession().setAttribute("order", order);
		return "Confirmation";
	}
}
