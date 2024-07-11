package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.service.OrderService;

@Controller
public class OrderController {
	private OrderService orderService;
    
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@GetMapping("/receipt")
	public String listOrders(Model model) {
		model.addAttribute("orders", orderService.getAllOrders());
		return "receipt";
	}
	
	@GetMapping("/checkout")
	public String createOrderForm(@ModelAttribute("currentProduct") Product currentProduct, Model model) {
		Order order = new Order();
		model.addAttribute("order", order);
		model.addAttribute("product", currentProduct);
		return "checkout";
	}
	
	@PostMapping("/receipt")
	public String saveOrder(@ModelAttribute("order") Order order) {
		orderService.saveOrder(order);
		return "redirect:/receipt";
	}
	
	@GetMapping("/receipt/edit/{id}")
	public String editOrderForm(@PathVariable Long id, Model model) {
		model.addAttribute("order", orderService.getOrderById(id));
		return"edit_order";
	}
	
	@PostMapping("/receipt/{id}")
	public String updateOrder(@PathVariable Long id, @ModelAttribute("order") Order order, Model model) {
		Order existingOrder = orderService.getOrderById(id);
		existingOrder.setId(id);
		existingOrder.setFirstName(order.getFirstName());
		existingOrder.setLastName(order.getLastName());
		existingOrder.setPhoneNumber(order.getPhoneNumber());
		existingOrder.setDeliveryAddress(order.getDeliveryAddress());
		existingOrder.setPostcode(order.getPostcode());
		existingOrder.setState(order.getState());
		orderService.updateOrder(existingOrder);
		return "redirect:/receipt";
	}
	
	@GetMapping("/receipt/{id}")
	public String deleteOrder(@PathVariable Long id) {
		orderService.deleteOrderById(id);
		return "redirect:/receipt";
	}
}
