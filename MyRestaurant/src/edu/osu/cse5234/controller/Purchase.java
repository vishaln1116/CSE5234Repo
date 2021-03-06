package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.business.OrderProcessingServiceBean;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;

@Controller
@RequestMapping("/purchase")
public class Purchase {

    //ITEMS
    @RequestMapping(method = RequestMethod.GET)
    public String viewOrderEntryForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
		InventoryService is = ServiceLocator.getInventoryService();
		Order o = new Order();
		o.setItems(is.getAvailableInventory().getItems());
		
		if (request.getSession().getAttribute("isInvalidOrder") == null) {
			request.getSession().setAttribute("isInvalidOrder", false);
		}
		request.setAttribute("order", o);
		
		return "OrderEntryForm";
    }

    @RequestMapping(path = "/submitItems", method = RequestMethod.POST)
    public String submitItems(@ModelAttribute("order") Order order,
            HttpServletRequest request) {
        order.recalculateTotalPrice();
        
        OrderProcessingServiceBean os = ServiceLocator.getOrderProcessingService();
        if (!os.validateItemAvailability(order)) {
        	request.getSession().setAttribute("isInvalidOrder", true);
        	return "redirect:/purchase";
        }else {
        	request.getSession().setAttribute("order", order);
        	return "redirect:/purchase/paymentEntry";
        }
    }

    //PAYMENT
    @RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
    public String viewPaymentEntryPage(HttpServletRequest request,
            HttpServletResponse response) {
        request.setAttribute("payment", new PaymentInfo());
        return "PaymentEntryForm";
    }

    @RequestMapping(path = "/purchase/submitPayment", method = RequestMethod.POST)
    public String submitPayment(@ModelAttribute("payment") PaymentInfo payment,
            HttpServletRequest request) {
        request.getSession().setAttribute("payment", payment);
        return "redirect:/purchase/shippingEntry";
    }

    //SHIPPING
    @RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
    public String viewShippingEntryPage(HttpServletRequest request,
            HttpServletResponse response) {
        request.setAttribute("shipping", new ShippingInfo());
        return "ShippingEntryForm";
    }

    @RequestMapping(path = "/purchase/submitShipping", method = RequestMethod.POST)
    public String submitShipping(
            @ModelAttribute("shipping") ShippingInfo shipping,
            HttpServletRequest request) {
        request.getSession().setAttribute("shipping", shipping);
        return "redirect:/purchase/viewOrder";
    }

    //ORDER
    @RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
    public String viewOrderPage(HttpServletRequest request,
            HttpServletResponse response) {
        return "ViewOrder";
    }

    @RequestMapping(path = "/purchase/confirmOrder", method = RequestMethod.POST)
    public String confirmOrder(@ModelAttribute("order") Order order,
            HttpServletRequest request) {
    	
    	OrderProcessingServiceBean os = ServiceLocator.getOrderProcessingService();
    	String confirmationCode = os.processOrder(order);
    	request.getSession().setAttribute("confirmationCode", confirmationCode);
        return "redirect:/purchase/viewConfirmation";
    }

    //COFIRMATION
    @RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
    public String viewConfirmation(HttpServletRequest request,
            HttpServletResponse response) {
        return "Confirmation";
    }

}
